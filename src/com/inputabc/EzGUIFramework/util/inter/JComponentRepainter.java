package com.inputabc.EzGUIFramework.util.inter;

import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * 用此接口的repaint方法来重绘组件
 * @author gaoweiyi
 * @version 1.0
 */
public interface JComponentRepainter {
	public void repaint(JComponent source,Graphics g);
}
