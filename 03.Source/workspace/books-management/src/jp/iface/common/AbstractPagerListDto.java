package jp.iface.common;

public abstract class AbstractPagerListDto {

	public final String ACTION_INIT = "init";
	public final String ACTION_NEXT = "next";
	public final String ACTION_PREVIEW = "preview";

	private long recordCount;
	private int pageDisplayCount;
	private int currentPage;
	private String pagerAction;


	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageDisplayCount() {
		return pageDisplayCount;
	}
	public void setPageDisplayCount(int pageDisplayCount) {
		this.pageDisplayCount = pageDisplayCount;
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

		return (currentPage -1) * pageDisplayCount;
	}

	public long getMaxPage() {
		if (recordCount % pageDisplayCount == 0) {
			return recordCount / (long)pageDisplayCount;
		} else {
			return (recordCount / (long)pageDisplayCount) + 1;
		}
	}
}
