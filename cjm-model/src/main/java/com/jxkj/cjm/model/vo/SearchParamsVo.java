package com.jxkj.cjm.model.vo;

/**
 * 搜索查询条件bean
 * 
 * @author admin
 *
 */
public class SearchParamsVo {

	/**主题页码数**/
	private String pageNumThread;
	/**主题条数**/
	private String pageSizeThread;
	/**咨询页码数**/
	private String pageNumArticle;
	/**咨询条数**/
	private String pageSizeArticle;
	/**查询关键字**/
	private String subject;
	/**页码数**/
	private String indexNum;
	/**板块id**/
	private Long fid;
	
	public String getPageNumThread() {
		return pageNumThread;
	}

	public void setPageNumThread(String pageNumThread) {
		this.pageNumThread = pageNumThread;
	}

	public String getPageSizeThread() {
		return pageSizeThread;
	}

	public void setPageSizeThread(String pageSizeThread) {
		this.pageSizeThread = pageSizeThread;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public String getPageNumArticle() {
		return pageNumArticle;
	}

	public void setPageNumArticle(String pageNumArticle) {
		this.pageNumArticle = pageNumArticle;
	}

	public String getPageSizeArticle() {
		return pageSizeArticle;
	}

	public void setPageSizeArticle(String pageSizeArticle) {
		this.pageSizeArticle = pageSizeArticle;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}
	
	
}
