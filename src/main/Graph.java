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

class Graph<S> {

	private ArrayList<Vertex> verticesSet;
	private ArrayList<Edge<S>> edgesSet;
	
	Graph() {
		
		verticesSet = new ArrayList<>();
		edgesSet = new ArrayList<>();
		
	}
	
	ArrayList<Vertex> vertices() {
		return verticesSet;
	}
	
	ArrayList<Edge<S>> edges() {
		return edgesSet;
	}
	
	int countAllVertices() {
		return verticesSet.size();
	}
	
	int countAllEdges() {
		return edgesSet.size();
	}
	
	Edge<S> getEdge(Vertex v, Vertex w) throws Exception {

		for (Edge<S> edge : edgesSet)
			if ((edge.edge.get(0) == v && edge.edge.get(1) == w) || (edge.edge.get(0) == w && edge.edge.get(1) == v))
				return edge;
		
		throw new Exception("No such edge.");
		
	}
	
	ArrayList<Edge<S>> incidentEdges(Vertex v) {
		
		ArrayList<Edge<S>> list = new ArrayList<>();

		for (Edge<S> edge : edgesSet)
			if ((edge.edge.get(0) == v || edge.edge.get(1) == v))
				list.add(edge);
		
		return list;
		
	}
	
	Vertex opposite(Vertex v, Edge<S> e) throws Exception {


		for (Edge<S> edge : edgesSet) {

			if (edge != e) continue;

			if (edge.edge.get(0) == v)
				return edge.edge.get(1);
			else
				return edge.edge.get(0);
		}

		throw new Exception("This edge is not incident on this vertex");
		
	}
	
	ArrayList<Vertex> endVertices(Edge<S> e) {
		
		ArrayList<Vertex> list = new ArrayList<>();

		for (Edge<S> edge : edgesSet) {
			if (edge == e) {
				list.add(edge.edge.get(0));
				list.add(edge.edge.get(1));
				break;
			}
		}
		
		return list;
		
	}
	
	boolean areAdjacent(Vertex v, Vertex w) {

		for (Edge<S> edge : edgesSet)
			if ((edge.edge.get(0) == v && edge.edge.get(1) == w) || (edge.edge.get(0) == w && edge.edge.get(1) == v))
				return true;
		
		return false;
		
	}
	
	Graph<S> insertVertex(Vertex v) {

		for (Vertex vertex : verticesSet)
			if (vertex == v)
				return this;
		
		verticesSet.add(v);
		return this;
		
	}
	
	Graph<S> removeVertex(Vertex v) {
		
		verticesSet.remove(v);
		
		for (int i = 0; i < edgesSet.size(); i++)
			if (edgesSet.get(i).edge.get(0) == v || edgesSet.get(i).edge.get(1) == v)
				edgesSet.remove(i);
		
		return this;
		
	}
	
	Graph<S> insertEdge(Vertex v, Vertex w, S element) {
		
		insertVertex(v);
		insertVertex(w);

		for (Edge<S> edge : edgesSet)
			if ((edge.edge.get(0) == v && edge.edge.get(1) == w) || (edge.edge.get(0) == w && edge.edge.get(1) == v))
				return this;
		
		ArrayList<Vertex> edge = new ArrayList<>();
		edge.add(v);
		edge.add(w);
		
		Edge<S> newEdge = new Edge<>(edge, element);
		
		edgesSet.add(newEdge);
		
		return this;
		
	}
	
	Graph<S> removeEdge(Vertex v, Vertex w) {
		
		for (int i = 0; i < edgesSet.size(); i++)
			if ((edgesSet.get(i).edge.get(0) == v && edgesSet.get(i).edge.get(1) == w) || (edgesSet.get(i).edge.get(0) == w && edgesSet.get(i).edge.get(1) == v)) {
				edgesSet.remove(i);
				return this;
			}
		
		return this;
		
	}
	
	S getEdgeElem(Edge<S> e) throws Exception {

		for (Edge<S> edge : edgesSet)
			if (edge == e)
				return edge.element;
		
		throw new Exception("Edge does not exist");
				
	}
	
	Graph<S> replaceEdgeElem(Edge<S> e, S element) {

		for (Edge<S> edge : edgesSet) {
			if (edge == e) {
				edge.element = element;
				return this;
			}

		}
		
		return this;
				
	}

}
