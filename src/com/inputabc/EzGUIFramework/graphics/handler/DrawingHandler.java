package com.inputabc.EzGUIFramework.graphics.handler;

import java.awt.Graphics;

import javax.swing.JComponent;

import com.inputabc.EzGUIFramework.graphics.FilledRectElement;
import com.inputabc.EzGUIFramework.graphics.ImageElement;
import com.inputabc.EzGUIFramework.graphics.RectElement;
import com.inputabc.EzGUIFramework.graphics.StringElement;
/**
 * 用于进行绘制图形的工作
 * @author gaoweiyi
 * @version 1.0
 */
public interface DrawingHandler {
	public void drawRect(Graphics g,JComponent com,RectElement rect);
	public void fillRect(Graphics g,JComponent com,FilledRectElement fRect);
	public void drawImage(Graphics g,JComponent com,ImageElement image);
	public void drawString(Graphics g,JComponent com,StringElement string);
}
