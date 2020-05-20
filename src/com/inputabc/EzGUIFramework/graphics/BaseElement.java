package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;
/**
 * 元素基类
 * @author gaoweiyi
 * @version 1.0
 */
public abstract class BaseElement {	
	private Color color;

	public BaseElement(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	
}
