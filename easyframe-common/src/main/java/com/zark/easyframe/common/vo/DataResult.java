package com.zark.easyframe.common.vo;

import java.util.Arrays;
import java.util.List;

public class DataResult<T> {
	private List<T> data;
	private int totalCount;
	private int currentPage;
	private boolean hasError;
	private List<String> errorMsgs;

	// 分页使用
	public DataResult(List<T> data, int totalCount, int currentPage) {
		super();
		this.data = data;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
	}

	// 返回数组使用
	public DataResult(List<T> data) {
		super();
		this.data = data;
		this.totalCount = data.size();
	}

	// 返回单个错误使用
	public DataResult(boolean hasError, String errorMsg) {
		super();
		this.hasError = hasError;
		this.errorMsgs = Arrays.asList(errorMsg);
	}

	// 返回多个错误使用
	public DataResult(boolean hasError, List<String> errorMsgs) {
		super();
		this.hasError = hasError;
		this.errorMsgs = errorMsgs;
	}

	public DataResult() {
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public List<String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

}
