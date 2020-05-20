package com.inputabc.EzGUIFramework.context;

import java.awt.Component;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.inputabc.EzGUIFramework.listener.ListenerInfo;
import com.inputabc.EzGUIFramework.listener.exception.ListenerBindingException;

/**
 * 
 * @author 高伟益
 *
 */
public class EzGUIContext {
	//已绑定的监听器集合
	//监听器和活动方法总是一对一的关系
	public static Map<Component, Set<ListenerInfo>> bindListenerGroup = new Hashtable<Component, Set<ListenerInfo>>();
	@SuppressWarnings("rawtypes")
	public static Map<Class, Set<ExceptionInfo>> exceptionGroup = new HashMap<Class, Set<ExceptionInfo>>();
	static {
		/********* listenerBindingExceptionInfo ************/
		
		Set<ExceptionInfo> listenerBindingExceptionInfo = new HashSet<ExceptionInfo>();
		Class<ListenerBindingException> listenerBindingExceptionClass = ListenerBindingException.class;
		listenerBindingExceptionInfo
				.add(new ExceptionInfo(listenerBindingExceptionClass, "000001", "动作对象为空：请首先设置actionObj对象"));
		listenerBindingExceptionInfo
				.add(new ExceptionInfo(listenerBindingExceptionClass, "000002", "重复的动作方法：请确保动作方法的名字不能重复"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000003", "未找到合适的此方法"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000004", "该动作方法不支持该组件"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000005", "被绑定监听器的组件集合里找不到该组件"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000006", "该组件未绑定任何监听器"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000007", "该组件未绑定此监听器"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000008", "该组件未绑定与此action对象对应的监听器"));
		listenerBindingExceptionInfo.add(new ExceptionInfo(listenerBindingExceptionClass, "000008", "该组件未绑定与此action方法对应的监听器"));
		exceptionGroup.put(listenerBindingExceptionClass, listenerBindingExceptionInfo);
		
		/*** end ***/
		
	}
}
