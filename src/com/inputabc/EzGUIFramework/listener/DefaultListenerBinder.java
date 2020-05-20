package com.inputabc.EzGUIFramework.listener;

import java.awt.Adjustable;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.ItemSelectable;
import java.awt.List;
import java.awt.TextComponent;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.lang3.ArrayUtils;

import com.inputabc.EzGUIFramework.context.EzGUIContext;
import com.inputabc.EzGUIFramework.listener.exception.ListenerBindingException;
import com.inputabc.EzGUIFramework.util.ExceptionUtils;

/**
 * 
 * @author 高伟益
 *
 */
public class DefaultListenerBinder extends AbstractListenerBinder {
	private Object actionObj;
	private EventListener currentListener;
	private Class[] parameterTypes;
	protected DefaultListenerBinder() {
	}

	public void setActionObj(Object actionObj) {
		this.actionObj = actionObj;
	}

	public EventListener getCurrentListener() {
		
		return currentListener;
	}
	
	public Class[] getParameterTypes() {
		return parameterTypes;
	}

	public void componentHidden(final Component c, final String methodName) {
		componentHidden(c, methodName, null);
	}

	@Override
	public void componentShown(Component c, final String methodName) {
		componentShown(c, methodName, null);
	}

	@Override
	public void componentMoved(Component c, final String methodName) {
		componentMoved(c, methodName, null);
	}

	@Override
	public void componentResized(Component c, final String methodName) {
		componentResized(c, methodName, null);
	}

	@Override
	public void actionPerformed(Button btn, final String methodName) {
		actionPerformed(btn, methodName, null);
	}

	@Override
	public void actionPerformed(List l, final String methodName) {
		actionPerformed(l, methodName, null);
	}

	@Override
	public void actionPerformed(AbstractButton abtn, final String methodName) {
		actionPerformed(abtn, methodName, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(JComboBox jcb, final String methodName) {
		actionPerformed(jcb, methodName, null);
	}

	@Override
	public void actionPerformed(JFileChooser jfc, final String methodName) {
		actionPerformed(jfc, methodName, null);
	}

	@Override
	public void focusGained(Component c, final String methodName) {
		focusGained(c, methodName, null);
	}

	@Override
	public void focusLost(Component c, final String methodName) {
		focusLost(c, methodName, null);
	}

	@Override
	public void ancestorMoved(Component c, final String methodName) {
		ancestorMoved(c, methodName, null);
	}

	@Override
	public void ancestorResized(Component c, final String methodName) {
		ancestorResized(c, methodName, null);
	}

	@Override
	public void hierarchyChanged(Component c, final String methodName) {
		hierarchyChanged(c, methodName, null);
	}

	@Override
	public void inputMethodTextChanged(Component c, final String methodName) {
		inputMethodTextChanged(c, methodName, null);
	}

	@Override
	public void caretPositionChanged(Component c, final String methodName) {
		caretPositionChanged(c, methodName, null);
	}

	@Override
	public void keyTyped(Component c, final String methodName) {
		keyTyped(c, methodName, null);
	}

	@Override
	public void keyPressed(Component c, final String methodName) {
		keyPressed(c, methodName, null);
	}

	@Override
	public void keyReleased(Component c, final String methodName) {
		keyReleased(c, methodName, null);
	}

	@Override
	public void mouseClicked(Component c, final String methodName) {
		mouseClicked(c, methodName, null);
	}

	@Override
	public void mousePressed(Component c, final String methodName) {
		mousePressed(c, methodName, null);
	}

	@Override
	public void mouseReleased(Component c, final String methodName) {
		mouseReleased(c, methodName, null);
	}

	@Override
	public void mouseEntered(Component c, final String methodName) {
		mouseEntered(c, methodName, null);
	}

	@Override
	public void mouseExited(Component c, final String methodName) {
		mouseExited(c, methodName, null);
	}

	@Override
	public void mouseDragged(Component c, final String methodName) {
		mouseDragged(c, methodName, null);
	}

	@Override
	public void mouseMoved(Component c, final String methodName) {
		mouseMoved(c, methodName, null);
	}

	@Override
	public void mouseWheelMoved(Component c, final String methodName) {
		mouseWheelMoved(c, methodName, null);
	}

	@Override
	public void propertyChange(Component c, final String methodName) {
		propertyChange(c, methodName, new Object[] {});
	}

	@Override
	public void propertyChange(Component c, final String methodName, String propertyName) {
		propertyChange(c, methodName, propertyName, null);
	}

	@Override
	public void itemStateChanged(ItemSelectable is, final String methodName) {
		itemStateChanged(is, methodName, null);
	}

	@Override
	public void componentAdded(Container c, final String methodName) {
		componentAdded(c, methodName, null);
	}

	@Override
	public void componentRemoved(Container c, final String methodName) {
		componentRemoved(c, methodName, null);
	}

	@Override
	public void windowGainedFocus(Window w, final String methodName) {
		windowGainedFocus(w, methodName, null);
	}

	@Override
	public void windowLostFocus(Window w, final String methodName) {
		windowLostFocus(w, methodName, null);
	}

	@Override
	public void windowOpened(Window w, final String methodName) {
		windowOpened(w, methodName, null);
	}

	@Override
	public void windowClosing(Window w, final String methodName) {
		windowClosing(w, methodName, null);
	}

	@Override
	public void windowClosed(Window w, final String methodName) {
		windowClosed(w, methodName, null);
	}

	@Override
	public void windowIconified(Window w, final String methodName) {
		windowIconified(w, methodName, null);
	}

	@Override
	public void windowDeiconified(Window w, final String methodName) {
		windowDeiconified(w, methodName, null);
	}

	@Override
	public void windowActivated(Window w, final String methodName) {
		windowActivated(w, methodName, null);
	}

	@Override
	public void windowDeactivated(Window w, final String methodName) {
		windowDeactivated(w, methodName, null);
	}

	@Override
	public void windowStateChanged(Window w, final String methodName) {
		windowStateChanged(w, methodName, null);
	}

	@Override
	public void adjustmentValueChanged(Adjustable a, final String methodName) {
		adjustmentValueChanged(a, methodName, null);
	}

	@Override
	public void textValueChanged(TextComponent tc, final String methodName) {
		textValueChanged(tc, methodName, null);
	}

	@Override
	public void stateChanged(ButtonModel bm, final String methodName) {
		stateChanged(bm, methodName, null);
	}

	/**************** 带有额外参数的 *************/

	@Override
	public void componentHidden(Component c, final String methodName, final Object[] args) {
		ComponentListener cl = new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addComponentListener(cl);
		currentListener = cl;
	}

	@Override
	public void componentShown(Component c, final String methodName, final Object[] args) {
		ComponentListener cl = new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addComponentListener(cl);
		currentListener = cl;
	}

	@Override
	public void componentMoved(Component c, final String methodName, final Object[] args) {
		ComponentListener cl = new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addComponentListener(cl);
		currentListener = cl;
	}

	@Override
	public void componentResized(Component c, final String methodName, final Object[] args) {
		ComponentListener cl = new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addComponentListener(cl);
		currentListener = cl;
	}

	@Override
	public void actionPerformed(Button btn, final String methodName, final Object[] args) {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		btn.addActionListener(al);
		currentListener = al;
	}

	@Override
	public void actionPerformed(List l, final String methodName, final Object[] args) {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterTypes = parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		l.addActionListener(al);
		currentListener = al;
	}

	@Override
	public void actionPerformed(AbstractButton abtn, final String methodName, final Object[] args) {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		abtn.addActionListener(al);
		currentListener = al;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(JComboBox jcb, final String methodName, final Object[] args) {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		jcb.addActionListener(al);
		currentListener = al;
	}

	@Override
	public void actionPerformed(JFileChooser jfc, final String methodName, final Object[] args) {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		jfc.addActionListener(al);
		currentListener = al;
	}

	@Override
	public void focusGained(Component c, final String methodName, final Object[] args) {
		FocusAdapter fa = new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addFocusListener(fa);
		currentListener = fa;
	}

	@Override
	public void focusLost(Component c, final String methodName, final Object[] args) {
		FocusAdapter fa = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addFocusListener(fa);
		currentListener = fa;
	}

	@Override
	public void ancestorMoved(Component c, final String methodName, final Object[] args) {
		HierarchyBoundsAdapter hba = new HierarchyBoundsAdapter() {
			@Override
			public void ancestorMoved(HierarchyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addHierarchyBoundsListener(hba);
		currentListener = hba;
	}

	@Override
	public void ancestorResized(Component c, final String methodName, final Object[] args) {
		HierarchyBoundsAdapter hba = new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addHierarchyBoundsListener(hba);
		currentListener = hba;
	}

	@Override
	public void hierarchyChanged(Component c, final String methodName, final Object[] args) {
		HierarchyListener hl = new HierarchyListener() {

			@Override
			public void hierarchyChanged(HierarchyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addHierarchyListener(hl);
		currentListener = hl;
	}

	@Override
	public void inputMethodTextChanged(Component c, final String methodName, final Object[] args) {
		InputMethodListener iml = new InputMethodListener() {

			@Override
			public void inputMethodTextChanged(InputMethodEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}

			@Override
			public void caretPositionChanged(InputMethodEvent e) {
			}
		};
		c.addInputMethodListener(iml);
		currentListener = iml;
	}

	@Override
	public void caretPositionChanged(Component c, final String methodName, final Object[] args) {
		InputMethodListener iml = new InputMethodListener() {

			@Override
			public void inputMethodTextChanged(InputMethodEvent e) {
			}

			@Override
			public void caretPositionChanged(InputMethodEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addInputMethodListener(iml);
		currentListener = iml;
	}

	@Override
	public void keyTyped(Component c, final String methodName, final Object[] args) {
		KeyAdapter ka = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addKeyListener(ka);
		currentListener = ka;
	}

	@Override
	public void keyPressed(Component c, final String methodName, final Object[] args) {
		KeyAdapter ka = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addKeyListener(ka);
		currentListener = ka;
	}

	@Override
	public void keyReleased(Component c, final String methodName, final Object[] args) {
		KeyAdapter ka = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addKeyListener(ka);
		currentListener = ka;
	}

	@Override
	public void mouseClicked(Component c, final String methodName, final Object[] args) {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseListener(ma);
		currentListener = ma;
	}

	@Override
	public void mousePressed(Component c, final String methodName, final Object[] args) {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseListener(ma);
		currentListener = ma;
	}

	@Override
	public void mouseReleased(Component c, final String methodName, final Object[] args) {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseListener(ma);
		currentListener = ma;
	}

	@Override
	public void mouseEntered(Component c, final String methodName, final Object[] args) {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseListener(ma);
		currentListener = ma;
	}

	@Override
	public void mouseExited(Component c, final String methodName, final Object[] args) {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseListener(ma);
		currentListener = ma;
	}

	@Override
	public void mouseDragged(Component c, final String methodName, final Object[] args) {
		MouseMotionAdapter mma = new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseMotionListener(mma);
		currentListener = mma;
	}

	@Override
	public void mouseMoved(Component c, final String methodName, final Object[] args) {
		MouseMotionAdapter mma = new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseMotionListener(mma);
		currentListener = mma;
	}

	@Override
	public void mouseWheelMoved(Component c, final String methodName, final Object[] args) {
		MouseWheelListener mwl = new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addMouseWheelListener(mwl);
		currentListener = mwl;
	}

	@Override
	public void propertyChange(Component c, final String methodName, final Object[] args) {
		PropertyChangeListener pcl = new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addPropertyChangeListener(pcl);
		currentListener = pcl;
	}

	@Override
	public void propertyChange(Component c, final String methodName, String propertyName, final Object[] args) {
		PropertyChangeListener pcl = new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addPropertyChangeListener(propertyName, pcl);
		currentListener = pcl;
	}

	@Override
	public void itemStateChanged(ItemSelectable is, final String methodName, final Object[] args) {
		ItemListener il = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		is.addItemListener(il);
		currentListener = il;
	}

	@Override
	public void componentAdded(Container c, final String methodName, final Object[] args) {
		ContainerListener cl = new ContainerListener() {

			@Override
			public void componentRemoved(ContainerEvent e) {
			}

			@Override
			public void componentAdded(ContainerEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		c.addContainerListener(cl);
		currentListener = cl;
	}

	@Override
	public void componentRemoved(Container c, final String methodName, final Object[] args) {
		ContainerListener cl = new ContainerListener() {

			@Override
			public void componentRemoved(ContainerEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}

			@Override
			public void componentAdded(ContainerEvent e) {
			}
		};
		c.addContainerListener(cl);
		currentListener = cl;
	}

	@Override
	public void windowGainedFocus(Window w, final String methodName, final Object[] args) {
		WindowFocusListener wfl = new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowFocusListener(wfl);
		currentListener = wfl;
	}

	@Override
	public void windowLostFocus(Window w, final String methodName, final Object[] args) {
		WindowFocusListener wfl = new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
			}
		};
		w.addWindowFocusListener(wfl);
		currentListener = wfl;
	}

	@Override
	public void windowOpened(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowClosing(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowClosed(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowIconified(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowIconified(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowDeiconified(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowDeiconified(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowActivated(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowDeactivated(Window w, final String methodName, final Object[] args) {
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowListener(wa);
		currentListener = wa;
	}

	@Override
	public void windowStateChanged(Window w, final String methodName, final Object[] args) {
		WindowStateListener wsl = new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		w.addWindowStateListener(wsl);
		currentListener = wsl;
	}

	@Override
	public void adjustmentValueChanged(Adjustable a, final String methodName, final Object[] args) {
		AdjustmentListener al = new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}

		};
		a.addAdjustmentListener(al);
		currentListener = al;
	}

	@Override
	public void textValueChanged(TextComponent tc, final String methodName, final Object[] args) {
		TextListener tl = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		tc.addTextListener(tl);
		currentListener = tl;
	}

	@Override
	public void stateChanged(ButtonModel bm, final String methodName, final Object[] args) {
		ChangeListener cl = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				parameterTypes = action(actionObj, methodName, e, args);
			}
		};
		bm.addChangeListener(cl);
		currentListener = cl;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int unbind(Component c, String listenerMethod, Object actionObj, String actionMethod, Class[] argsTypes) {
		int count = 0;
		Map<Component, Set<ListenerInfo>> bindListenerGroup = EzGUIContext.bindListenerGroup;
		
		if(c!=null){
			Set<ListenerInfo> bindListeners = bindListenerGroup.get(c);//获取该组件已绑定的监听器集合
			if(bindListeners==null){
				throw ExceptionUtils.getException(ListenerBindingException.class,"000005", null,"："+c.getClass().getName()+"：该组件从未绑定任何监听器");
			}
			Set<ListenerInfo> readyToRemove = new HashSet<ListenerInfo>();
			if(bindListeners.size()==0){
				throw ExceptionUtils.getException(ListenerBindingException.class, "000006", null, "："+c.getClass().getName());
			}
			//情况1
			if(listenerMethod==null && actionObj==null && actionMethod==null && argsTypes==null){
				a:for (ListenerInfo info : bindListeners) {
					Method[] componentMethods = c.getClass().getMethods();
					for (Method cm : componentMethods) {
						if(cm.getName().contains("remove") && cm.getName().contains("Listener")){
							Class<?>[] parameterTypes = cm.getParameterTypes();
							for (Class<?> class1 : parameterTypes) {
								try {
									if(EventListener.class.isAssignableFrom(class1)){
										Method[] eventListenerMethods = class1.getMethods();
										for (Method method : eventListenerMethods) {
											if(method.getName().equals(info.getListenerMethod())){
												cm.invoke(c, info.getBindListener());//真正地解绑监听器
												readyToRemove.add(info);
												count++;
												continue a;
											}
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
									throw new RuntimeException(e);
								}
							}
						}
					}
					
				}
			}
			//情况2
			if(listenerMethod!=null && actionObj==null && actionMethod==null && argsTypes==null){
				boolean found = false;
				Method removeListenerMethod = null;
				
				a:for (ListenerInfo info : bindListeners) {
					if(listenerMethod.equals(info.getListenerMethod())){
						found = true;
						if(removeListenerMethod==null){
							Method[] componentMethods = c.getClass().getMethods();
							for (Method cm : componentMethods) {
								if(cm.getName().contains("remove") && cm.getName().contains("Listener")){
									Class<?>[] parameterTypes = cm.getParameterTypes();
									for (Class<?> class1 : parameterTypes) {
										try {
											if(class1.newInstance() instanceof EventListener){
												Method[] eventListenerMethods = class1.getMethods();
												for (Method method : eventListenerMethods) {
													if(method.getName().equals(info.getListenerMethod())){
														removeListenerMethod = cm;
														cm.invoke(c, info.getBindListener());//真正地解绑监听器
														readyToRemove.add(info);
														count++;
														continue a;
													}
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
											throw new RuntimeException(e);
										}
									}
								}
							}
							
						}else{
							try {
								removeListenerMethod.invoke(c, info.getBindListener());
								readyToRemove.add(info);
								count++;
							} catch (Exception e) {
								e.printStackTrace();
								throw new RuntimeException(e);
							}
						}
					}
				}
				if(found==false){
					throw ExceptionUtils.getException(ListenerBindingException.class, "000007",null, "：组件："+c.getClass().getName()+"：监听器方法："+listenerMethod);
				}
				
			}
			//情况3
			if(listenerMethod==null && actionObj!=null && actionMethod==null && argsTypes==null){
				boolean found = false;
				a:for (ListenerInfo info : bindListeners) {
					if(info.getActionObj().equals(actionObj)){
						found=true;
						Method[] componentMethods = c.getClass().getMethods();
						for (Method cm : componentMethods) {
							if(cm.getName().contains("remove") && cm.getName().contains("Listener")){
								Class<?>[] parameterTypes = cm.getParameterTypes();
								for (Class<?> class1 : parameterTypes) {
									try {
										if(class1.newInstance() instanceof EventListener){
											Method[] eventListenerMethods = class1.getMethods();
											for (Method method : eventListenerMethods) {
												if(method.getName().equals(info.getListenerMethod())){
													cm.invoke(c, info.getBindListener());//真正地解绑监听器
													readyToRemove.add(info);
													count++;
													continue a;
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
										throw new RuntimeException(e);
									}
								}
							}
						}
					}
				}
				if(found==false){
					throw ExceptionUtils.getException(ListenerBindingException.class, "000008", null,"：组件："+c.getClass().getName()+"：action对象："+actionObj.getClass().getName());
				}
				
			}
			//情况4
			if(listenerMethod==null && actionObj==null && actionMethod!=null && argsTypes==null){
				boolean found = false;
				a:for (ListenerInfo info : bindListeners) {
					if(info.getMethodName().equals(actionMethod)){
						found=true;
						Method[] componentMethods = c.getClass().getMethods();
						for (Method cm : componentMethods) {
							if(cm.getName().contains("remove") && cm.getName().contains("Listener")){
								Class<?>[] parameterTypes = cm.getParameterTypes();
								for (Class<?> class1 : parameterTypes) {
									try {
										if(class1.newInstance() instanceof EventListener){
											Method[] eventListenerMethods = class1.getMethods();
											for (Method method : eventListenerMethods) {
												if(method.getName().equals(info.getListenerMethod())){
													cm.invoke(c, info.getBindListener());//真正地解绑监听器
													readyToRemove.add(info);
													count++;
													continue a;
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
										throw new RuntimeException(e);
									}
								}
							}
						}
					}
				}
				if(found==false){
					throw ExceptionUtils.getException(ListenerBindingException.class, "000008", null,"：组件："+c.getClass().getName()+"：action方法："+actionMethod);
				}
			}
			//情况5
			if(listenerMethod==null && actionObj==null && actionMethod!=null && argsTypes!=null){
				boolean found = false;
				a:for (ListenerInfo info : bindListeners) {
					if(info.getMethodName().equals(actionMethod) && ArrayUtils.isEquals(argsTypes, info.getArgs())){
						found=true;
						Method[] componentMethods = c.getClass().getMethods();
						for (Method cm : componentMethods) {
							if(cm.getName().contains("remove") && cm.getName().contains("Listener")){
								Class<?>[] parameterTypes = cm.getParameterTypes();
								for (Class<?> class1 : parameterTypes) {
									try {
										if(class1.newInstance() instanceof EventListener){
											Method[] eventListenerMethods = class1.getMethods();
											for (Method method : eventListenerMethods) {
												if(method.getName().equals(info.getListenerMethod())){
													cm.invoke(c, info.getBindListener());//真正地解绑监听器
													readyToRemove.add(info);
													count++;
													continue a;
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
										throw new RuntimeException(e);
									}
								}
							}
						}
					}
				}
				if(found==false){
					throw ExceptionUtils.getException(ListenerBindingException.class, "000008", null,"：组件："+c.getClass().getName()+"：action方法："+actionMethod+"：参数类型列表："+Arrays.toString(argsTypes));
				}
			}
			for(ListenerInfo info:readyToRemove){
				bindListeners.remove(info);
			}
		}else{
			throw ExceptionUtils.getException(ListenerBindingException.class,"000005", null,"：null");
		}
		return count;
	}

}
