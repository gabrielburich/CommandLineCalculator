package br.univali.kob.stack.model;

import br.univali.kob.stack.exception.StackUnderflow;

import java.util.Objects;

public class Stack <T> {
	
	private Node start;
	private Node end;
	private int cardinality;
	
	/**
	 * Default Class constructor
	 */
	public Stack() {
		this.cardinality = 0;
		this.start = null;
		this.end = null;
	}
	
	/**
	 * Inserts an element on Stack
	 * @param element
	 */
	public void insert(T element) {
		Node newNode = new Node(element);
		if (this.end == null) {
			this.end = newNode;
			this.start = this.end;
		} else if (this.start == this.end) {
			newNode.setPrevious(this.end);
			this.end.setNext(newNode);
			this.start = newNode;
		} else {
			newNode.setPrevious(this.start);
			this.start.setNext(newNode);
			this.start = newNode;
		}
		this.cardinality++;
	}
	
	/**
	 * Removes an element from Stack
	 */
	public void remove() {
		if (!isEmpty()) {
			if (this.start == this.end) {
				this.start = null;
				this.end = null;
			} else {
				Node auxNode = this.start.getPrevious();
				auxNode.setNext(null);
				this.start = auxNode;
			}
			this.cardinality--;
		} else {
			throw new StackUnderflow();
		}
	}
	
	/**
	 * Get an element on a position
	 * @param  position
	 * @return T element
	 */
	public T get(int position) {
		if (validPosition(position)) {
			Node controlNode = this.end;
			for (int i = 0; i < position; i++ ) {
				controlNode = controlNode.getNext();
			}		
			return (T) controlNode.getElement();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	/**
	 * Get the top element
	 * @return T element
	 */
	public T getFirst() {
		return (T) start.getElement();
	}

	/**
	 * Get the last element
	 * @return T element
	 */
	public T getLast() {
		return (T) end.getElement();
	}

	/**
	 * Checks if an element is on Stack
	 * @param  element to compare
	 * @return boolean
	 * true: find element, false not find element
	 */
	public boolean isOn(T element) {
		if (!isEmpty()) {
			Node controlNode = this.end;
			while (controlNode != null) {
				if (controlNode.getElement().equals(element)) {
					return true;
				}
				controlNode = controlNode.getNext();
			}
		} else {
			throw new StackUnderflow();
		}
		
		return false;
	}
	
	/**
	 * Get an element position
	 * @param  element to compare
	 * @return int position, -1 not found
	 */
	public int getPosition(T element) {
		if (!isEmpty()) {
			Node controlNode = this.end;
			int counter = 0;
			while (controlNode != null) {
				if (controlNode.getElement().equals(element)) {
					return counter;
				}
				controlNode = controlNode.getNext();
				counter++;
			}
		} else {
			throw new StackUnderflow();
		}
		
		return -1;
	}
	
	/**
	 * Checks if the stack is empty
	 * @return boolean, 
	 * true: empty, false: at least one element
	 */
	public boolean isEmpty() {
		return this.cardinality == 0;
	}
	
	/**
	 * Return elements number of stack
	 * @return cardinality
	 */
	public int getCardinality() {
		return this.cardinality;
	}
	
	/**
	 * Checks if a position is valid
	 * @param  position
	 * @return true valid, false invalid
	 */
	public boolean validPosition(int position) {
		return position >= 0 && position < this.cardinality;
	}
	
	/**
	 * Show the stack as String
	 * @return String
	 */
	public String asString() {
		String output = " Stack = [ ";
		if (!isEmpty()) {
			Node controlNode = this.end;
			while (controlNode != null) {
				output += " " + controlNode.getElement().toString() + ",";
				controlNode = controlNode.getNext();
			}
		}
		return output.substring(0,output.length()-1).concat(" ]");
	}

	@Override
	public String toString() {
		return "Stack [start=" + start + ", end=" + end + ", cardinality=" + cardinality + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Stack<?> stack = (Stack<?>) o;
		return cardinality == stack.cardinality &&
				Objects.equals(start, stack.start) &&
				Objects.equals(end, stack.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end, cardinality);
	}
}
