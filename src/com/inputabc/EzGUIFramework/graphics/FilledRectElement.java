package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;
/**
 * 填充式的矩形元素类
 * @author gaoweiyi
 * @version 1.0
 */
public class FilledRectElement extends BaseElement {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public FilledRectElement(int x, int y, int width, int height,Color color) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public FilledRectElement(Color color){
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
