package com.inputabc.EzGUIFramework.util;


import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.TextComponent;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

import com.inputabc.EzGUIFramework.component.factory.JComponentFactory;
import com.inputabc.EzGUIFramework.component.factory.JComponentFactoryBean;
import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.listener.ListenerBinderFactory;
import com.inputabc.EzGUIFramework.util.inter.DropEvent;
import com.inputabc.EzGUIFramework.util.inter.JComponentRepainter;
import com.inputabc.EzGUIFramework.util.template.Templates;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ------------EzGUI------------ 适合Swing和AWT
 * 
 * @author 高伟益
 * @date 2020/5/20
 * @version 1.8 debug2 适合java1.8以上的jdk
 *          EzGUI建议开发GUI的时候为每个组件设置一个名字，方便利用本框架中的debug方法进行调试。
 */
public abstract class EzGUI {
	final public static int THEME_OS_DEFAULT = 0;
	final public static int THEME_OS_WINDOWS = 1;
	final public static int THEME_OS_WINDOWS_CLASSIC = 2;
	final public static int THEME_MOTIF = 3;
	final public static int THEME_DEFAULT = 4;
	final public static int THEME_METAL = 5;
	final public static int THEME_NIMBUS = 6;
	final public static int THEME_OS_MAC = 7;
	final public static int THEME_OS_GTK = 8;
	final public static int RULE_REQUIRED = 100;
	final public static int RULE_IS_NUMBER = 200;
	final public static int RULE_IS_ENGLISH = 300;
	final public static int RULE_IS_EMAIL = 400;
	final public static int RULE_IS_QQ = 500;
	final public static int TEMPLATE_SWING_DIALOG_1 = 10000;
	final public static int TEMPLATE_SWING_DIALOG_2 = 20000;
	final public static int TEMPLATE_AWT_DIALOG_1 = 10001;
	final public static int STYLE_1 = 0x1FFF;
	final public static int STYLE_2 = 0x2FFF;
	final public static int FADE_FAST = 8;
	final public static int FADE_SLOW = 36;
	final public static int FADE_NORMAL = 15;
	final public static int MATCH_LIKE_LEFT = 5500;
	final public static int MATCH_LIKE_RIGHT = 5501;
	final public static int MATCH_LIKE_BOTH = 5502;
	final public static int SPREAD_FAST = 24;
	final public static int SPREAD_SLOW = 7;
	final public static int SPREAD_NORMAL = 15;
	final public static int PACKUP_FAST = 24;
	final public static int PACKUP_NORMAL = 12;
	final public static int PACKUP_SLOW = 6;
	final public static int SHAPE_ROUND = 601;
	private static JComponentFactory jcf = new JComponentFactoryBean();
	final public static MessageBox messager = new MessageBox(){};
	/**
	 * 打印组件信息到控制台
	 * 
	 * @param components
	 */
	private static void printComponentInfo(Map<String, Component> components) {
		StringBuilder stringB = new StringBuilder();
		String line = System.lineSeparator();
		stringB.append("类名\t\t组件名".concat(line));
		Set<Entry<String, Component>> entrySet = components.entrySet();
		for (Entry<String, Component> entry : entrySet) {
			stringB.append(entry.getValue().getClass().getName().concat("\t\t").concat(entry.getKey()).concat(line));
		}
		System.out.println(stringB);
	}

	/**
	 * 打印组件信息到控制台
	 * 
	 * @param coms
	 */
	private static void printComponentInfo(List<Component> coms, boolean showLineNumber) {
		List<String> lines = new ArrayList<String>();
		for (Component com : coms) {
			lines.add(packMsg(com, true).toString());
		}
		for (int x = 0; x < lines.size(); x++) {
			if (showLineNumber) {
				System.out.print(x + 1 + ": ");
			}
			System.out.println(lines.get(x));
			for (int y = 0; y < 500; y++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

	/**
	 * 去除容器内所以组件的焦点
	 * 
	 * @param c
	 */
	public static void noFocus(Container c) {
		Component[] components = c.getComponents();
		for (Component component : components) {
			if (component instanceof Container) {
				noFocus((Container) component);
			}
			component.setFocusable(false);
		}
	}

	/**
	 * 去除容器内所以组件的焦点,不包括filteredComponents中的
	 * 
	 * @param c
	 * @param filteredComponents
	 */
	public static void noFocus(Container c, Component... filteredComponents) {
		Component[] components = c.getComponents();
		a: for (Component component : components) {
			for (Component filtered : filteredComponents) {
				if (component == filtered) {
					continue a;
				}
			}
			if (component instanceof Container) {
				noFocus((Container) component);
			}
			component.setFocusable(false);
		}
	}

	/**
	 * 去除容器内所有按钮的焦点虚线
	 * 
	 * @param c
	 */
	public static void removeButtonDottedLine(Container c) {
		Component[] components = c.getComponents();
		for (Component component : components) {
			if (component instanceof Container) {
				removeButtonDottedLine((Container) component);
			}
			try {
				((AbstractButton) component).setFocusPainted(false);
			} catch (ClassCastException e) {
			}
		}
	}

	/**
	 * 使窗体居中
	 * 
	 * @param w
	 * @param original
	 */
	public static void center(Window w, boolean original) {
		if (original) {
			w.setLocationRelativeTo(null);
		} else {
			int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
			int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
			int shellH = w.getBounds().height;
			int shellW = w.getBounds().width;
			if (shellH > screenH)
				shellH = screenH;
			if (shellW > screenW)
				shellW = screenW;
			w.setLocation(((screenW - shellW) / 2), ((screenH - shellH) / 2));
		}
	}

	/**
	 * 使窗体居中
	 * 
	 * @param w
	 */
	public static void center(Window w) {
		center(w, false);
	}

	/**
	 * 批量添加组件到容器中
	 * 
	 * @param c
	 * @param cp
	 */
	public static void addAll(Container c, Component... cp) {
		Set<Component> set = new HashSet<Component>();
		for (Component component : cp) {
			set.add(component);
		}
		addAll(c, set);
	}

	/**
	 * 批量添加组件到容器中
	 * 
	 * @param c
	 * @param cps
	 */
	public static void addAll(Container c, Set<Component> cps) {
		for (Component component : cps) {
			c.add(component);
		}
	}

	/**
	 * 
	 * 设置皮肤
	 * 
	 * @param themeType
	 */
	public static void setTheme(int themeType) {
		try {
			switch (themeType) {
			case THEME_OS_DEFAULT: {
				String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_OS_WINDOWS: {
				String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_OS_WINDOWS_CLASSIC: {
				String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_MOTIF: {
				String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_DEFAULT: {
				String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
				UIManager.setLookAndFeel

				(lookAndFeel);

			}
				break;
			case THEME_METAL: {
				String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_NIMBUS: {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
				break;
			case THEME_OS_MAC: {
				String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel";

				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			case THEME_OS_GTK: {
				String lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

				UIManager.setLookAndFeel(lookAndFeel);
			}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置文本默认值
	 * 
	 * @param jtc
	 * @param string
	 */
	public static void placeholderForSwing(final JTextComponent jtc, String string) {
		final Color foreground_old = jtc.getForeground();
		final Font font_old = jtc.getFont();
		jtc.setForeground(Color.LIGHT_GRAY);
		jtc.setText(string);

		jtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtc.setText("");
				jtc.setForeground(foreground_old);
				jtc.setFont(font_old);
				jtc.removeFocusListener(this);
			}

		});
	}

	/**
	 * 设置文本默认值
	 * 
	 * @param tc
	 * @param string
	 */
	public static void placeholderForAWT(final TextComponent tc, final String string) {
		final Color foreground_old = tc.getForeground();
		final Font font_old = tc.getFont();
		tc.setForeground(Color.LIGHT_GRAY);
		tc.setText(string);

		tc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tc.setSelectionStart(0);
				tc.setSelectionEnd(string.length() - 1);
				tc.setText("");
				tc.setForeground(foreground_old);
				tc.setFont(font_old);
				tc.removeFocusListener(this);
			}

		});
	}

	/**
	 * 验证输入规则
	 * 
	 * @param text
	 * @param rule
	 * @return
	 */
	public static boolean validateForSwing(JTextComponent text, int... rule) {
		boolean valid = false;
		String _text = text.getText();
		_text = _text.trim();
		for (int i : rule) {
			switch (i) {
			case RULE_REQUIRED: {
				if (_text == null || _text.equals("")) {
					return false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_NUMBER: {
				if (_text.matches("^[0-9]*$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_ENGLISH: {
				if (_text.matches("^[a-zA-Z]+$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_EMAIL: {
				if (_text.matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_QQ: {
				if (_text.matches("[1-9][0-9]{5,14}") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			}
		}
		return valid;
	}

	/**
	 * 验证输入规则
	 * 
	 * @param text
	 * @param rule
	 * @return
	 */
	public static boolean validateForAWT(TextComponent text, int... rule) {
		boolean valid = false;
		String _text = text.getText();
		_text = _text.trim();
		for (int i : rule) {
			switch (i) {
			case RULE_REQUIRED: {
				if (_text == null || _text.equals("")) {
					return false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_NUMBER: {
				if (_text.matches("^[0-9]*$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_ENGLISH: {
				if (_text.matches("^[a-zA-Z]+$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_EMAIL: {
				if (_text.matches("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			case RULE_IS_QQ: {
				if (_text.matches("[1-9][0-9]{5,14}") == false) {
					valid = false;
				} else {
					valid = true;
				}
			}
				break;
			}
		}
		return valid;
	}

	/**
	 * 固定窗口，禁止最大化和改变窗口大小，并且包含最大化按钮
	 * 
	 * @param jframe
	 */
	public static void fixedWindowSizeForSwing(final JFrame jframe) {
		jframe.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				jframe.setSize(400, 270);
				center(jframe);
			}
		});
	}

	/**
	 * 固定窗口，禁止最大化和改变窗口大小，并且包含最大化按钮
	 * 
	 * @param frame
	 */
	public static void fixedWindowSizeForAWT(final Frame frame) {
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				frame.setSize(400, 270);
				center(frame);
			}
		});
	}

	/**
	 * 配置一个右键菜单到父容器上
	 * 
	 * @param c
	 * @param pm
	 */
	public static void setJPopupMenuForSwing(final JComponent c, final JPopupMenu pm) {
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if (e.isPopupTrigger()) {
					pm.show(c, e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * 配置一个右键菜单到父容器上
	 * 
	 * @param c
	 * @param pm
	 */
	public static void setPopupMenuForAWT(final Component c, final PopupMenu pm) {
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if (e.isPopupTrigger()) {
					pm.show(c, e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * 获取相反的颜色
	 * 
	 * @param color
	 * @return
	 */
	public static Color getOppositeColor(Color color) {
		int rgb = color.getRGB();
		return new Color(0xFFFFFF - rgb);
	}

	/**
	 * 将图片中的颜色反色处理
	 * 
	 * @param imgsrc
	 * @return
	 */
	public static BufferedImage getOppositeColorImage(BufferedImage imgsrc) {
		try {
			BufferedImage back = new BufferedImage(imgsrc.getWidth(), imgsrc.getHeight(), BufferedImage.TYPE_INT_RGB);
			int width = imgsrc.getWidth();
			int height = imgsrc.getHeight();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int pixel = imgsrc.getRGB(j, i);
					back.setRGB(j, i, 0xFFFFFF - pixel);
				}
			}
			return back;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将图片文件转换为BufferedImage对象
	 * 
	 * @param file
	 * @return
	 */
	public static BufferedImage imageFileToImage(String file) {
		return imageFileToImage(new File(file));
	}

	/**
	 * 将图片文件转换为BufferedImage对象
	 * 
	 * @param file
	 * @return
	 */
	public static BufferedImage imageFileToImage(File file) {
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			return bufferedImage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 给容器设置背景图片
	 * 
	 * 容器
	 * 
	 * @param c
	 *            图片的源文件
	 * @param file
	 *            图片的宽度
	 * @param width
	 *            图片的高度
	 * @param height
	 * @return
	 * @deprecated
	 */
	public static JPanel setBackgroundImageForSwing(Container c, String file, int width, int height) {
		class ImagePanel extends JPanel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Dimension d;
			Image image;

			public ImagePanel(Dimension d, Image image) {
				super();
				this.d = d;
				this.image = image;
			}

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, d.width, d.height, this);
			}
		}
		Dimension frameSize = new Dimension(width, height);
		ImageIcon imageIcon = new ImageIcon(file);
		ImagePanel imagePanel = new ImagePanel(frameSize, imageIcon.getImage());
		if (c instanceof JFrame) {
			((JFrame) c).setContentPane(imagePanel);
		} else if (c instanceof JDialog) {
			((JDialog) c).setContentPane(imagePanel);
		} else {

			c.add(imagePanel);
		}
		return imagePanel;
	}

	/**
	 * 给容器设置背景图片
	 * 
	 * 容器
	 * 
	 * @param c
	 *            图片的源文件
	 * @param file
	 *            图片的宽度
	 * @param width
	 *            图片的高度
	 * @param height
	 * @return
	 */
	public static Panel setBackgroundImageForAWT(Container c, String file, int width, int height) {
		class ImagePanel extends Panel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Dimension d;
			Image image;

			public ImagePanel(Dimension d, Image image) {
				super();
				this.d = d;
				this.image = image;
			}

			@Override
			public void paintComponents(Graphics g) {
				super.paintComponents(g);
				g.drawImage(image, 0, 0, d.width, d.height, this);
			}
		}
		Dimension frameSize = new Dimension(width, height);
		ImageIcon imageIcon = new ImageIcon(file);
		ImagePanel imagePanel = new ImagePanel(frameSize, imageIcon.getImage());
		if (c instanceof JFrame) {
			((JFrame) c).setContentPane(imagePanel);
		} else {
			c.add(imagePanel);
		}
		return imagePanel;
	}

	/**
	 * 让容器支持拖拽文件，并获取被拖拽的文件集合
	 * 
	 * @param c
	 * @param event
	 * @return
	 */
	public static DropTarget dropFile(Container c, final DropEvent event) {

		DropTarget dropTarget = new DropTarget(c, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter() {
			@Override
			public void drop(DropTargetDropEvent dtde) {
				try {
					if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
						dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
						event.event(dtde);
					} else {
						dtde.rejectDrop();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return dropTarget;
	}

	/**
	 * 提供一些界面的模板，简化开发 可以通过调用组件的getName方法来找到相应的组件对象，name的基本格式是该组件的名字+空格+父容器的名字
	 * 一个简单的例子： Map<String, Component> coms =
	 * EzGUI.template(EzGUI.TEMPLATE_SWING_DIALOG_1,true,false); JDialog dialog
	 * = (JDialog) coms.get("dialog");
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true);
	 * 
	 * @param templateType
	 * @param printInfo
	 *            //打印信息
	 * @param devMode
	 *            //开发者模式
	 * @return
	 */
	public static Map<String, Component> template(int templateType, boolean printInfo, boolean devMode) {
		Map<String, Component> components = new Templates().template(templateType);

		if (printInfo) {

			printComponentInfo(components);
		}
		if (devMode) {
			Set<Entry<String, Component>> entrySet = components.entrySet();
			for (Entry<String, Component> entry : entrySet) {
				addClickListener(entry.getValue(), false);
			}
		}
		return components;
	}

	/**
	 * 展示或隐藏组件的边框，只有基于JComponent的组件才支持边框 如果边框已经存在则隐藏此边框，若不存在则展示边框 适合开发阶段使用
	 * 
	 * @param c
	 */
	public static void toggleBorder(JComponent... c) {
		for (JComponent cc : c) {
			if (cc != null) {
				if (cc.getBorder() == null || cc.getBorder().isBorderOpaque() == false) {
					cc.setBorder(BorderFactory.createEtchedBorder());
				} else {
					cc.setBorder(BorderFactory.createEmptyBorder());
				}
			}
		}

	}

	/**
	 * 展示组件的边框，只有基于JComponent的组件才支持边框 适合开发阶段使用
	 * 
	 * @param c
	 */
	public static void showBorder(JComponent... c) {
		for (JComponent cc : c) {
			if (cc != null) {
				cc.setBorder(BorderFactory.createEtchedBorder());
			}
		}
	}

	/**
	 * 隐藏组件的边框，只有基于JComponent的组件才支持边框 适合开发阶段使用
	 * 
	 * @param c
	 */
	public static void hideBorder(JComponent... c) {
		for (JComponent cc : c) {
			if (cc != null) {
				cc.setBorder(BorderFactory.createEmptyBorder());
			}
		}
	}

	/**
	 * 给组件绑定一个点击事件，用于调试
	 * 
	 * @param c
	 * @param msg
	 */
	public static void addClickListener(Component c, final Object msg) {
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, msg, "消息", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * 给组件绑定一个点击事件，用于调试
	 * 
	 * @param c
	 * @since 1.0
	 */
	@Deprecated
	public static void addClickListener(final Component c) {
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String className = c.getClass().getName();
				String name = c.getName();
				String msg = "类名：".concat(className);
				msg = msg.concat(System.lineSeparator()).concat("组件名：").concat(name == null ? "" : name);
				JOptionPane.showMessageDialog(c.getParent(), msg, "消息", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * 给组件绑定一个点击事件，用于调试
	 * 
	 * @param c
	 * @param basic
	 * @since 1.4
	 */
	public static void addClickListener(final Component c, final boolean basic) {
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (basic) {
					addClickListener(c);
					return;
				}
				StringBuffer msg = packMsg(c, false);
				JOptionPane.showMessageDialog(c.getParent(), msg.toString(), "消息", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * 将组件的信息封装到一个StringBuffer中 singleRow为true表示所有属性的信息都在同一行显示<br>
	 * 为false表示各个属性的信息各占一行
	 * 
	 * @param c
	 * @return
	 */
	private static StringBuffer packMsg(Component c, boolean singleRow) {
		StringBuffer msg = new StringBuffer();
		List<String> msgGroup = new ArrayList<String>();
		msgGroup.add("类名：" + c.getClass().getName());
		msgGroup.add("组件名：" + c.getName());
		if (c.getParent() != null) {
			msgGroup.add("父组件（容器）：" + c.getParent().getClass().getName() + "  " + c.getParent().getName());
		} else {
			msgGroup.add("父组件（容器）：null");
		}
		msgGroup.add("位置&大小：(" + c.getX() + ", " + c.getY() + ", " + c.getWidth() + ", " + c.getHeight() + ")");
		msgGroup.add("背景颜色：(" + c.getBackground().getRed() + ", " + c.getBackground().getGreen() + ", "
				+ c.getBackground().getBlue() + ")");
		msgGroup.add("前景顏色：(" + c.getForeground().getRed() + ", " + c.getForeground().getGreen() + ", "
				+ c.getForeground().getBlue() + ")");
		msgGroup.add("字体：" + c.getFont().getSize() + "px" + " "
				+ c.getFont().getFontName().substring(c.getFont().getFontName().indexOf(".") + 1));
		String split = null;
		if (singleRow) {
			split = "\t\t";
		} else {
			split = System.lineSeparator();
		}
		for (String line : msgGroup) {
			msg.append(line + split);
		}
		return msg;
	}

	/**
	 * 获取确定按钮
	 * 
	 * @return
	 */
	public static JButton getOkButtonForSwing() {
		JButton jb = new JButton("确定");
		jb.setFocusPainted(false);
		return jb;
	}

	/**
	 * 获取确定按钮 setSize表示是否设置大小，一般用在null布局中
	 * 
	 * @param setSize
	 * @return
	 */
	public static JButton getOkButtonForSwing(boolean setSize) {
		if (setSize) {
			JButton jb = new JButton("确定");
			jb.setSize(80, 26);
			jb.setFocusPainted(false);
			return jb;
		}
		return getOkButtonForSwing();
	}

	/**
	 * 获取确定按钮
	 * 
	 * @return
	 */
	public static Button getOkButtonForAWT() {
		return new Button("确定");
	}

	/**
	 * 获取确定按钮 setSize表示是否设置大小，一般用在null布局中
	 * 
	 * @param setSize
	 * @return
	 */
	public static Button getOkButtonForAWT(boolean setSize) {
		if (setSize) {
			Button b = new Button("确定");
			b.setSize(80, 26);
			return b;
		}
		return getOkButtonForAWT();
	}

	/**
	 * 获取取消按钮
	 * 
	 * @return
	 */
	public static JButton getCancelButtonForSwing() {
		JButton jb = new JButton("取消");
		jb.setFocusPainted(false);
		return jb;
	}

	/**
	 * 获取取消按钮 setSize表示是否设置大小，一般用在null布局中
	 * 
	 * @param setSize
	 * @return
	 */
	public static JButton getCancelButtonForSwing(boolean setSize) {
		if (setSize) {
			JButton jb = new JButton("取消");
			jb.setSize(80, 26);
			jb.setFocusPainted(false);
			return jb;
		}
		return getCancelButtonForSwing();
	}

	/**
	 * 获取取消按钮
	 * 
	 * @return
	 */
	public static Button getCancelButtonForAWT() {
		return new Button("取消");
	}

	/**
	 * 获取取消按钮 setSize表示是否设置大小，一般用在null布局中
	 * 
	 * @param setSize
	 * @return
	 */
	public static Button getCancelButtonForAWT(boolean setSize) {
		if (setSize) {
			Button b = new Button("取消");
			b.setSize(86, 26);
			return b;
		}
		return getCancelButtonForAWT();
	}

	/**
	 * 获取容器内的某一种组件的集合，只支持单级容器
	 * 
	 * @param c
	 * @param componentClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(Container c, Class<T> componentClass) {
		List<T> coms = new ArrayList<T>();
		Component[] components = c.getComponents();
		for (Component component : components) {
			if (component.getClass().getName().equals(componentClass.getName())) {
				coms.add((T) component);
			}
		}
		return coms;
	}

	/**
	 * 将传过来的ImageIcon转换为小图标
	 * 
	 * @param iicon
	 * @return
	 */
	public static ImageIcon parseSmaillerImageIcon(ImageIcon iicon) {
		iicon.setImage(iicon.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
		return iicon;
	}

	/**
	 * 美化工具栏
	 * 
	 * @param bar
	 */
	public static void beautifyToolBar(JToolBar bar) {
		bar.setOpaque(false);
		bar.setDoubleBuffered(true);
		bar.setBorder(BorderFactory.createEmptyBorder());
		bar.setAutoscrolls(false);
		bar.setFloatable(false);
	}

	/**
	 * 从本地图片文件获取一个ImageIcon对象
	 * 
	 * @param localPath
	 * @return
	 */
	public static ImageIcon getImageIconFromLocal(String localPath) {
		return new ImageIcon(localPath);
	}

	/**
	 * 判断图片文件是否合法
	 * 
	 * @param inputStream
	 * @return
	 */
	public static boolean isImage(InputStream inputStream) {
		if (inputStream == null) {
			return false;
		}
		Image img;
		try {
			img = ImageIO.read(inputStream);
			return !(img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 打开资源管理器
	 * 
	 * @param filePath
	 */
	public static void openExplorer(String filePath) {
		try {
			Desktop.getDesktop().open(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调试指定容器 给指定的容器里的所有组件添加一个点击事件，点击后显示组件信息
	 * 
	 * @param containers
	 * @since 1.4
	 */
	public static void debug(Container... containers) {
		List<Component> bind = new ArrayList<Component>();
		for (Container ca : containers) {
			Component[] components = ca.getComponents();
			for (Component component : components) {
				if (bind.contains(component) == false) {
					// binding
					addClickListener(component, false);
					bind.add(component);
					if (component instanceof Container) {
						lookupAndBind((Container) component, bind);
					} else if (component instanceof Component) {
						Container parent = component.getParent();
						if (parent != null) {
							if (bind.contains(parent) == false) {
								lookupAndBind(parent, bind);
							}
						}
					}
				}
			}
		}
		printComponentInfo(bind, true);
	}

	/**
	 * 给指定的对象里的容器成员对象里的所有组件添加一个点击事件，点击后显示组件信息
	 * 
	 * @param launcher
	 * @since 1.4
	 */
	public static void debug(Object launcher) {
		List<Component> bind = new ArrayList<Component>();
		try {
			Class<? extends Object> class1 = launcher.getClass();
			Field[] declaredFields = class1.getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				if (field.get(launcher) instanceof Container) {
					Container ca = (Container) field.get(launcher);
					if (bind.contains(ca) == false) {
						addClickListener(ca, false);
						bind.add(ca);
						lookupAndBind(ca, bind);
					}
				} else if (field.get(launcher) instanceof Component) {
					Component component = (Component) field.get(launcher);
					if (bind.contains(component) == false) {
						addClickListener(component, false);
						bind.add(component);
						Container parent = component.getParent();
						if (parent != null) {
							if (bind.contains(parent) == false) {
								addClickListener(parent, false);
								bind.add(parent);
								lookupAndBind(parent, bind);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		printComponentInfo(bind, true);
	}

	/**
	 * 循环罗圈绑定调试事件
	 * 
	 * @param ca
	 * @param bind
	 */
	private static void lookupAndBind(Container ca, List<Component> bind) {
		Component[] components = ca.getComponents();
		for (Component component : components) {
			if (bind.contains(component) == false) {
				addClickListener(component, false);
				bind.add(component);
				if (component instanceof Container) {
					lookupAndBind((Container) component, bind);
				}
			}
		}
	}

	/**
	 * 绑定拖动事件到组件
	 * 
	 * @param eventSource
	 *            事件源
	 * @param dragged
	 *            被拖动的组件
	 * @since 1.5
	 */
	public static void bindDragListener(final Component eventSource, final Component dragged) {
		final Point origin = new Point();
		eventSource.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		eventSource.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = dragged.getLocation();
				dragged.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}
		});
	}

	/**
	 * 使窗体渐渐隐藏
	 * 
	 * @param c
	 * @param speed
	 * @since 1.5
	 */
	public static void fadeOut(Window w, int speed) {
		for (float opacity = w.getOpacity(); opacity > 0.0f; opacity = opacity - 0.05f) {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			w.setOpacity(opacity);
		}
		w.setVisible(false);
	}

	/**
	 * 使窗体渐渐显示
	 * 
	 * @param c
	 * @param speed
	 * @param finalOpacity
	 * @since 1.6
	 */
	public static void fadeIn(Window w, int speed, float finalOpacity) {
		w.setOpacity(0f);
		w.setVisible(true);

		for (float opacity = 0; opacity < finalOpacity; opacity = opacity + 0.05f) {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			w.setOpacity(opacity);
		}
		w.setOpacity(finalOpacity);
	}

	/**
	 * 使窗体渐渐显示<br>
	 * 该方法相当于fadeIn(w, speed, 1.0f)
	 * 
	 * @param c
	 * @param speed
	 * @since 1.5
	 */
	public static void fadeIn(Window w, int speed) {
		fadeIn(w, speed, 1.0f);
	}

	/**
	 * 通过组件名获取容器里的某个组件
	 * 
	 * @param c
	 * @param name
	 * @return
	 * @since 1.6
	 */
	public static Component getComponentByNameEqual(Container c, String name) {
		Collection<Component> componentsByName = getComponentsByNameEqual(c, name);
		return componentsByName.iterator().next();
	}

	/**
	 * 通过组件名获取容器内所有name为该组件名的组件
	 * 
	 * @param c
	 * @param name
	 * @return
	 * @since 1.6
	 */
	public static Collection<Component> getComponentsByNameEqual(Container c, String name) {
		return SearchUtils.getComponentsByNameEqual(c, name, new ArrayList<Component>());
	}

	/**
	 * 获取容器内组件名包含name的组件<br>
	 * 可选右模糊、左模糊、左右模糊
	 * 
	 * @param c
	 * @param name
	 * @param matchType
	 *            可选MATCH_LIKE_RIGHT、MATCH_LIKE_LEFT、MATCH_LIKE_BOTH
	 * @return
	 * @since 1.6
	 */
	public static Collection<Component> getComponentsByNameLike(Container c, String name, int matchType) {
		return SearchUtils.getComponentsByNameLike(c, name, matchType, new ArrayList<Component>());
	}

	/**
	 * 获取容器内组件名包含name的组件<br>
	 * 该方法相当于getComponentsByNameLike(c, name, MATCH_LIKE_BOTH)
	 * 
	 * @param c
	 * @param name
	 * @return
	 * @since 1.6
	 */
	public static Collection<Component> getComponentsByNameLike(Container c, String name) {
		return getComponentsByNameLike(c, name, MATCH_LIKE_BOTH);
	}

	/**
	 * 使窗体展开
	 * 
	 * @param window
	 *            目标窗体
	 * @param width
	 *            完全展开时组件的宽度
	 * @param height
	 *            完全展开时的组件的高度
	 * @param speed
	 *            动画的速度
	 * @param relative
	 *            是否设置窗口相对于指定组件的位置
	 * @param relativeComponent
	 *            位置参考的组件
	 * @since 1.6
	 */
	public static void spread(Window window, int width, int height, int speed, boolean relative,
			Component relativeComponent) {
		window.setVisible(true);
		window.setSize(width, 0);
		int offset = speed / 2;
		int x = 0;
		while ((x = x + speed) <= height) {
			window.setSize(width, x);
			if (relative) {
				window.setLocationRelativeTo(relativeComponent);
			} else {
				window.setLocation(window.getX(), window.getY() - offset);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 使窗体展开<br>
	 * 该方法相当于spread(window, width, height, speed, relative, null);
	 * 
	 * @param window
	 *            目标窗体
	 * @param width
	 *            完全展开时组件的宽度
	 * @param height
	 *            完全展开时的组件的高度
	 * @param speed
	 *            动画的速度
	 * @param relative
	 *            是否设置窗口相对于指定组件的位置
	 * @since 1.6
	 */
	public static void spread(Window window, int width, int height, int speed, boolean relative) {
		spread(window, width, height, speed, relative, null);
	}

	/**
	 * 使窗体展开<br>
	 * 该方法相当于spread(window, width, height, speed,false,null);
	 * 
	 * @param window
	 *            目标窗体
	 * @param width
	 *            完全展开时组件的宽度
	 * @param height
	 *            完全展开时的组件的高度
	 * @param speed
	 *            动画的速度
	 * @since 1.6
	 */
	public static void spread(Window window, int width, int height, int speed) {
		spread(window, width, height, speed, false, null);
	}

	/**
	 * 使窗体展开<br>
	 * spread(window, window.getWidth(), window.getHeight(), speed, false,
	 * null);
	 * 
	 * @param window
	 *            目标窗体
	 * @param width
	 *            完全展开时组件的宽度
	 * @param height
	 *            完全展开时的组件的高度
	 * @param speed
	 *            动画的速度
	 * @since 1.6
	 */
	public static void spread(Window window, int speed) {
		spread(window, window.getWidth(), window.getHeight(), speed, false, null);
	}

	/**
	 * 使窗体折叠后隐藏
	 * 
	 * @param window
	 *            目标窗体
	 * @param speed
	 *            动画的速度
	 * @param relative
	 *            是否设置窗口相对于指定组件的位置
	 * @param relativeComponent
	 *            位置参考的组件
	 * @since 1.6
	 */
	public static void packup(Window window, int speed, boolean relative, Component relativeComponent) {
		int x = window.getHeight();
		int offset = speed / 2;
		while ((x = x - speed) > 0) {
			window.setSize(window.getWidth(), x);
			if (relative) {
				window.setLocationRelativeTo(relativeComponent);
			} else {
				window.setLocation(window.getX(), window.getY() + offset);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		window.setVisible(false);
	}

	/**
	 * 使窗体折叠后隐藏<br>
	 * 该方法相当于packup(window, speed, relative, null)
	 * 
	 * @param window
	 *            目标窗体
	 * @param speed
	 *            动画的速度
	 * @param relative
	 *            是否设置窗口相对于指定组件的位置
	 * @since 1.6
	 */
	public static void packup(Window window, int speed, boolean relative) {
		packup(window, speed, relative, null);
	}

	/**
	 * 使窗体折叠后隐藏<br>
	 * 该方法相当于packup(window, speed, false, null)
	 * 
	 * @param window
	 *            目标窗体
	 * @param speed
	 *            动画的速度
	 * @since 1.6
	 */
	public static void packup(Window window, int speed) {
		packup(window, speed, false, null);
	}

	/**
	 * 根据指定的位移来移动组件<br>
	 * 移动的方向：<br>
	 * x为负数，y为负数：左上<br>
	 * x为正数，y为负数：右上<br>
	 * x为负数，y为正数：左下<br>
	 * x为正数，y为正数：右下
	 * 
	 * @param component
	 *            目标组件
	 * @param x
	 *            横向偏移量
	 * @param y
	 *            纵向偏移量
	 * @param speed
	 *            移动的速度,数值越大速度越慢;设为负数则关闭动画效果
	 * @since 1.6
	 */
	public static void moveBy(final Component component, final int x, final int y, final int speed) {
		if (speed < 0) {
			component.setLocation(component.getX() + x, component.getY() + y);
			return;
		}
		final boolean[] flag = new boolean[] { false, false };
		new Thread(new Runnable() {

			@Override
			public void run() {

				int moved = 0;
				int maxX = Math.abs(x);
				while (moved++ < maxX) {
					component.setLocation(component.getX() + (x < 0 ? -1 : 1), component.getY());
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				flag[0] = true;
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				int moved = 0;
				int maxY = Math.abs(y);
				while (moved++ < maxY) {
					component.setLocation(component.getX(), component.getY() + (y < 0 ? -1 : 1));
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				flag[1] = true;
			}
		}).start();
		while ((flag[0] && flag[1]) == false) {
			Thread.yield();
		}

	}

	/**
	 * 根据指定的位移来移动组件<br>
	 * 该方法相当于moveBy(component, x, y, -1)<br>
	 * 移动的方向：<br>
	 * x为负数，y为负数：左上<br>
	 * x为正数，y为负数：右上<br>
	 * x为负数，y为正数：左下<br>
	 * x为正数，y为正数：右下
	 * 
	 * @param component
	 *            目标组件
	 * @param x
	 *            横向偏移量
	 * @param y
	 *            纵向偏移量
	 * @since 1.6
	 */
	public static void moveBy(final Component component, final int x, final int y) {
		moveBy(component, x, y, -1);
	}

	/**
	 * 将组件移动到目标位置<br>
	 * 当位置坐标（即x或y）设为负数时，目标位置是相对于屏幕的负顶点
	 * 
	 * @param component
	 *            目标组件
	 * @param x
	 *            横轴坐标
	 * @param y
	 *            纵轴坐标
	 * @param speed
	 *            移动的速度
	 * @since 1.6
	 */
	public static void moveTo(final Component component, final int x, final int y, final int speed) {
		moveTo(component, null, x, y, speed);
	}
	/**
	 * 将组件移动到目标位置<br>
	 * 当位置坐标（即x或y）设为负数时，如果parent的为null，目标位置是相对于屏幕的负顶点<br>
	 * 如果指定了parent，目标位置相对于父组件的负顶点
	 * 
	 * @param component
	 *            目标组件
	 * @param parent 目标组件的父组件
	 * @param x
	 *            横轴坐标
	 * @param y
	 *            纵轴坐标
	 * @param speed
	 *            移动的速度
	 * @since 1.8
	 */
	public static void moveTo(final Component component,final Component parent, final int x, final int y, final int speed) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int swidth = parent==null?screensize.width:parent.getWidth();
		int sheight = parent==null?screensize.height:parent.getHeight();
		final int srcX;
		final int srcY;
		if (x < 0) {
			srcX = swidth + x - component.getWidth();
		} else {
			srcX = x;
		}
		if (y < 0) {
			srcY = sheight + y - component.getHeight();
		} else {
			srcY = y;
		}
		if (speed < 0) {
			component.setLocation(srcX, srcY);
			return;
		}
		final boolean[] flag = new boolean[] { false, false };
		new Thread(new Runnable() {

			@Override
			public void run() {

				int currentX = component.getX();
				int targetX = Math.abs(srcX);
				while (true) {
					if (targetX - currentX < 0) {
						currentX--;
					} else if (targetX - currentX > 0) {
						currentX++;
					} else {
						break;
					}
					component.setLocation(component.getX() + (currentX - srcX < 0 ? 1 : -1), component.getY());
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				flag[0] = true;
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				int currentY = component.getY();
				int targetY = Math.abs(srcY);
				while (true) {
					if (targetY - currentY < 0) {
						currentY--;
					} else if (targetY - currentY > 0) {
						currentY++;
					} else {
						break;
					}
					component.setLocation(component.getX(), component.getY() + (currentY - srcY < 0 ? 1 : -1));
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				flag[1] = true;
			}
		}).start();
		while ((flag[0] && flag[1]) == false) {
			Thread.yield();
		}
	}

	/**
	 * 将组件移动到目标位置<br>
	 * 该方法相当于优化版的Component对象的setLocation方法<br>
	 * 该方法相当于moveTo(component, x, y, -1)<br>
	 * 当位置坐标（即x或y）设为负数时，目标位置是相对于屏幕负顶点
	 * 
	 * @param component
	 *            目标组件
	 * @param x
	 *            横轴坐标
	 * @param y
	 *            纵轴坐标
	 * @since 1.6
	 */
	public static void moveTo(final Component component, final int x, final int y) {
		moveTo(component, x, y, -1);
	}
	/**
	 * 将组件移动到目标位置<br>
	 * 该方法相当于优化版的Component对象的setLocation方法<br>
	 * 该方法相当于moveTo(component,parent, x, y, -1)<br>
	 * 当位置坐标（即x或y）设为负数时，如果parent的为null，目标位置是相对于屏幕的负顶点<br>
	 * 如果指定了parent，目标位置相对于父组件的负顶点
	 * 
	 * @param component
	 *            目标组件
	 * @param x
	 *            横轴坐标
	 * @param y
	 *            纵轴坐标
	 * @since 1.8
	 */
	public static void moveTo(final Component component,final Component parent, final int x, final int y){
		moveTo(component, parent, x, y,-1);
	}
	/**
	 * 安全地更新JTextField组件的文本内容<br>
	 * 
	 * @param jtf
	 *            目标输入框
	 * @param text
	 *            要更新的内容
	 * @since 1.6
	 */
	public static void updateJTextFieldContent(final JTextField jtf, final String text) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				jtf.setText(text);
			}
		}).start();
	}
	/**
	 * 创建一个带有渐变背景色的JComponent组件
	 * @param clazz 目标组件的Class对象
	 * @param color1 颜色1
	 * @param color2 颜色2
	 * @param cyclic 重复渐变
	 * @return
	 * @since 1.7
	 */
	public static JComponent createGradientJComponent(final Class<? extends JComponent> clazz,
			final Color color1, final Color color2, final boolean cyclic) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				if ("paintComponent".equals(arg1.getName())) {
					JComponent cast = clazz.cast(arg0);
					arg3.invokeSuper(arg0, arg2);
					Graphics g = (Graphics) arg2[0];
					if (g instanceof Graphics2D) {
						Paint paint = new GradientPaint(0.0f, 0.0f, color1, 0.0f, cast.getHeight(), color2, cyclic);
						Graphics2D g2d = (Graphics2D) g;
						g2d.setPaint(paint);
						
						g2d.fillRect(0, 0, cast.getWidth(), cast.getHeight());
					}
					return null;
				}
				return arg3.invokeSuper(arg0, arg2);
			}

		});
		return (JComponent) enhancer.create();
	}
	/**
	 * 创建一个带有渐变背景色的JComponent组件<br>
	 * 该方法相当于createGradientJComponent(clazz,color1,color2,true)
	 * @param clazz 目标组件的Class对象
	 * @param color1 颜色1
	 * @param color2 颜色2
	 * @return
	 * @since 1.7
	 */
	public static JComponent createGradientJComponent(final Class<? extends JComponent> clazz,
			final Color color1, final Color color2){
		return createGradientJComponent(clazz,color1,color2,true);
	}
	/**
	 * 创建一个自行重绘后的组件
	 * @param clazz 目标组件的Class对象
	 * @param jcr 
	 * @return
	 * @since 1.7
	 */
	@Deprecated
	public static JComponent createRepaintedJComponent(final Class<? extends JComponent> clazz,final JComponentRepainter jcr){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				if ("paintComponent".equals(arg1.getName())) {
					arg3.invokeSuper(arg0, arg2);
					jcr.repaint(clazz.cast(arg0),(Graphics)arg2[0]);
					return null;
				}
				return arg3.invokeSuper(arg0, arg2);
			}

		});
		return (JComponent) enhancer.create();
	}
	/**
	 * 获取一个JComponentFactoryBean对象实例<br>
	 * 可以通过该对象来创建经过EzGUI美化的组件<br>
	 * 多次调用该方法总会返回同一对象
	 * @return
	 * @since 1.7
	 */
	public static JComponentFactory getJComponentFactory(){
		return jcf;
	}
	/**
	 * 获取一个DefaultListenerBinder对象实例<br>
	 * @param actionObj
	 * @return
	 * @since 1.8
	 */
	public static ListenerBinder getListenerBinder(Object actionObj){
		return ListenerBinderFactory.build(actionObj);
	}
	//
//	public static void main(String[] args) throws InterruptedException, MalformedURLException {
//		setTheme(THEME_OS_DEFAULT);
//		JFrame jf = new JFrame();
//		jf.setLayout(new BorderLayout());
//		jf.setSize(500, 500);
//		JComponentFactory jcf = EzGUI.getJComponentFactory();
//		JPanel jp = jcf.createComponent(JPanel.class, null, null, new StretchedImageElement(new File("C:\\主数据\\64g东芝\\资料\\壁纸\\your name\\your-name-background-hd-1920x1080-148483.jpg"), Color.black,jf),null);
//		jf.setContentPane(jp);
//		
//		
//		jf.setLocationRelativeTo(null);
//
//		jf.setUndecorated(false);
//		//jf.setBackground(new Color(0, 0, 0, 0));
//
//		// jf.setVisible(true);
//
//		// moveBy(jf, 150, -100);
//		// jf.setLocation(150, -100);
//		//jf.setLayout(new BorderLayout());
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
//
//		// fadeIn(jf, 40);
//	}
	// public static void main(String[] args) {
	// Map<String, Component> coms =
	// EzGUI.template(EzGUI.TEMPLATE_SWING_DIALOG_2, true, true);
	// Window dialog = (Window) coms.get("dialog");
	// // dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// }
	
}
