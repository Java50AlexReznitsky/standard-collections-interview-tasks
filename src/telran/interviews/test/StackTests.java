package telran.interviews.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Stack;

class StackTests {
	private Stack<Integer> stack;
	private Integer[] testArray = { 5, 12, 957, -30, 46, 85 };

	@BeforeEach
	void setUp() {
		stack = new Stack<>();
		for (Integer elm : testArray) {
			stack.push(elm);
		}
	}

	@Test
	void pushTest() {
		Integer[] expected = { 5, 12, 957, -30, 46, 85 };
		assertArrayEquals(expected, stack.toArray());
	}

	@Test
	void isEmptyTest() {
		Integer[] expected = { 5, 12, 957, -30, 46, 85 };
		for (int i = 0; i < expected.length; i++) {
			stack.pop();
		}
		assertTrue(stack.isEmpty());
		assertThrowsExactly(NoSuchElementException.class, () -> stack.pop());
		stack.push(10);
		assertFalse(stack.isEmpty());
	}

	@Test
	void popTest() {
		Integer[] expected = { 5, 12, 957, -30, 46 };
		int removedItem = stack.pop();
		assertArrayEquals(expected, stack.toArray());
		assertEquals(85, removedItem);
		removedItem = stack.pop();
		assertEquals(46, removedItem);
		while (!stack.isEmpty()) {
			stack.pop();
		}
		assertThrowsExactly(NoSuchElementException.class, () -> stack.pop());
	}

	@Test
	void getMaxTest() {
		assertEquals(957, stack.getMax());
		for (int i = 0; i != 4; i++) {
			stack.pop();
		}
		assertEquals(12, stack.getMax());
		while (!stack.isEmpty()) {
			stack.pop();
		}
		assertThrowsExactly(NoSuchElementException.class, () -> stack.getMax());
	}

}
