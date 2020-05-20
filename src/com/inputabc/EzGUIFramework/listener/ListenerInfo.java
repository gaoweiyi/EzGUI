package com.inputabc.EzGUIFramework.listener;

import java.awt.Component;
import java.util.EventListener;
import java.util.UUID;
/**
 * 监听器绑定信息
 * @author gaoweiyi
 *
 */
public class ListenerInfo {
	private String iid;//info对象的id
	private Component bindComponent; //已绑定的组件对象
	private EventListener bindListener;//已绑定的监听器对象
	private Object actionObj;//动作对象
	private String methodName;//动作对象的方法名
	private String listenerMethod;//监听器里的动作方法名
	private Class[] args;//动作方法的形参类型列表
	public ListenerInfo(Component bindComponent, EventListener bindListener,String listenerMethod, Object actionObj,
			String methodName,Class[] args) {
		this.iid = UUID.randomUUID().toString();
		this.bindComponent = bindComponent;
		this.bindListener = bindListener;
		this.listenerMethod = listenerMethod;
		this.actionObj = actionObj;
		this.methodName = methodName;
		this.args = args;
	}
	public String getIid() {
		return iid;
	}
	public Component getBindComponent() {
		return bindComponent;
	}
	public void setBindComponent(Component bindComponent) {
		this.bindComponent = bindComponent;
	}
	public EventListener getBindListener() {
		return bindListener;
	}
	public void setBindListener(EventListener bindListener) {
		this.bindListener = bindListener;
	}
	public Object getActionObj() {
		return actionObj;
	}
	public void setActionObj(Object actionObj) {
		this.actionObj = actionObj;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getListenerMethod() {
		return listenerMethod;
	}
	public void setListenerMethod(String listenerMethod) {
		this.listenerMethod = listenerMethod;
	}
	public Class[] getArgs() {
		return args;
	}
	public void setArgs(Class[] args) {
		this.args = args;
	}
	
}
