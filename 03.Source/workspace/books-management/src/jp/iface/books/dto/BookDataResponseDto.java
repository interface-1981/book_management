package jp.iface.books.dto;

public class BookDataResponseDto {

	public enum Status {
		FOUND_MASTER_DB(101),
		FOUND_WEBSERVICE(102),
	    FORMAT_ERROR(201),
	    NOTFOUND_WEBSERVICE(301),

	    ;

	    private final int code;

	    private Status(final int code) {
	        this.code = code;
	    }

	    public int getCode() {
	        return this.code;
	    }
	}

	private BookDto bookData;
	private Status status;
	public int getStatusCode() {
		return status.getCode();
	}
	public BookDto getBookData() {
		return bookData;
	}
	public void setBookData(BookDto bookData) {
		this.bookData = bookData;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
