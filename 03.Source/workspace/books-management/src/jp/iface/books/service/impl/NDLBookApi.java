package jp.iface.books.service.impl;

import java.io.ByteArrayInputStream;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import jp.iface.books.dto.BookDto;
import jp.iface.books.service.BookApi;

public class NDLBookApi extends BookApi {

	public NDLBookApi() {
		super.setWebApiType(2);
		super.setWebApiUrl("http://iss.ndl.go.jp/api/opensearch?isbn=");

	}
	@Override
	public BookDto getBookData(String isbn) {

		BookDto bookDto = null;

		String responseData = super.requestWebApi(isbn);
		if (!util.isEmpty(responseData)) {
			bookDto = convertBookDto(responseData, isbn);
		}

		return bookDto;
	}

	private BookDto convertBookDto(String responseData, String isbn) {

		BookDto bookDto = null;

		//responseData = responseData.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		try {
			Document document= DocumentBuilderFactory
			        .newInstance()
			        .newDocumentBuilder()
			        .parse(new InputSource(new ByteArrayInputStream(responseData.getBytes("UTF-8"))));

			NodeList list = document.getFirstChild().getChildNodes();
			for(int i = 0; i < list.getLength(); ++i ) {
				//System.out.println(list.item(i).getNodeName());
				if (list.item(i).getNodeName().equals("channel")) {
					NodeList list2 = list.item(i).getChildNodes();
					for(int j = 0; j < list2.getLength(); ++j ) {

						if (list2.item(j).getNodeName().equals("item")) {
							if (bookDto == null) {
								bookDto = new BookDto();
								bookDto.setIsbn(isbn);
							}
							NodeList list3 = list2.item(j).getChildNodes();
							for(int k = 0; k < list3.getLength(); ++k ) {

								String name = list3.item(k).getNodeName();
								if (name.endsWith("title")) {
									bookDto.setTitle(list3.item(k).getFirstChild().getNodeValue());

								} else if (name.endsWith("volume")) {

									bookDto.setVolume(list3.item(k).getFirstChild().getNodeValue());
								} else if (name.endsWith("creator")) {

									bookDto.setAuthor(list3.item(k).getFirstChild().getNodeValue());
								} else if (name.endsWith("pubDate")) {

									if (!util.isEmpty(list3.item(k).getFirstChild().getNodeValue())) {
										String d = list3.item(k).getFirstChild().getNodeValue().substring(5, 16).replaceAll(" ", "-");
										bookDto.setPublicationDate(util.convertDate(d, "dd-MMM-yyyy", Locale.ENGLISH));
									}
								} else if (name.endsWith("publisher")) {

									bookDto.setPublisher(list3.item(k).getFirstChild().getNodeValue());
								}

								//System.out.println(list3.item(k).getNodeName());
							}
						}

					}
				}

			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return bookDto;

	}

}
