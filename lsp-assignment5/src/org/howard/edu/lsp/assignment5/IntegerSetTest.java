package org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IntegerSetTest {
	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		IntegerSet set= new IntegerSet();
		set.add(1);
		set.add(2);
		set.add(3);
		
		assertEquals("[1, 2, 3]",set.toString());			
	}
	

	@Test
	@DisplayName("Test case for Remove")
	public void testRemove() {
		IntegerSet set= new IntegerSet();
		set.add(1);
		set.add(2);
		set.add(3);
		
		assertEquals("[1, 2, 3]",set.toString());
		set.remove(3);
		assertEquals("[1, 2]",set.toString());
	}


	@Test
	@DisplayName("Test case for testRemove throws exception")
	public void testRemove_THROWS_EXCEPTION() {
		IntegerSet set = new IntegerSet();
		IntegerSetException exception = assertThrows(IntegerSetException.class, ()->{
			set.remove(50);
		});
		String expectedMessage = "Can't remove from an empty set";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	
	@Test
	@DisplayName("Test Contains")
	public void testContains() {
		IntegerSet set = new IntegerSet();
		set.add(10);
		set.add(20);
		assertTrue(set.contains(10));
		assertFalse(set.contains(30));
	}
	
	@Test
	@DisplayName("Test isEmpty")
	public void testEmpty() {
		IntegerSet set = new IntegerSet();
		assertTrue(set.isEmpty());
		set.add(10);
		assertFalse(set.isEmpty());
	}
	
	@Test
	@DisplayName("Test toString")
	public void testToString() {
		IntegerSet set = new IntegerSet();
		set.add(10);
		set.add(20);
		set.add(30);
	
		assertEquals("[10, 20, 30]", set.toString());
	}

	
	@Test
	@DisplayName("Test Union")
	public void testUnion() {
		IntegerSet setA = new IntegerSet();
		setA.add(10);
		setA.add(20);
		setA.add(30);
		
		IntegerSet setB = new IntegerSet();
		setB.add(10);
		setB.add(40);
		setB.add(50);
		setB.add(60);
		
		setA.union(setB);
		
		assertEquals("[10, 20, 30, 40, 50, 60]", setA.toString());
	}
	
	@Test
	@DisplayName("Test Intersect")
	public void testIntersect() {
		IntegerSet setA = new IntegerSet();
		setA.add(10);
		setA.add(20);
		setA.add(30);
		
		IntegerSet setB = new IntegerSet();
		setB.add(10);
		setB.add(40);
		setB.add(50);
		setB.add(60);
		
		setA.intersect(setB);
		
		assertEquals("[10]", setA.toString());
	}


	@Test
	@DisplayName("Test Difference")
	public void testDifference() {
		IntegerSet setA = new IntegerSet();
		setA.add(10);
		setA.add(20);
		setA.add(30);
		setA.add(40);
		setA.add(50);
		
		IntegerSet setB = new IntegerSet();
		setB.add(40);
		setB.add(50);
		
		setA.diff(setB);
		
		assertEquals("[10, 20, 30]", setA.toString());
	}

	
	@Test
	@DisplayName("Test Equals")
	public void testEquals() {
		IntegerSet setA = new IntegerSet();
		setA.add(40);
		setA.add(50);
		
		IntegerSet setB = new IntegerSet();
		setB.add(50);
		setB.add(40);
		
		assertTrue(setA.equals(setB));
		
		setB.add(60);
		
		assertFalse(setA.equals(setB));
	}


	@Test
	@DisplayName("Test Largest")
	public void testLargest() throws IntegerSetException {
		IntegerSet set = new IntegerSet();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		assertEquals(50, set.largest());
	}

	
	@Test
	@DisplayName("Test Smallest")
	public void testSmallest() throws IntegerSetException {
		IntegerSet set = new IntegerSet();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		assertEquals(10, set.smallest());
	}

	@Test
	@DisplayName("Test case for smallest throws exception")
	public void testSmallest_THROWS_EXCEPTION() {
		IntegerSet setA = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, ()->{
			setA.smallest();
		});
		String expectedMessage = "An empty set can't have smallest element!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
	
	
	@Test
	@DisplayName("Test case for Largest throws exception")
	public void testLargest_THROWS_EXCEPTION() {
		IntegerSet setA = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, ()->{
			setA.largest();
		});
		String expectedMessage = "An empty set can't have largest element!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.equals(expectedMessage));
	}
}