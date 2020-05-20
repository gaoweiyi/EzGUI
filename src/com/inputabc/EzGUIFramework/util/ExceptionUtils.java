package com.inputabc.EzGUIFramework.util;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.inputabc.EzGUIFramework.context.ExceptionInfo;
import com.inputabc.EzGUIFramework.context.EzGUIContext;

public class ExceptionUtils {
	public static RuntimeException getException(Class<?> exceptionClass, String eid, String otherPreMsg,
			String otherAfterMsg) {
		Set<ExceptionInfo> infos = EzGUIContext.exceptionGroup.get(exceptionClass);
		for (ExceptionInfo info : infos) {
			if (info.getExceptionClass() == exceptionClass) {//再次确认一遍该异常info对象对应的异常类是想要获取的异常类
				if (eid.equals(info.getEid())) {
					try {

						if (StringUtils.isNotBlank(otherPreMsg) && StringUtils.isBlank(otherAfterMsg)) {
							return (RuntimeException) exceptionClass.getConstructor(String.class)
									.newInstance(otherPreMsg + " : " + info.getMsg());
						} else if (StringUtils.isNotBlank(otherPreMsg) && StringUtils.isNotBlank(otherAfterMsg)) {
							return (RuntimeException) exceptionClass.getConstructor(String.class)
									.newInstance(otherPreMsg + " : " + info.getMsg() + " : " + otherAfterMsg);
						} else if (StringUtils.isBlank(otherPreMsg) && StringUtils.isNotBlank(otherAfterMsg)) {
							return (RuntimeException) exceptionClass.getConstructor(String.class)
									.newInstance(info.getMsg() + " : " + otherAfterMsg);
						} else {
							return (RuntimeException) exceptionClass.getConstructor(String.class)
									.newInstance(info.getMsg());
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return new RuntimeException("Default EzGUI exception");
	}

}
