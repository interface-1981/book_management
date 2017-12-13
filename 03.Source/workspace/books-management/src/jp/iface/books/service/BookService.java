package jp.iface.books.service;

import java.util.List;

import jp.iface.books.dto.BookDto;
import jp.iface.books.dto.BookSearchDto;

public interface BookService  {

	/**
	 *
	 * @param bookSearchDto 図書検索画面入出力情報
	 * @return 図書データ一覧
	 */
	public List<BookDto> getBookList(BookSearchDto bookSearchDto) ;

	/**
	 * ISBNをキーに図書マスタから図書データを取得する
	 *
	 * @param isbn ISBNコード（13桁）
	 * @return 図書データ一覧
	 */
	public BookDto getBook(String isbn) ;

	/**
	 * ISBNをキーに外部サービスのAPIを利用し図書データを取得する
	 *
	 * @param isbn ISBNコード（13桁）
	 * @return 図書データ
	 */
	public BookDto getBookDataFromWebAPI(String isbn) ;

	/**
	 * 引数の図書データを図書マスタに登録する
	 *
	 * @param bookDto 図書データ
	 */
	public void registBook(BookDto bookDto) ;

	/**
	 * 引数の図書データ一覧を図書マスタに登録する
	 *
	 * @param bookDtoList 図書データ一覧
	 */
	public void bulkRegistBook(List<BookDto> bookDtoList) ;

}
