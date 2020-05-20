package com.inputabc.EzGUIFramework.context;

import java.util.UUID;
/**
 * 
 * @author gaoweiyi
 *
 */
@SuppressWarnings("rawtypes")
public class ExceptionInfo {
	private String iid;
	
	private Class exceptionClass;
	private String eid;
	private String msg;
	
	public ExceptionInfo(Class exceptionClass, String eid, String msg) {
		this.iid = UUID.randomUUID().toString();
		this.exceptionClass = exceptionClass;
		this.eid = eid;
		this.msg = msg;
	}
	public String getIid() {
		return iid;
	}
	public Class getExceptionClass() {
		return exceptionClass;
	}
	public void setExceptionClass(Class exceptionClass) {
		this.exceptionClass = exceptionClass;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
