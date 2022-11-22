package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;


public class IntegerSet {

	private ArrayList<Integer> localSet = new ArrayList<>();
	
	public IntegerSet() {
	}
	
	public ArrayList<Integer> getLocalSet() {
		return localSet;
	}

	/**
	 * Clear out all items from the set
	 */
	public void clear() {
		localSet.clear();
	}
	
	/**
	 * Return number of items in IntegerSet
	 * 
	 * @return int value
	 */
	public int length() {
		return localSet.size();
	}
	
	
	/**
	 * Return if two sets are equal, order does not matter.
	 * 
	 * @param otherSet set to compare with local one
	 * @return true if equal, otherwise false
	 */
	public boolean equals(IntegerSet otherSet) {
		
		if (length() != otherSet.length()) {
			return false;
		}
		
		ArrayList<Integer> copyOfLocal = new ArrayList<Integer>(localSet);
		Collections.sort(copyOfLocal);
		ArrayList<Integer> copyOfOther = new ArrayList<Integer>(otherSet.getLocalSet());
		Collections.sort(copyOfOther);
		
		return copyOfLocal.equals(copyOfOther);
	} 

	/**
	 * Determine if IntegerSet contains the passed in number
	 * 
	 * @param number item to check
	 * @return true if number is there, otherwise false
	 */
	public boolean contains(int number) {
		return this.localSet.contains(number);
	}
	
	/**
	 * Return largest number in IntegerSet
	 * 
	 * @return  int, largest number
	 * @throws IntegerSetException if IntegerSet is empty
	 */
	public int largest() throws IntegerSetException {
		if (localSet.isEmpty()) {
			throw new IntegerSetException("An empty set can't have largest element!");
		}
		return Collections.max(localSet);	
	} 

	/**
	 * Return smallest number in IntegerSet
	 * 
	 * @return  int, smallest number
	 * @throws IntegerSetException if IntegerSet is empty
	 */
	public int smallest() throws IntegerSetException {
		if (localSet.isEmpty()) {
			throw new IntegerSetException("An empty set can't have smallest element!");
		}
		
		return Collections.min(localSet);
	}
	
	/**
	 * Adds an item to the set if it is not already present there
	 * @param item value that is sent to be added in the set
	 */
	public void add(int item) {
		if (!localSet.contains(item)) {
			localSet.add(item);
		}
	}
	
	/**
	 * Remove an item from IntegerSet
	 * 
	 * @param item	item to remove
	 */
	public void remove(int item) {
		localSet.remove(localSet.indexOf(item));	// will ignore if not there
	}
	
	/**
	 * Combine IntegerSets.  There should not be any dups.
	 * 
	 * @param otherSet	set to combine with local set.
	 */
	public void union(IntegerSet otherSet) {	
		for (Integer item : otherSet.getLocalSet()) {
			add(item);
		}
	}
	
	/**
	 * Intersects two sets, retains all values from intSetb in MySet
	 * @param otherSet of type IntegerSet
	 */
	public void intersect(IntegerSet otherSet) {
		localSet.retainAll(otherSet.getLocalSet());
	}
	
	/**
	 * Removes all the elements of otherSet from MySet to find the difference
	 * @param otherSet of type IntegerSet
	 */
	public void diff(IntegerSet otherSet) {
		localSet.removeAll(otherSet.getLocalSet());
	}
	
	/**
	 * Checks if IntegerSet is empty
	 * @return true if the set is empty, else false
	 */
	public boolean isEmpty() {
		return localSet.isEmpty();
	}
	
	/**
	 * Overrides default implementation of toString()
	 * 
	 * @return the string representation of the set
	 */
	@Override
	public String toString() {
		return localSet.toString();
	}
}