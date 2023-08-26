package telran.interviews;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T> {
	private LinkedList<T> stack;
	private LinkedList<T> maxValues;
	private Comparator<T> comparator;

	public Stack(Comparator<T> comp) {
		comparator = comp;
		stack = new LinkedList<T>();
		maxValues = new LinkedList<T>();
	}

	@SuppressWarnings("unchecked")
	public Stack() {
		this ((Comparator<T>) Comparator.naturalOrder());// ?
	}


	public void push(T element) {
		stack.add(element);
		if (maxValues.isEmpty() || comparator.compare(element, maxValues.getLast()) >= 0) {
			maxValues.add(element);
		}
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("stack is empty");
		}
		T toBeRemoved = stack.removeLast();
		if(comparator.compare(toBeRemoved, maxValues.getLast()) == 0) {
			maxValues.removeLast();
		}
		return toBeRemoved;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public T getMax() {
		if(isEmpty()) {
			throw new NoSuchElementException("no MAX value in empty stack");
		}
		return maxValues.getLast();
	}
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) stack.toArray();
	}
}
