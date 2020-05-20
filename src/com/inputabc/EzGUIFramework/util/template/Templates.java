package com.inputabc.EzGUIFramework.util.template;

import static com.inputabc.EzGUIFramework.util.EzGUI.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSeparator;


/**
 * 模板类
 * @author gaoweiyi
 * @version 1.0
 */
public class Templates {
	public Map<String, Component> template(int templateType) {
		Map<String, Component> components = new LinkedHashMap<String, Component>();
		JDialog jdialog = new JDialog();
		switch (templateType) {
		case TEMPLATE_SWING_DIALOG_1: {
			jdialog.setName("dialog");
			jdialog.setTitle("简单对话框");
			jdialog.setLayout(new BorderLayout());
			jdialog.setSize(400, 250);
			jdialog.setLocationRelativeTo(null);
			jdialog.setAlwaysOnTop(true);
			JPanel jpanel = new JPanel();//
			jpanel.setName("panel dialog");
			jpanel.setLayout(new BorderLayout());
			JPanel jpanel_north = new JPanel();//
			jpanel_north.setName("jpanel_center jpanel");
			jpanel_north.setBackground(Color.WHITE);
			jpanel.add(jpanel_north, BorderLayout.CENTER);
			JSeparator separator = new JSeparator();//
			separator.setName("separator verticalBox");
			separator.setOrientation(JSeparator.HORIZONTAL);
			Box verticalBox = Box.createVerticalBox();//
			verticalBox.setName("verticalBox panel");
			verticalBox.add(separator);
			verticalBox.add(Box.createVerticalStrut(15));
			Box horizontalBox = Box.createHorizontalBox();//
			horizontalBox.setName("horizontalBox verticalBox");
			JButton jbutton1 = new JButton("确定");//
			jbutton1.setName("button-确定 horizontalBox");
			JButton jbutton2 = new JButton("取消");//
			jbutton2.setName("button-取消 horizontalBox");
			jbutton1.setSize(80, 26);
			jbutton2.setSize(80, 26);
			horizontalBox.add(Box.createHorizontalGlue());
			horizontalBox.add(jbutton1);
			horizontalBox.add(Box.createHorizontalStrut(50));
			horizontalBox.add(jbutton2);
			horizontalBox.add(Box.createHorizontalGlue());
			verticalBox.add(horizontalBox);
			verticalBox.add(Box.createVerticalStrut(15));
			jpanel.add(verticalBox, BorderLayout.SOUTH);
			jdialog.setContentPane(jpanel);

			removeButtonDottedLine(jdialog);

			components.put(jdialog.getName(), jdialog);
			components.put(jpanel.getName(), jpanel);
			components.put(verticalBox.getName(), verticalBox);
			components.put(jpanel_north.getName(), jpanel_north);
			components.put(horizontalBox.getName(), horizontalBox);
			components.put(jbutton1.getName(), jbutton1);
			components.put(jbutton2.getName(), jbutton2);
			components.put(separator.getName(), separator);

		}
			break;
		case TEMPLATE_SWING_DIALOG_2: {
			jdialog.setName("dialog");
			jdialog.setTitle("简单对话框");
			jdialog.setLayout(new BorderLayout());
			jdialog.setSize(250, 300);
			jdialog.setLocationRelativeTo(null);
			jdialog.setAlwaysOnTop(true);
			JPanel jpanel = new JPanel();//
			jpanel.setName("panel dialog");
			jpanel.setLayout(new BorderLayout());
			Box verticalBox = Box.createVerticalBox();//
			verticalBox.setName("verticalBox panel");
			verticalBox.add(Box.createVerticalGlue());
			JButton jbutton1 = new JButton("选项一");//
			jbutton1.setName("button-选项一 verticalBox");
			JButton jbutton2 = new JButton("选项二");//
			jbutton2.setName("button-选项二 verticalBox");
			Box horizontalBox1 = Box.createHorizontalBox();
			horizontalBox1.add(Box.createHorizontalGlue());
			horizontalBox1.add(jbutton1);
			horizontalBox1.add(Box.createHorizontalGlue());
			verticalBox.add(horizontalBox1);
			verticalBox.add(Box.createVerticalGlue());
			Box horizontalBox2 = Box.createHorizontalBox();
			horizontalBox2.add(Box.createHorizontalGlue());
			horizontalBox2.add(jbutton2);
			horizontalBox2.add(Box.createHorizontalGlue());
			verticalBox.add(horizontalBox2);
			verticalBox.add(Box.createVerticalGlue());
			jpanel.add(verticalBox, BorderLayout.CENTER);
			jdialog.setContentPane(jpanel);

			removeButtonDottedLine(jdialog);

			components.put(jdialog.getName(), jdialog);
			components.put(jpanel.getName(), jpanel);
			components.put(verticalBox.getName(), verticalBox);
			components.put(jbutton1.getName(), jbutton1);
			components.put(jbutton2.getName(), jbutton2);

		}
			break;
		case TEMPLATE_AWT_DIALOG_1: {
			final Frame frame = new Frame("简单对话框");
			frame.setName("frame");
			frame.setLayout(new BorderLayout());
			frame.setSize(400, 250);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setAlwaysOnTop(true);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}
			});
			Panel panel_center = new Panel();
			panel_center.setName("panel_center frame");
			Panel panel_bottom = new Panel();
			panel_bottom.setName("panel_bottom frame");
			panel_bottom.setBackground(new Color(238, 238, 238));
			panel_bottom.setLayout(null);
			panel_bottom.setSize(frame.getWidth(), 60);
			Button button1 = new Button("确定");
			button1.setName("button-确定 panel_bottom");
			Button button2 = new Button("取消");
			button2.setName("button-取消 panel_bottom");
			button1.setBounds(90, 18, 80, 26);
			button2.setBounds(button1.getX() + button1.getWidth() + 52, button1.getY(), button1.getWidth(),
					button1.getHeight());
			button1.setFocusable(false);
			button2.setFocusable(false);
			panel_bottom.add(button1);
			panel_bottom.add(button2);

			frame.add(panel_center, BorderLayout.CENTER);
			frame.add(panel_bottom, BorderLayout.SOUTH);
			removeButtonDottedLine(frame);

			components.put(frame.getName(), frame);
			components.put(panel_center.getName(), panel_center);
			components.put(panel_bottom.getName(), panel_bottom);
			components.put(button1.getName(), button1);
			components.put(button2.getName(), button2);
		}
			break;
		}
		return components;
	}
}
