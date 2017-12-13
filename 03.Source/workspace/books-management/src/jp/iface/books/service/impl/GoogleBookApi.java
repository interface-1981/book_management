package jp.iface.books.service.impl;

import com.google.gson.Gson;

import jp.iface.books.dto.BookDto;
import jp.iface.books.dto.GoogleBooksApiResponseDto;
import jp.iface.books.service.BookApi;

public class GoogleBookApi extends BookApi {

	public GoogleBookApi() {
		super.setWebApiType(1);
		super.setWebApiUrl("https://www.googleapis.com/books/v1/volumes?q=isbn:");

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

		Gson gson = new Gson();
		GoogleBooksApiResponseDto res = gson.fromJson(responseData, GoogleBooksApiResponseDto.class);

		BookDto bookDto = null;

		if (res.getTotalItems() != 0) {

			bookDto = new BookDto();
			bookDto.setIsbn(isbn);
			bookDto.setTitle(res.getItems().get(0).getVolumeInfo().getTitle());
			String subtitle = res.getItems().get(0).getVolumeInfo().getSubtitle();
			if (subtitle != null && !subtitle.equals("")) {
				bookDto.setTitle(bookDto.getTitle() + " - " + subtitle);
			}

			String authors = null;
			for(String author : res.getItems().get(0).getVolumeInfo().getAuthors()) {

				if (authors == null) {
					authors = author;
				} else {
					authors += "/" + author;
				}
			}
			bookDto.setAuthor(authors);
			bookDto.setPublicationDate(util.convertDate(res.getItems().get(0).getVolumeInfo().getPublishedDate(),"yyyy-MM"));
			bookDto.setPublisher(res.getItems().get(0).getVolumeInfo().getPublisher());
			bookDto.setPageCount(res.getItems().get(0).getVolumeInfo().getPageCount());
			bookDto.setContents(res.getItems().get(0).getVolumeInfo().getDescription());
			if (res.getItems().get(0).getVolumeInfo().getImageLinks() != null) {
				bookDto.setFileImgUrl(res.getItems().get(0).getVolumeInfo().getImageLinks().getThumbnail());
			}

		}
		return bookDto;

	}

}
