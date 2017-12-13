package jp.iface.books.dto;

public abstract class AbstractPagerListDto {

	public final String ACTION_INIT = "init";
	public final String ACTION_NEXT = "next";
	public final String ACTION_PREVIEW = "preview";

	private long recordCount;
	private int displayCount;
	private int currentPage;
	private String pagerAction;


	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public int getDisplayCount() {
		return displayCount;
	}
	public void setDisplayCount(int displayCount) {
		this.displayCount = displayCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getPagerAction() {
		return pagerAction;
	}
	public void setPagerAction(String pagerAction) {
		this.pagerAction = pagerAction;
	}

	public void pageInit() {
		pagerAction = ACTION_INIT;
		currentPage = 1;
	}
	public Integer getOffset() {

		if (pagerAction != null && pagerAction.equals(ACTION_PREVIEW)) {
			if (currentPage > 1) {
				--currentPage;
				pagerAction = null;
			}
		}else if (pagerAction != null && pagerAction.equals(ACTION_NEXT)) {
			if (currentPage < getMaxPage()) {
				++currentPage;
				pagerAction = null;
			}
		}else if (pagerAction != null && pagerAction.equals(ACTION_INIT)) {
			currentPage = 1;
			pagerAction = null;
		}

		return (currentPage -1) * displayCount;
	}

	public long getMaxPage() {
		if (recordCount % displayCount == 0) {
			return recordCount / (long)displayCount;
		} else {
			return (recordCount / (long)displayCount) + 1;
		}
	}
}
