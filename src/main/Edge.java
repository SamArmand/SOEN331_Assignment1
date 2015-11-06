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

public class Edge<Y> { 
	  public final ArrayList<Vertex> edge; 
	  public Y element; 
	  public Edge(ArrayList<Vertex> edge, Y element) { 
	    this.edge = edge; 
	    this.element = element; 
	  } 
	} 