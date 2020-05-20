package com.inputabc.EzGUIFramework.graphics.handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import com.inputabc.EzGUIFramework.graphics.FilledRectElement;
import com.inputabc.EzGUIFramework.graphics.ImageElement;
import com.inputabc.EzGUIFramework.graphics.RectElement;
import com.inputabc.EzGUIFramework.graphics.StretchedImageElement;
import com.inputabc.EzGUIFramework.graphics.StringElement;
/**
 * 用于进行绘制图形的工作，实现DrawingHandler接口
 * @author gaoweiyi
 * @version 1.0
 */
public class DrawingHandlerImpl implements DrawingHandler {

	@Override
	public void drawRect(Graphics g, JComponent com, RectElement rect) {
		g.setColor(rect.getColor());
		int x = rect.getX();
		int y = rect.getY();
		int width = rect.getWidth();
		int hight = rect.getHeight();
		g.drawRect(x>=0?x:(int)com.getAlignmentX(),y>=0?y:(int)com.getAlignmentY(),width>=0?width:com.getWidth(), hight>=0?hight:com.getHeight());
	}

	@Override
	public void fillRect(Graphics g, JComponent com, FilledRectElement fRect) {
		g.setColor(fRect.getColor());
		int x = fRect.getX();
		int y = fRect.getY();
		int width = fRect.getWidth();
		int hight = fRect.getHeight();
		g.fillRect(x>=0?x:(int)com.getAlignmentX(),y>=0?y:(int)com.getAlignmentY(),width>=0?width:com.getWidth(), hight>=0?hight:com.getHeight());
	}

	@Override
	public void drawImage(Graphics g, JComponent com, ImageElement image) {
		URL imageUrl = image.getImageUrl();
		String protocol = imageUrl.getProtocol();
		if("file".equals(protocol)){
			BufferedImage bImage;
			try {
				bImage = ImageIO.read(imageUrl);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			if(image instanceof StretchedImageElement){
				g.drawImage(bImage,(int)com.getAlignmentX(),(int)com.getAlignmentY(),com.getWidth(), com.getHeight(), image.getColor(), image.getImageObserver());
			}
		}
	}

	@Override
	public void drawString(Graphics g, JComponent com, StringElement string) {
		g.setColor(string.getColor());
		if(string.getFont()!=null){
			g.setFont(string.getFont());
		}
		g.drawString(string.getString(), string.getX(), string.getY());
	}

}
