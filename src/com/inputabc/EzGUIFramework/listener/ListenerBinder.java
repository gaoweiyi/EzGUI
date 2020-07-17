package com.inputabc.EzGUIFramework.listener;

import java.awt.Adjustable;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.ItemSelectable;
import java.awt.List;
import java.awt.TextComponent;
import java.awt.Window;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

/**
 * 
 * @author 高伟益
 * @version 1.3
 */
public interface ListenerBinder {
	/**
	 * <p>
	 * 绑定一个ComponentListener监听器对象到目标组件上。<br>
	 * 该方法的方法名与被注册的监听器的动作方法名一致。<br>
	 * <b>当目标组件变得不可见时</b>，将会触发该监听器的与该方法名一样的动作方法。
	 * 当该监听器的动作方法被调用时，会调用自定义action对象的指定方法，即第二个参数传入的方法名。<br>
	 * 如需解绑该监听器，可调用本接口的unbind方法。
	 * </p>
	 * @param c 事件源，即目标组件
	 * @param methodName 自定义action对象的方法名
	 * @param args action方法的实参
	 */
	void componentHidden(final Component c, final String methodName, Object... args);

	void componentShown(final Component c, final String methodName, Object... args);

	void componentMoved(final Component c, final String methodName, Object... args);

	void componentResized(final Component c, final String methodName, Object... args);

	void actionPerformed(Button btn, String methodName, Object... args);

	void actionPerformed(List l, String methodName, Object... args);

	void actionPerformed(AbstractButton abtn, String methodName, Object... args);

	@SuppressWarnings("rawtypes")
	void actionPerformed(JComboBox jcb, String methodName, Object... args);

	void actionPerformed(JFileChooser jfc, final String methodName, Object... args);

	void focusGained(Component c, String methodName, Object... args);

	void focusLost(Component c, String methodName, Object... args);

	void ancestorMoved(Component c, String methodName, Object... args);

	void ancestorResized(Component c, String methodName, Object... args);

	void hierarchyChanged(Component c, String methodName, Object... args);

	void inputMethodTextChanged(Component c, String methodName, Object... args);

	void caretPositionChanged(Component c, String methodName, Object... args);

	void keyTyped(Component c, String methodName, Object... args);

	void keyPressed(Component c, String methodName, Object... args);

	void keyReleased(Component c, String methodName, Object... args);

	void mouseClicked(Component c, String methodName, Object... args);

	void mousePressed(Component c, String methodName, Object... args);

	void mouseReleased(Component c, String methodName, Object... args);

	void mouseEntered(Component c, String methodName, Object... args);

	void mouseExited(Component c, String methodName, Object... args);

	void mouseDragged(Component c, String methodName, Object... args);

	void mouseMoved(Component c, String methodName, Object... args);

	void mouseWheelMoved(Component c, String methodName, Object... args);

	void propertyChange(Component c, String methodName, Object... args);

	void propertyChange(Component c, String methodName, String propertyName, Object... args);

	void itemStateChanged(ItemSelectable is, String methodName, Object... args);

	void componentAdded(Container c, String methodName, Object... args);

	void componentRemoved(Container c, String methodName, Object... args);

	void windowGainedFocus(Window w, String methodName, Object... args);

	void windowLostFocus(Window w, String methodName, Object... args);

	void windowOpened(Window w, String methodName, Object... args);

	void windowClosing(Window w, String methodName, Object... args);

	void windowClosed(Window w, String methodName, Object... args);

	void windowIconified(Window w, String methodName, Object... args);

	void windowDeiconified(Window w, String methodName, Object... args);

	void windowActivated(Window w, String methodName, Object... args);

	void windowDeactivated(Window w, String methodName, Object... args);

	void windowStateChanged(Window w, String methodName, Object... args);

	void adjustmentValueChanged(Adjustable a, String methodName, Object... args);

	void textValueChanged(TextComponent tc, String methodName, Object... args);

	void stateChanged(ButtonModel bm, String methodName, Object... args);
	//	void changedUpdate(Document doc,String methodName,Object... args);
//	
//	void removeUpdate(Document doc,String methodName,Object... args);
//	
//	void insertUpdate(Document doc,String methodName,Object... args);
//	
//	void undoableEditHappened(Document doc,String methodName,Object... args);
	/**
	 * 解绑事件监听器
	 * @param c
	 * @param listenerMethod
	 * @param actionObj
	 * @param actionMethod
	 * @param argsTypes
	 * @return 返回成功解绑的监听器的数量
	 */
	int unbind(Component c,String listenerMethod,Object actionObj,String actionMethod,Class[] argsTypes);
}
