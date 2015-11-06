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

public class DirectedGraph<S> extends Graph<S> {

	private ArrayList<Edge<S>> directedEdgesSet;
	
	public DirectedGraph() {
		
		directedEdgesSet = new ArrayList<Edge<S>>();
		
	}
	
	public DirectedGraph<S> insertDirectedEdge(Vertex v, Vertex w, S x) {
		
		insertVertex(v);
		insertVertex(w);
		
		for (int i = 0; i < directedEdgesSet.size(); i++) {
			if (directedEdgesSet.get(i).edge.get(0) == v && directedEdgesSet.get(i).edge.get(1) == w) {
				return this;
			}
		}
		
		ArrayList<Vertex> edge = new ArrayList<Vertex>();
		edge.add(v);
		edge.add(w);
		
		Edge<S> newEdge = new Edge<S>(edge, x);
		
		directedEdgesSet.add(newEdge);
		
		return this;
		
	}
	
	public ArrayList<Edge<S>> incomingEdgesOf(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<Edge<S>>();
		
		for (int i = 0; i < directedEdgesSet.size(); i++) {
			if (directedEdgesSet.get(i).edge.get(1) == v)
				list.add(directedEdgesSet.get(i));
		}
		
		return list;
		
	}
	
	public int inDegreeOf(Vertex v) {
		
		return incomingEdgesOf(v).size();
		
	}
	
	public int outDegreeOf(Vertex v) {
		
		return outgoingEdgesOf(v).size();
		
	}
	
	public ArrayList<Edge<S>> outgoingEdgesOf(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<Edge<S>>();
		
		for (int i = 0; i < directedEdgesSet.size(); i++) {
			if (directedEdgesSet.get(i).edge.get(0) == v)
				list.add(directedEdgesSet.get(i));
		}
		
		return list;
		
	}
	
	public Edge<S> getDirectedEdge(Vertex v, Vertex w) throws Exception {
		
		for(int i = 0; i < directedEdgesSet.size(); i++) {
			if (directedEdgesSet.get(i).edge.get(0) == v && directedEdgesSet.get(i).edge.get(1) == w)
				return directedEdgesSet.get(i);
		}
		
		throw new Exception("No such edge.");
		
	}
	
}
