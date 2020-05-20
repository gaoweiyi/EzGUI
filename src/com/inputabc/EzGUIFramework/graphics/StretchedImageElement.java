package com.inputabc.EzGUIFramework.graphics;

import java.awt.Color;

import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;
/**
 * 拉伸效果的图片元素类
 * @author gaoweiyi
 * @version 1.0
 *
 */
public class StretchedImageElement extends ImageElement {

	public StretchedImageElement(File imageFile, Color color, ImageObserver imageObserver) {
		super(imageFile, -1, -1, -1, -1, color, imageObserver);
	}

	public StretchedImageElement(URL imageUrl, Color color, ImageObserver imageObserver) {
		super(imageUrl, -1, -1, -1, -1, color, imageObserver);
	}
}
