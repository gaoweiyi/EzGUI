package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 图片元素基类
 * @author gaoweiyi
 * @version 1.0
 */
public abstract class ImageElement extends BaseElement{
	private URL imageUrl;
	private int x;
	private int y;
	private int width;
	private int hight;
	private ImageObserver imageObserver;
	
	public ImageElement(URL imageUrl, int x, int y,int width,int hight, Color color,ImageObserver imageObserver) {
		super(color);
		this.imageUrl = imageUrl;
		this.x = x;
		this.y = y;
		this.width = width;
		this.hight = hight;
		this.imageObserver = imageObserver;
	}
	@SuppressWarnings("deprecation")
	public ImageElement(File imageFile, int x, int y,int width,int hight, Color color,ImageObserver imageObserver) {
		super(color);
		try {
			this.imageUrl = imageFile.toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.hight = hight;
		this.imageObserver = imageObserver;
	}
	public URL getImageUrl() {
		return imageUrl;
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
	public int getHight() {
		return hight;
	}
	public ImageObserver getImageObserver() {
		return imageObserver;
	}
	
	
}
