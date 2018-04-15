package com.LeeYUBlog.core.model.common;

public class Criteria {
	
	private int startIndex = 0;
	private int maxCount = 0;
	private String code;
	
	private CriteriaOrderBy orderBy = CriteriaOrderBy.DESC;

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CriteriaOrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(CriteriaOrderBy orderBy) {
		this.orderBy = orderBy;
	}
}
