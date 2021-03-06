package fr.istic.aco.editor.core.impl;

import java.util.List;

import fr.istic.aco.editor.core.RecorderEngine;
import fr.istic.aco.editor.core.RecorderManager;
import fr.istic.aco.editor.core.command.Command;

/**
 * The Class RecorderEngineImpl.
 * Receiver class
 * @version 2
 */
public class RecorderEngineImpl implements RecorderEngine {

	/** The recorder manager. */
	private RecorderManager recorderManager;

	/** The start. */
	private int start;

	/** The final index. */
	private int finalIndex;

	/**
	 * Instantiates a new recorder engine impl.
	 */
	public RecorderEngineImpl() {
		recorderManager = new RecorderManagerImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.RecorderEngine#startRecording(int)
	 */
	@Override
	public void startRecording(int start) {
		this.start = start;
		recorderManager.record(true);
		System.out.println("DEBUG: performing Record start");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.RecorderEngine#stopRecording(int)
	 */
	@Override
	public void stopRecording(int finalIndex) {
		this.finalIndex = finalIndex;
		recorderManager.record(false);
		System.out.println("DEBUG: performing Record end");
	}

	/**
	 * @see fr.istic.aco.editor.core.RecorderEngine#replay(java.util.List)
	 * 
	 * @pre recorderManager.isRecording() is false
	 * @pre start < finalIndex
	 */
	@Override
	public void replay(List<Command> history) {
		if (!recorderManager.isRecording() && start < finalIndex) {
			System.out.println("DEBUG: performing Play");
			List<Command> commandsToExecute = history
					.subList(start, finalIndex);
			for (Command command : commandsToExecute) {
				command.execute();
			}
		}
		else {
			System.out.println("WARNING: nothing to Play");
		}
	}

}
