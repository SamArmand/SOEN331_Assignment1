/*
 * SOEN 331 - Assignment 1
 * Winter 2015
 * 
 * Sam Assaf - 6150748
 * Jessica Falco - 6597882
 * 
 */

package main;

class Element<S> {

	private final S data;

	Element(S data) {
		this.data = data;
	}

	public String toString() {

		return data.toString();

	}
	
}
