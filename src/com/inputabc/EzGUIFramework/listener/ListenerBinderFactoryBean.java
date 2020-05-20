package com.inputabc.EzGUIFramework.listener;

import java.awt.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.inputabc.EzGUIFramework.context.EzGUIContext;
import com.inputabc.EzGUIFramework.listener.exception.ListenerBindingException;
import com.inputabc.EzGUIFramework.util.ExceptionUtils;

/**
 * 
 * @author 高伟益
 *
 */
public class ListenerBinderFactoryBean {
	protected ListenerBinder build(final Object actionObj) {
		final DefaultListenerBinder defaultListenerBinder = new DefaultListenerBinder();
		defaultListenerBinder.setActionObj(actionObj);
		return (ListenerBinder) Proxy.newProxyInstance(ListenerBinder.class.getClassLoader(),
				new Class[] { ListenerBinder.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
						if(m.getName().equals("unbind")){
							return defaultListenerBinder.unbind((Component)args[0], (String)args[1], args[2], (String)args[3],(Class[])args[4]);
						}
						Component c = (Component) args[0];
						String methodName = (String) args[1];
						boolean hasListenerMethod = false;
						Method[] methods = c.getClass().getMethods();
						a: for (Method method : methods) {
							if (method.getName().contains("add") && method.getName().contains("Listener")) {
								Class<?>[] parameterTypes = method.getParameterTypes();
								if (parameterTypes.length == 1) {// TODO 此处可能会不完善，要改进
									Method[] methods2 = parameterTypes[0].getMethods();
									for (Method method2 : methods2) {
										if (m.getName().equals(method2.getName())) {
											hasListenerMethod = true;// 被绑定的组件支持被监听此动作
											break a;
										}
									}
								}
							}
						}
						if (hasListenerMethod == false) {// 被绑定的组件本身不支持被监听此动作
							throw ExceptionUtils.getException(ListenerBindingException.class, "000004", null,
									"组件：" + c.getClass().getName() + "：" + "方法：" + m.getName());
						}
						m.setAccessible(true);
						m.invoke(defaultListenerBinder, args);
						EventListener currentListener = defaultListenerBinder.getCurrentListener();
						Class[] parameterTypes = defaultListenerBinder.getParameterTypes();
						addListenerInfoToContext(c, currentListener, m.getName(),actionObj, methodName,parameterTypes);
						return null;
					}
				});
	}

	protected void addListenerInfoToContext(Component c, EventListener listener, String listenerMethod,Object actionObj, String methodName,Class[] args) {
		Map<Component, Set<ListenerInfo>> bindListenerGroup = EzGUIContext.bindListenerGroup;
		ListenerInfo jListenerInfo = new ListenerInfo(c, listener, listenerMethod,actionObj, methodName,args);
		if (bindListenerGroup.containsKey(c)) {
			Set<ListenerInfo> infos = bindListenerGroup.get(c);
			infos.add(jListenerInfo);
		} else {
			HashSet<ListenerInfo> infos = new HashSet<ListenerInfo>();
			infos.add(jListenerInfo);
			bindListenerGroup.put(c, infos);
		}
	}

}
