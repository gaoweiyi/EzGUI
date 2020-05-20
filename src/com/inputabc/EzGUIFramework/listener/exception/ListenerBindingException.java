package com.inputabc.EzGUIFramework.listener.exception;

import com.inputabc.EzGUIFramework.context.EzGUIException;
/**
 * 
 * @author gaoweiyi
 *
 */
public class ListenerBindingException extends RuntimeException implements EzGUIException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6305293400269553082L;
	public ListenerBindingException(String msg){
		super(msg);
	}
}
