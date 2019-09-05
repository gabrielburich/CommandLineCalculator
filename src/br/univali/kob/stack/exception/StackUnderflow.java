package br.univali.kob.stack.exception;

/**
 * Exception for empty stack
 *
 */
public class StackUnderflow extends RuntimeException {


	public StackUnderflow () {
		super("Stack is empty");
	}
	
	public StackUnderflow (String message) {
		super(message);
	}

}
