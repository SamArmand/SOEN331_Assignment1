/*
 * SOEN 331 - Assignment 1
 * Winter 2015
 * 
 * Sam Assaf - 6150748
 * Jessica Falco - 6597882
 * 
 */

package main;

import java.util.ArrayList;

class Edge<Y> {

	final ArrayList<Vertex> edge;
	Y element;

	Edge(ArrayList<Vertex> edge, Y element) {
		this.edge = edge;
		this.element = element;
	}

}