package com.inputabc.EzGUIFramework.listener;


import java.lang.reflect.Method;
import java.util.EventObject;

import org.apache.commons.lang3.ArrayUtils;

import com.inputabc.EzGUIFramework.listener.exception.ListenerBindingException;
import com.inputabc.EzGUIFramework.util.ExceptionUtils;

/**
 * 
 * @author 高伟益
 *
 */
public abstract class AbstractListenerBinder implements ListenerBinder {

	protected Class[] action(Object actionObj, String methodName, EventObject e, Object[] args) {
		if (actionObj == null) {
			throw ExceptionUtils.getException(ListenerBindingException.class, "000001", null, null);
		}
		Method[] methods = actionObj.getClass().getMethods();
		Method actionMethod = null;
		int methodCount = 0;
		// 检查是否在actiobObj对象中有methodName对应的方法，或是否只有唯一的该名字的该方法
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				actionMethod = method;
				methodCount++;
				if (methodCount > 1) {
					throw ExceptionUtils.getException(ListenerBindingException.class, "000002", null, null);
				}
			}
		}
		if (actionMethod == null) {
			throw ExceptionUtils.getException(ListenerBindingException.class, "000003",
					"在 " + actionObj.getClass().getName() + " 对象中", methodName);
		}
		Class<?>[] parameterTypes = actionMethod.getParameterTypes();
		if (parameterTypes.length > 0) {
			if (args==null || args.length==0) {
				if (parameterTypes.length > 1 || parameterTypes[0] != e.getClass()) {
					throw ExceptionUtils.getException(ListenerBindingException.class, "000003",
							"在 " + actionObj.getClass().getName() + " 对象中", methodName);
				}
				Class<?> parameterType = parameterTypes[0];
				if (parameterType != e.getClass()) {
					throw ExceptionUtils.getException(ListenerBindingException.class, "000003",
							"在 " + actionObj.getClass().getName() + " 对象中", methodName);
				}
				try {
					actionMethod.setAccessible(true);
					actionMethod.invoke(actionObj, e);
				} catch (Exception e1) {
					e1.printStackTrace();
					throw new RuntimeException(e1);
				}
			} else {
				int eventObjTypeIndex = -1;
				for (int x = 0; x < parameterTypes.length; x++) {

					if (parameterTypes[x] == e.getClass()) {
						eventObjTypeIndex = x;
						continue;
					}

				}
				if (eventObjTypeIndex >= 0) {

					args = ArrayUtils.insert(eventObjTypeIndex, args, e);
				}
				try {
					actionMethod.setAccessible(true);
					try {
						actionMethod.invoke(actionObj, args);
					} catch (Exception e1) {
						e1.printStackTrace();
						throw ExceptionUtils.getException(ListenerBindingException.class, "000003",
								"在 " + actionObj.getClass().getName() + " 对象中", methodName);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					throw new RuntimeException(e1);
				}
			}

		} else {
			try {
				actionMethod.setAccessible(true);
				actionMethod.invoke(actionObj);
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		}
		return parameterTypes;

	}

	
}
