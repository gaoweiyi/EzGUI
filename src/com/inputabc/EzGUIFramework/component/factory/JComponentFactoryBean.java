package com.inputabc.EzGUIFramework.component.factory;

import java.awt.Graphics;

import java.lang.reflect.Method;

import javax.swing.JComponent;

import com.inputabc.EzGUIFramework.graphics.FilledRectElement;
import com.inputabc.EzGUIFramework.graphics.ImageElement;
import com.inputabc.EzGUIFramework.graphics.RectElement;
import com.inputabc.EzGUIFramework.graphics.StringElement;
import com.inputabc.EzGUIFramework.graphics.handler.DrawingHandler;
import com.inputabc.EzGUIFramework.graphics.handler.DrawingHandlerImpl;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 用于创建自定义样式的工厂的实现类
 * @author gaoweiyi
 * @version 1.0
 */
public class JComponentFactoryBean implements JComponentFactory {
	@SuppressWarnings("unchecked")
	@Override
	public <T> T createComponent(final Class<T> componentClass,final RectElement rect, final FilledRectElement fRect, final ImageElement image,
			final StringElement string) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(componentClass);

		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				if ("paintComponent".equals(arg1.getName())) {
					JComponent com = (JComponent)arg0;
					Graphics g = (Graphics) arg2[0];
					DrawingHandler dh = new DrawingHandlerImpl();
					if (rect != null) {
						dh.drawRect(g, com, rect);
					}
					if (fRect != null) {
						dh.fillRect(g, com, fRect);
					}
					if (image != null) {
						dh.drawImage(g, com, image);
					}
					if (string != null) {
						dh.drawString(g, com, string);
					}
					return null;
				}
				return arg3.invokeSuper(arg0, arg2);
			}

		});
		return (T) enhancer.create();
	}

	
}
