package com.inputabc.EzGUIFramework.component.factory;



import com.inputabc.EzGUIFramework.graphics.FilledRectElement;
import com.inputabc.EzGUIFramework.graphics.ImageElement;
import com.inputabc.EzGUIFramework.graphics.RectElement;
import com.inputabc.EzGUIFramework.graphics.StringElement;
/**
 * 用于创建自定义样式的组件
 * @author gaoweiyi
 * @version 1.0
 */
public interface JComponentFactory {
	/**
	 * 创建组件
	 * @param componentClass JComponent子类的Class对象
	 * @param rect 绘制矩形边框，不需要的话可以设为null
	 * @param fRect 绘制填充式的矩形，不需要的话可以设为null
	 * @param image 绘制图片，不需要的话可以设为null
	 * @param string 绘制字符串，不需要的话可以设为null
	 * @return
	 */
	public <T> T createComponent(final Class<T> componentClass,final RectElement rect, final FilledRectElement fRect, final ImageElement image,
			final StringElement string);
}
