package com.inputabc.EzGUIFramework.listener;
/**
 * 
 * @author gaoweiyi
 *
 */
public class ListenerBinderFactory{
	public static ListenerBinder build(Object actionObj){
		return new ListenerBinderFactoryBean().build(actionObj);
	}
}
