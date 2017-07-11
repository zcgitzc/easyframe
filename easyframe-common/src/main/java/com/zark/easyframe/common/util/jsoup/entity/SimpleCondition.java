package com.zark.easyframe.common.util.jsoup.entity;

/**
 * 
 * @author wb-zc189961
 *
 */
public class SimpleCondition {
	private String tagNameEq;
	private String classNameEq;
	private String idEq;
	private String containText;

	public SimpleCondition() {
	}

	public SimpleCondition(String tagNameEq, String classNameEq, String idEq, String containText) {
		super();
		this.tagNameEq = tagNameEq;
		this.classNameEq = classNameEq;
		this.idEq = idEq;
		this.containText = containText;
	}

	public String getTagNameEq() {
		return tagNameEq;
	}

	public void setTagNameEq(String tagNameEq) {
		this.tagNameEq = tagNameEq;
	}

	public String getClassNameEq() {
		return classNameEq;
	}

	public void setClassNameEq(String classNameEq) {
		this.classNameEq = classNameEq;
	}

	public String getIdEq() {
		return idEq;
	}

	public void setIdEq(String idEq) {
		this.idEq = idEq;
	}

	public String getContainText() {
		return containText;
	}

	public void setContainText(String containText) {
		this.containText = containText;
	}

}
