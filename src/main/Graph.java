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

public class Graph<S> {

	private ArrayList<Vertex> verticesSet;
	private ArrayList<Edge<S>> edgesSet;
	
	public Graph() {
		
		verticesSet = new ArrayList<Vertex>();
		edgesSet = new ArrayList<Edge<S>>();
		
	}
	
	public ArrayList<Vertex> vertices() {
		return verticesSet;
	}
	
	public ArrayList<Edge<S>> edges() {
		return edgesSet;
	}
	
	public int countAllVertices() {
		return verticesSet.size();
	}
	
	public int countAllEdges() {
		return edgesSet.size();
	}
	
	public Edge<S> getEdge(Vertex v, Vertex w) throws Exception {
		
		for(int i = 0; i < edgesSet.size(); i++) {
			if ((edgesSet.get(i).edge.get(0) == v && edgesSet.get(i).edge.get(1) == w) || (edgesSet.get(i).edge.get(0) == w && edgesSet.get(i).edge.get(1) == v))
				return edgesSet.get(i);
		}
		
		throw new Exception("No such edge.");
		
	}
	
	public ArrayList<Edge<S>> incidentEdges(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<Edge<S>>();
		
		for(int i = 0; i < edgesSet.size(); i++) {
			if ((edgesSet.get(i).edge.get(0) == v || edgesSet.get(i).edge.get(1) == v))
				list.add(edgesSet.get(i));
		}
		
		return list;
		
	}
	
	public Vertex opposite(Vertex v, Edge<S> e) throws Exception {
		
		boolean isIncident = false;
		Edge<S> edge = null;
		
		for (int i=0; i<edgesSet.size(); i++) {
			if (edgesSet.get(i) == e && (edgesSet.get(i).edge.get(0) == v || edgesSet.get(i).edge.get(1) == v)) {
				isIncident = true;
				edge = edgesSet.get(i);
			}
		}
		
		if (!isIncident)
			throw new Exception("This edge is not incident on this vertex");
		
		else {
			if (edge.edge.get(0) == v)
				return edge.edge.get(1);
			else
				return edge.edge.get(0);
		}
		
	}
	
	public ArrayList<Vertex> endVertices(Edge<S> e) {
		
		ArrayList<Vertex> list = new ArrayList<Vertex>();
		
		for (int i=0; i<edgesSet.size(); i++) {
			if (edgesSet.get(i) == e) {
				list.add(edgesSet.get(i).edge.get(0));
				list.add(edgesSet.get(i).edge.get(1));
				break;
			}
		}
		
		return list;
		
	}
	
	public boolean areAdjacent(Vertex v, Vertex w) {
		
		for (int i=0; i<edgesSet.size(); i++) {
			if ((edgesSet.get(i).edge.get(0) == v && edgesSet.get(i).edge.get(1) == w) || (edgesSet.get(i).edge.get(0) == w && edgesSet.get(i).edge.get(1) == v)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public Graph<S> insertVertex(Vertex v) {
		
		for(int i = 0; i<verticesSet.size(); i++) {
			if (verticesSet.get(i) == v)
				return this;
		}
		
		verticesSet.add(v);
		return this;
		
	}
	
	public Graph<S> removeVertex(Vertex v) {
		
		verticesSet.remove(v);
		
		for (int i = 0; i < edgesSet.size(); i++) {
			if (edgesSet.get(i).edge.get(0) == v || edgesSet.get(i).edge.get(1) == v)
				edgesSet.remove(i);
		}
		
		return this;
		
	}
	
	public Graph<S> insertEdge(Vertex v, Vertex w, S x) {
		
		insertVertex(v);
		insertVertex(w);
		
		for (int i = 0; i < edgesSet.size(); i++) {
			if ((edgesSet.get(i).edge.get(0) == v && edgesSet.get(i).edge.get(1) == w) || (edgesSet.get(i).edge.get(0) == w && edgesSet.get(i).edge.get(1) == v)) {
				return this;
			}
		}
		
		ArrayList<Vertex> edge = new ArrayList<Vertex>();
		edge.add(v);
		edge.add(w);
		
		Edge<S> newEdge = new Edge<S>(edge, x);
		
		edgesSet.add(newEdge);
		
		return this;
		
	}
	
	public Graph<S> removeEdge(Vertex v, Vertex w) {
		
		for (int i = 0; i < edgesSet.size(); i++) {
			if ((edgesSet.get(i).edge.get(0) == v && edgesSet.get(i).edge.get(1) == w) || (edgesSet.get(i).edge.get(0) == w && edgesSet.get(i).edge.get(1) == v)) {
				edgesSet.remove(i);
				return this;
			}
		}
		
		return this;
		
	}
	
	public S getEdgeElem(Edge<S> e) throws Exception {
		
		for (int i=0; i<edgesSet.size(); i++) {
			if (edgesSet.get(i) == e)
				return edgesSet.get(i).element;
		}
		
		throw new Exception("Edge does not exist");
				
	}
	
	public Graph<S> replaceEdgeElem(Edge<S> e, S x) {
		
		for (int i=0; i<edgesSet.size(); i++) {
			if (edgesSet.get(i) == e) {
				edgesSet.get(i).element = x;
				return this;
			}
			
			
		}
		
		return this;
				
	}
	
	
	
}
