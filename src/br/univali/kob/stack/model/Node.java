package br.univali.kob.stack.model;

/**
 * A Stack node
 */
public class Node {
	
	private Object element;
	private Node next;
	private Node previous;
	
	/**
	 * Default Class constructor
	 * @param element
	 */
	public Node(Object element) {
		this.element = element;
		this.next = null;
		this.previous = null;
	}

	/**
	 * Get the Node element
	 * @return Object element
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * Set the Node element
	 * @param  element
	 */
	public void setElement(Object element) {
		this.element = element;
	}
	
	/**
	 * Return the next Node
	 * @return Node next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * Set next Node
	 * @param  next
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Get the previous node
	 * @return Node previous
	 */
	public Node getPrevious() {
		return previous;
	}

	/**
	 * Set previous Node
	 * @param  previous
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
		
}
