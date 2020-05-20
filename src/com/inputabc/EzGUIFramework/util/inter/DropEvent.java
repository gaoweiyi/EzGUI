package com.inputabc.EzGUIFramework.util.inter;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;
/**
 * 
 * @author 高伟益
 * @version 1.3.1
 *
 */
public interface DropEvent{
	public void event(DropTargetDropEvent dtde) throws UnsupportedFlavorException, IOException;
}
