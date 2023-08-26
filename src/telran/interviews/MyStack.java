package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack<T> {
	private LinkedList<T> myLinkedList;
	private LinkedList<T> maxValues;
	private Comparator<T> comparator;

	public MyStack(Comparator<T> comp) {
		comparator = comp;
		myLinkedList = new LinkedList<T>();
		maxValues = new LinkedList<T>();
	}

	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	public void push(T element) {
		myLinkedList.add(element);
		if (maxValues.isEmpty() || comparator.compare(element, maxValues.getLast()) >= 0) {
			maxValues.add(element);
		} else {
			maxValues.add(maxValues.getLast());
		}
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("empty stack");
		}
		T removedElement = myLinkedList.removeLast();
		maxValues.remove(maxValues.getLast());
		return removedElement;
	}

	public boolean isEmpty() {
		return myLinkedList.size() == 0 && maxValues.size() == 0 ? true : false;
	}

	public T getMax() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return maxValues.getLast();
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) myLinkedList.toArray();
	}
}
