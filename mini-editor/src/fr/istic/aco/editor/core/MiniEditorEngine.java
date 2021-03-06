package fr.istic.aco.editor.core;

/**
 * The Interface MiniEditorEngine.
 * @version 1
 */
public interface MiniEditorEngine extends UndoRedoEngineOperation,
		MiniEditorReceiver {

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	public Buffer getBuffer();

	/**
	 * Gets the selection.
	 * 
	 * @return the selection
	 */
	public Selection getSelection();

	/**
	 * Gets the clipboard.
	 * @return the clipboard
	 */
	public Clipboard getClipboard();

	/**
	 * Engine select.
	 * 
	 * @version 1
	 * @param start
	 *            the start
	 * @param stop
	 *            the stop
	 */
	public void engineSelect(int start, int stop);

	/**
	 * Engine paste.
	 * 
	 * @version 1
	 */
	public void enginePaste();

	/**
	 * Engine insert.
	 * 
	 * @version 1
	 * @param insertString
	 *            the insert string
	 */
	public void engineInsert(String insertString);

	/**
	 * Engine cut.
	 * 
	 * @version 1
	 */
	public void engineCut();

	/**
	 * Engine copy.
	 * 
	 * @version 1
	 */
	public void engineCopy();

}
