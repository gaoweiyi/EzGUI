package com.inputabc.EzGUIFramework.util;

import java.awt.Component;
import java.awt.Container;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.inputabc.EzGUIFramework.util.alias.Ez;

/**
 * 搜索组件的工具类
 * 
 * @author 高伟益
 * @version 1.2
 */
public class SearchUtils {
	private SearchUtils() {
	}

	/**
	 * 获取容器内组件名包含name的组件<br>
	 * 可选右模糊、左模糊、左右模糊
	 * 
	 * @param c
	 * @param name
	 * @param matchType     可选MATCH_LIKE_RIGHT、MATCH_LIKE_LEFT、MATCH_LIKE_BOTH
	 * @param temporaryList 临时的集合
	 * @return
	 * @since 1.6
	 */
	public static Collection<Component> getComponentsByNameLike(Container c, String name, int matchType,
			List<Component> temporaryList) {
		String srcComName = name;
		if (name == null) {
			srcComName = "null";
		}
		Component[] components = c.getComponents();
		for (Component component : components) {
			String targetComName = component.getName();
			if (targetComName == null) {
				targetComName = "null";
			}
			if (matchType == EzGUI.MATCH_LIKE_LEFT && targetComName.endsWith(srcComName)) {
				temporaryList.add(component);
			} else if (matchType == EzGUI.MATCH_LIKE_RIGHT && targetComName.startsWith(srcComName)) {
				temporaryList.add(component);
			} else if (matchType == EzGUI.MATCH_LIKE_BOTH && targetComName.contains(srcComName)) {
				temporaryList.add(component);
			}
			if (component instanceof Container) {
				getComponentsByNameLike((Container) component, srcComName, matchType, temporaryList);
			}
		}
		if (temporaryList.size() == 0) {
			return null;
		}
		Collection<Component> components2 = new HashSet<Component>();
		components2.addAll(temporaryList);
		return components2;
	}

	/**
	 * 获取容器内组件名包含name的组件<br>
	 * 该方法相当于getComponentsByNameLike(c, name, MATCH_LIKE_BOTH)
	 * 
	 * @param c
	 * @param name
	 * @param temporaryList 临时的集合
	 * @return
	 * @since 1.6
	 */
	public static Collection<Component> getComponentsByNameEqual(Container c, String name,
			List<Component> temporaryList) {
		String srcComName = name;
		if (name == null) {
			srcComName = "null";
		}
		Component[] components = c.getComponents();
		for (Component component : components) {
			String targetComName = component.getName();
			if (targetComName == null) {
				targetComName = "null";
			}
			if (targetComName.equals(srcComName)) {
				temporaryList.add(component);
			}
			if (component instanceof Container) {
				getComponentsByNameEqual((Container) component, srcComName, temporaryList);
			}
		}
		if (temporaryList.size() == 0) {
			return null;
		}
		Collection<Component> components2 = new HashSet<Component>();
		components2.addAll(temporaryList);
		return components2;
	}

	/**
	 * 一层层地获取目标组件所在父组件中的名字为形参name的组件
	 * 
	 * @param c
	 * @param name
	 * @param temporarySet
	 * @return
	 * @since 1.8
	 */
	public static Component getComponentWithCrossParentByNameEqual(Component c, String name,
			Set<Component> temporarySet) {
		if (name == null) {
			return null;
		}
		Component targetComponent = null;
		Container parent = c.getParent();
		if (parent == null) {
			return null;
		}
		if (name.equals(parent.getName())) {
			temporarySet.add(parent);
			return parent;
		}
		targetComponent = Ez.getComponentByNameEqual(parent, name);
		if (targetComponent != null) {
			temporarySet.add(targetComponent);
		} else {
			getComponentWithCrossParentByNameEqual(parent, name, temporarySet);
		}
		return targetComponent;
	}
	
}
