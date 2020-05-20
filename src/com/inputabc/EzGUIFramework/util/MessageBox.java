package com.inputabc.EzGUIFramework.util;
import java.awt.Component;
import javax.swing.JOptionPane;
/**
 * 消息框工具类
 * @author 高伟益
 * @since 2020/1/23
 * @version 3.1
 */
public abstract class MessageBox {
	/**
	 *  提示框
	 *	内容自定义
	 * @param parent
	 * @param message
	*/
	public static void alert(Component parent,String message){
		
		JOptionPane.showMessageDialog(parent, message,"提示",JOptionPane.DEFAULT_OPTION );
	}
	/**
	 * 提示框
	 * 内容，标题自定义
	 * @param parent
	 * @param message
	 * @param title
	 */
	public static void alert(Component parent,String message,String title){
		
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.DEFAULT_OPTION);
	}
	/**
	 * 提示框
	 * 内容，标题，类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param type
	 */
	public static void alert(Component parent,String message,String title,int type){
		
		JOptionPane.showMessageDialog(parent, message, title,type);
	}
	/**
	 * 提示框
	 * 内容，标题，类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param type
	 */
	public static void alert(Component parent,String message,String title,String type){
		int typeC = 0;
		if(type==null||type==""||type.replace(" ", "")==""){
			typeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(type)||"x".equalsIgnoreCase(type)){
				typeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(type)||"warn".equalsIgnoreCase(type)||"!".equalsIgnoreCase(type)){
				typeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(type)||"msg".equalsIgnoreCase(type)||"info".equalsIgnoreCase(type)||"information".equalsIgnoreCase(type)||"i".equalsIgnoreCase(type)){
				typeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(type)||"?".equalsIgnoreCase(type)){
				typeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				typeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		JOptionPane.showMessageDialog(parent,message, title, typeC);
	}
	/**
	 * 确认框
	 * 内容自定义
	 * @param parent
	 * @param message
	 * @return
	 */
	public static boolean confirm(Component parent,String message){
		
		int confirm = JOptionPane.showConfirmDialog(parent,message, "确认", JOptionPane.YES_NO_OPTION);
		if(confirm==0){
			return true;
		}
		return false;
	}
	/**
	 * 确认框
	 * 内容，标题自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @return
	 */
	public static boolean confirm(Component parent,String message,String title){
		
		int confirm = JOptionPane.showConfirmDialog(parent,message, title, JOptionPane.YES_NO_OPTION);
		if(confirm==0){
			return true;
		}
		return false;
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param optionType
	 * @return
	 */
	public static int confirm(Component parent,String message,String title,int optionType){
		
		return JOptionPane.showConfirmDialog(parent, message, title, optionType);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param optionType
	 * @return
	 */
	public static int confirm(Component parent,String message,String title,String optionType){
		
		int optionTypeC = 0;
		if(optionType==null||optionType==""||optionType.replace(" ", "")==""){
			optionTypeC = JOptionPane.YES_NO_OPTION;
		}else{
			if("yes_no_cancel".equalsIgnoreCase(optionType)||"ok_no_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.YES_NO_CANCEL_OPTION;
			}else if("yes_cancel".equalsIgnoreCase(optionType)||"ok_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.OK_CANCEL_OPTION;
			}
		}
		return JOptionPane.showConfirmDialog(parent, message, title, optionTypeC);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型，消息类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param optionType
	 * @param messageType
	 * @return
	 */
	public static int confirm(Component parent,String message,String title,int optionType,int messageType){
		
		return JOptionPane.showConfirmDialog(parent, message, title, optionType,messageType);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型，消息类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param optionType
	 * @param messageType
	 * @return
	 */
	public static int confirm(Component parent,String message,String title,String optionType,String messageType){
		
		int optionTypeC = 0;
		int messageTypeC = 0;
		if(optionType==null||optionType==""||optionType.replace(" ", "")==""){
			optionTypeC = JOptionPane.YES_NO_OPTION;
		}else{
			if("yes_no_cancel".equalsIgnoreCase(optionType)||"ok_no_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.YES_NO_CANCEL_OPTION;
			}else if("yes_cancel".equalsIgnoreCase(optionType)||"ok_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.OK_CANCEL_OPTION;
			}
		}
		if(messageType==null||messageType==""||messageType.replace(" ", "")==""){
			messageTypeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(messageType)||"x".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(messageType)||"warn".equalsIgnoreCase(messageType)||"!".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(messageType)||"msg".equalsIgnoreCase(messageType)||"info".equalsIgnoreCase(messageType)||"information".equalsIgnoreCase(messageType)||"i".equalsIgnoreCase(messageType)){
				messageTypeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(messageType)||"?".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				messageTypeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		return JOptionPane.showConfirmDialog(parent,message, title, optionTypeC, messageTypeC);	
	}
	/**
	 * 输入框
	 * 内容自定义
	 * @param parent
	 * @param message
	 * @return
	 */
	public static String input(Component parent,String message){
		
		return JOptionPane.showInputDialog(parent,message);
	}
	/**
	 * 输入框
	 * 内容，默认内容自定义
	 * @param parent
	 * @param message
	 * @param placeholder
	 * @return
	 */
	public static String input(Component parent,String message,String placeholder){
		
		return JOptionPane.showInputDialog(parent,message,placeholder);
	}
	/**
	 * 输入框
	 * 内容，标题，消息类型自定义
	 * @param parent
	 * @param message
	 * @param title
	 * @param messageType
	 * @return
	 */
	public static String input(Component parent,String message,String title,String messageType){
		
		int messageTypeC = 0;
		if(messageType==null||messageType==""||messageType.replace(" ", "")==""){
			messageTypeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(messageType)||"x".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(messageType)||"warn".equalsIgnoreCase(messageType)||"!".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(messageType)||"msg".equalsIgnoreCase(messageType)||"info".equalsIgnoreCase(messageType)||"information".equalsIgnoreCase(messageType)||"i".equalsIgnoreCase(messageType)){
				messageTypeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(messageType)||"?".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				messageTypeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		return JOptionPane.showInputDialog(parent, message, title, messageTypeC);
	}

	/**
	 *  提示框
	 *	内容自定义
	 * @param message
	 */
	public static void alert(String message){
		
		JOptionPane.showMessageDialog(null, message,"提示",JOptionPane.DEFAULT_OPTION );
	}
	/**
	 * 提示框
	 * 内容，标题自定义
	 * @param message
	 * @param title
	 */
	public static void alert(String message,String title){
		
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
	}
	/**
	 * 提示框
	 * 内容，标题，类型自定义
	 * @param message
	 * @param title
	 * @param type
	 */
	public static void alert(String message,String title,int type){
		
		JOptionPane.showMessageDialog(null, message, title,type);
	}
	/**
	 * 提示框
	 * 内容，标题，类型自定义
	 * @param message
	 * @param title
	 * @param type
	 */
	public static void alert(String message,String title,String type){
		
		int typeC = 0;
		if(type==null||type==""||type.replace(" ", "")==""){
			typeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(type)||"x".equalsIgnoreCase(type)){
				typeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(type)||"warn".equalsIgnoreCase(type)||"!".equalsIgnoreCase(type)){
				typeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(type)||"msg".equalsIgnoreCase(type)||"info".equalsIgnoreCase(type)||"information".equalsIgnoreCase(type)||"i".equalsIgnoreCase(type)){
				typeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(type)||"?".equalsIgnoreCase(type)){
				typeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				typeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		JOptionPane.showMessageDialog(null,message, title, typeC);
	}
	/**
	 * 确认框
	 * 内容自定义
	 * @param message
	 * @return
	 */
	public static boolean confirm(String message){
		
		int confirm = JOptionPane.showConfirmDialog(null,message, "确认", JOptionPane.YES_NO_OPTION);
		if(confirm==0){
			return true;
		}
		return false;
	}
	/**
	 * 确认框
	 * 内容，标题自定义
	 * @param message
	 * @param title
	 * @return
	 */
	public static boolean confirm(String message,String title){
	
		int confirm = JOptionPane.showConfirmDialog(null,message, title, JOptionPane.YES_NO_OPTION);
		if(confirm==0){
			return true;
		}
		return false;
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型自定义
	 * @param message
	 * @param title
	 * @param optionType
	 * @return
	 */
	public static int confirm(String message,String title,int optionType){
		
		return JOptionPane.showConfirmDialog(null, message, title, optionType);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型自定义
	 * @param message
	 * @param title
	 * @param optionType
	 * @return
	 */
	public static int confirm(String message,String title,String optionType){
		
		int optionTypeC = 0;
		if(optionType==null||optionType==""||optionType.replace(" ", "")==""){
			optionTypeC = JOptionPane.YES_NO_OPTION;
		}else{
			if("yes_no_cancel".equalsIgnoreCase(optionType)||"ok_no_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.YES_NO_CANCEL_OPTION;
			}else if("yes_cancel".equalsIgnoreCase(optionType)||"ok_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.OK_CANCEL_OPTION;
			}
		}
		return JOptionPane.showConfirmDialog(null, message, title, optionTypeC);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型，消息类型自定义
	 * @param message
	 * @param title
	 * @param optionType
	 * @param messageType
	 * @return
	 */
	public static int confirm(String message,String title,int optionType,int messageType){
		
		return JOptionPane.showConfirmDialog(null, message, title, optionType,messageType);
	}
	/**
	 * 确认框
	 * 内容，标题，选项类型，消息类型自定义
	 * @param message
	 * @param title
	 * @param optionType
	 * @param messageType
	 * @return
	 */
	public static int confirm(String message,String title,String optionType,String messageType){
		
		int optionTypeC = 0;
		int messageTypeC = 0;
		if(optionType==null||optionType==""||optionType.replace(" ", "")==""){
			optionTypeC = JOptionPane.YES_NO_OPTION;
		}else{
			if("yes_no_cancel".equalsIgnoreCase(optionType)||"ok_no_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.YES_NO_CANCEL_OPTION;
			}else if("yes_cancel".equalsIgnoreCase(optionType)||"ok_cancel".equalsIgnoreCase(optionType)){
				optionTypeC = JOptionPane.OK_CANCEL_OPTION;
			}
		}
		if(messageType==null||messageType==""||messageType.replace(" ", "")==""){
			messageTypeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(messageType)||"x".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(messageType)||"warn".equalsIgnoreCase(messageType)||"!".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(messageType)||"msg".equalsIgnoreCase(messageType)||"info".equalsIgnoreCase(messageType)||"information".equalsIgnoreCase(messageType)||"i".equalsIgnoreCase(messageType)){
				messageTypeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(messageType)||"?".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				messageTypeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		return JOptionPane.showConfirmDialog(null,message, title, optionTypeC, messageTypeC);	
	}
	/**
	 * 输入框
	 * 内容自定义
	 * @param message
	 * @return
	 */
	public static String input(String message){
		
		return JOptionPane.showInputDialog(message);
	}
	/**
	 * 输入框
	 * 内容，默认内容自定义
	 * @param message
	 * @param placeholder
	 * @return
	 */
	public static String input(String message,String placeholder){
		
		return JOptionPane.showInputDialog(message,placeholder);
	}
	/**
	 * 输入框
	 * 内容，标题，消息类型自定义
	 * @param message
	 * @param title
	 * @param messageType
	 * @return
	 */
	public static String input(String message,String title,String messageType){
		
		int messageTypeC = 0;
		if(messageType==null||messageType==""||messageType.replace(" ", "")==""){
			messageTypeC = JOptionPane.DEFAULT_OPTION;
		}else{
			if("error".equalsIgnoreCase(messageType)||"x".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.ERROR_MESSAGE;
			}else if("warning".equalsIgnoreCase(messageType)||"warn".equalsIgnoreCase(messageType)||"!".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.WARNING_MESSAGE;
			}else if("message".equalsIgnoreCase(messageType)||"msg".equalsIgnoreCase(messageType)||"info".equalsIgnoreCase(messageType)||"information".equalsIgnoreCase(messageType)||"i".equalsIgnoreCase(messageType)){
				messageTypeC  = JOptionPane.INFORMATION_MESSAGE;
			}else if("question".equalsIgnoreCase(messageType)||"?".equalsIgnoreCase(messageType)){
				messageTypeC = JOptionPane.QUESTION_MESSAGE;
			}else{
				messageTypeC = JOptionPane.DEFAULT_OPTION;
			}
		}
		return JOptionPane.showInputDialog(null, message, title, messageTypeC);
	}
}
