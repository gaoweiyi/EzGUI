package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;
/**
 * 矩形边框元素类
 * @author gaoweiyi
 * @version 1.0
 */
public class RectElement extends BaseElement {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public RectElement(int x, int y, int width, int height,Color color) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public RectElement(Color color){
		super(color);
		this.x = -1;
		this.y = -1;
		this.width = -1;
		this.height = -1;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
