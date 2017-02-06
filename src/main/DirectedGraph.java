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

class DirectedGraph<S> extends Graph<S> {

	private ArrayList<Edge<S>> directedEdgesSet = new ArrayList<>();
	
	DirectedGraph<S> insertDirectedEdge(Vertex v, Vertex w, S element) {
		
		insertVertex(v);
		insertVertex(w);

		for (Edge<S> directedEdge : directedEdgesSet)
			if (directedEdge.edge.get(0) == v && directedEdge.edge.get(1) == w) return this;
		
		ArrayList<Vertex> edge = new ArrayList<>();
		edge.add(v);
		edge.add(w);
		
		Edge<S> newEdge = new Edge<>(edge, element);
		
		directedEdgesSet.add(newEdge);
		
		return this;
		
	}
	
	ArrayList<Edge<S>> incomingEdgesOf(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<>();

		for (Edge<S> directedEdge : directedEdgesSet)
			if (directedEdge.edge.get(1) == v)
				list.add(directedEdge);
		
		return list;
		
	}
	
	int inDegreeOf(Vertex v) {
		
		return incomingEdgesOf(v).size();
		
	}
	
	int outDegreeOf(Vertex v) {
		
		return outgoingEdgesOf(v).size();
		
	}
	
	ArrayList<Edge<S>> outgoingEdgesOf(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<>();

		for (Edge<S> directedEdge : directedEdgesSet) {
			if (directedEdge.edge.get(0) == v)
				list.add(directedEdge);
		}
		
		return list;
		
	}
	
	Edge<S> getDirectedEdge(Vertex v, Vertex w) throws Exception {

		for (Edge<S> directedEdge : directedEdgesSet) {
			if (directedEdge.edge.get(0) == v && directedEdge.edge.get(1) == w)
				return directedEdge;
		}
		
		throw new Exception("No such edge.");
		
	}
	
}
