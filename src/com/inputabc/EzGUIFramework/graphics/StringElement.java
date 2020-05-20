package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;
import java.awt.Font;
/**
 * 字符串元素类
 * @author gaoweiyi
 * @version 1.0
 */
public class StringElement extends BaseElement {
	private int x;
	private int y;
	private Font font;
	private String string;

	public StringElement(int x, int y, Font font, Color fontColor, String string) {
		super(fontColor);
		this.x = x;
		this.y = y;
		this.font = font;
		this.string = string;
	}
	public StringElement(int x, int y, Color fontColor, String string) {
		super(fontColor);
		this.x = x;
		this.y = y;
		this.font = null;
		this.string = string;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Font getFont() {
		return font;
	}

	public String getString() {
		return string;
	}

}
