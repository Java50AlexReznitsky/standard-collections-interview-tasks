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
//package telran.interviews.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.NoSuchElementException;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import telran.interviews.Stack;
//
//class StackTests {
//	int ar[]= {100_000,50_000,100_000,20,20,20,2_000_000, 2_000_000};
//	Stack<Integer> myStack;
//	Stack<String> emptyStack = new Stack<>();
//	@BeforeEach
//	void setUp() throws Exception {
//		myStack = new Stack<>();
//		fillStack(myStack);
//	}
//
//
//
//	private void fillStack(Stack<Integer> stack) {
//		for(int num: ar) {
//			stack.push(num);
//		}
//	}
//
//	
//
//	@Test
//	void testPop() {
//		assertEquals(2_000_000, myStack.pop());
//		assertEquals(2_000_000, myStack.pop());
//		assertThrowsExactly(NoSuchElementException.class, () -> emptyStack.pop());
//		
//	}
//
//	@Test
//	void testIsEmpty() {
//		assertFalse(myStack.isEmpty());
//		assertTrue(emptyStack.isEmpty());
//	}
//
//	@Test
//	void testGetMax() {
//		assertEquals(2_000_000, myStack.getMax());
//		myStack.pop();
//		assertEquals(2_000_000, myStack.getMax());
//		myStack.pop();
//		assertEquals(100_000, myStack.getMax());
//		myStack.push(100);
//		assertEquals(100_000, myStack.getMax());
//		myStack.push(1_000_000);
//		assertEquals(1_000_000, myStack.getMax());
//		assertThrowsExactly(NoSuchElementException.class, () -> emptyStack.getMax());
//		
//		
//	}
//	@Test
//	void testComparator() {
//		Stack<Integer> reversedStack = new Stack<>((a, b) -> Integer.compare(b, a));
//		fillStack(reversedStack);
//		assertEquals(20, reversedStack.getMax());
//	}
//
//}
