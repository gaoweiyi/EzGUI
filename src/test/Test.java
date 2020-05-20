package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inputabc.EzGUIFramework.listener.ListenerBinder;
import com.inputabc.EzGUIFramework.util.alias.Ez;

public class Test {
	static ListenerBinder binder;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Ez.setTheme(Ez.THEME_OS_DEFAULT);
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		JButton jb = new JButton();
		JButton jb2 = new JButton();
		JButton jb3 = new JButton();
		jp.setLayout(new FlowLayout());
		jp.add(jb);
		jp.add(jb2);
		jb.setText("点我");
		jb2.setText("解绑");
		jb3.setText("绑定");
		jp.add(jb3);
		jf.setLayout(new BorderLayout());
		jf.setContentPane(jp);
		jf.setSize(200, 100);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ez.removeButtonDottedLine(jf);
		jf.setVisible(true);
		// 获取监听器绑定器对象
		binder = Ez.getListenerBinder(new Events());

		// 给"点我"按钮绑定一个事件监听器，活动方法为Events对象的hello方法
		binder.actionPerformed(jb, "hello", "高伟益", "123456", "13512311111");

		// 给"解绑"按钮绑定一个事件监听器，活动方法为Events对象的hello方法
		binder.actionPerformed(jb2, "unbind", jb);

		// 给"绑定"按钮绑定一个事件监听器，活动方法为Events对象的hello方法
		binder.actionPerformed(jb3, "bind", jb);
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Events().hello("高伟益", "123456", e, "13512311111");
			}
		};
		jb3.addActionListener(al);
		jb3.removeActionListener(al);
	}

	static class Events {
		public void hello(String name, String password, ActionEvent ae, String phone) {
			System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(ae.getWhen())));
			System.out.println("用户名：" + name);
			System.out.println("密码：" + password);
			System.out.println("手机号：" + phone);
		}

		public void unbind(JButton c) {
			// 解绑目标组件的所有监听器
			int unbind = binder.unbind(c, null, null, null, null);
			System.err.println("成功解绑" + unbind + "个监听器");
			// 解绑目标组件的所有监听器
			binder.actionPerformed(c, "bindAfter");
		}

		public void bind(JButton c) {
			// 解绑目标组件的所有监听器
			binder.unbind(c, null, null, null, null);
			// 重新绑定监听器
			binder.actionPerformed(c, "hello", "张三", "123456", "13512311111");
		}

		public void bindAfter() {
			System.out.println("我已解绑");
		}
	}

}
