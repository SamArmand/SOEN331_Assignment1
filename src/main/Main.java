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

public class Main {

	public static void main(String[] args) {

		//Graph Specification
		System.out.println("*******************");
		System.out.println("Graph Specification");
		System.out.println("*******************");
		
		Graph<Element<String>> g;
		Vertex v = new Vertex();
		Vertex w = new Vertex();
		Vertex u = new Vertex();
		Element<String> elementX = new Element<>("x"); //Element
		Element<String> elementY = new Element<>("y");
		DirectedGraph<Element<String>> d;

		//Graph Axiom 1
		System.out.println("Graph Axiom 1: " + new Graph<Element<String>>().vertices().isEmpty());
		
		//Graph Axiom 2
		System.out.println("Graph Axiom 2: " + new Graph<Element<String>>().edges().isEmpty());
		
		//Graph Axiom 3
		System.out.println("Graph Axiom 3: " + (new Graph<Element<String>>().countAllVertices() == 0));
		
		//Graph Axiom 4
		System.out.println("Graph Axiom 4: " + (new Graph<Element<String>>().countAllEdges() == 0));
		
		//Graph Axiom 5
		System.out.println("Graph Axiom 5: " + (new Graph<Element<String>>().insertVertex(v).insertVertex(w).countAllVertices() == 2));
		
		//Graph Axiom 6
		System.out.println("Graph Axiom 6: " + (new Graph<Element<String>>().insertVertex(v).insertVertex(v).countAllVertices() == 1));
		
		//Graph Axiom 7
		System.out.println("Graph Axiom 7: " + (new Graph<Element<String>>().insertVertex(v).removeVertex(v).countAllVertices() == 0));
		
		//Graph Axiom 8
		System.out.println("Graph Axiom 8: " + (new Graph<Element<String>>().insertEdge(v, w, elementX).removeEdge(v, w).countAllEdges() == 0));
		
		//Graph Axiom 9
		g = new Graph<Element<String>>().insertEdge(v, w, elementX);
		try {
			System.out.println("Graph Axiom 9: " + (g.areAdjacent(v, w) == g.edges().contains(g.getEdge(v, w))));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 9: false :: Exception: " + e.getMessage());
		}
		
		//Graph Axiom 10
		g = new Graph<Element<String>>().insertEdge(v, w, elementX).insertEdge(w, u, elementY);
		ArrayList<Edge<Element<String>>> incidentEdges = g.incidentEdges(w);
		
		ArrayList<Edge<Element<String>>> testIncidentEdges = new ArrayList<>();
		try {
			testIncidentEdges.add(g.getEdge(v, w));
			testIncidentEdges.add(g.getEdge(w, u));
			System.out.println("Graph Axiom 10: " + incidentEdges.equals(testIncidentEdges));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 10: false :: Exception: " + e.getMessage());
		}
		
		//Graph Axiom 11
		g = new Graph<Element<String>>().insertEdge(v, w, elementX).insertEdge(w, u, elementY);
		try {
			System.out.println("Graph Axiom 11: " + (g.opposite(v, g.getEdge(v, w)) == w));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 11: false :: Exception: " + e.getMessage());
		}
		
		//Graph Axiom 12
		g = new Graph<Element<String>>().insertEdge(v, w, elementX);
		ArrayList<Vertex> testEndVertices = new ArrayList<>();
		testEndVertices.add(v);
		testEndVertices.add(w);
		try {
			System.out.println("Graph Axiom 12: " + g.endVertices(g.getEdge(v, w)).equals(testEndVertices));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 11: false :: Exception: " + e.getMessage());
		}
		
		//Graph Axiom 13
		g = new Graph<Element<String>>().insertEdge(v, w, elementX);
		try {
			System.out.println("Graph Axiom 13: " + (g.getEdgeElem(g.getEdge(v, w)) == elementX));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 13: false :: Exception: " + e.getMessage());
		}
		
		//Graph Axiom 14
		g = new Graph<Element<String>>().insertEdge(v, w, elementX);
		try {
			System.out.println("Graph Axiom 14: " + (g.replaceEdgeElem(g.getEdge(v, w), elementY).getEdgeElem(g.getEdge(v, w)) == elementY));
		}
		catch (Exception e) {
			System.out.println("Graph Axiom 14: false :: Exception: " + e.getMessage());
		}
		
		//Directed Graph Specification
		System.out.println("****************************");
		System.out.println("Directed Graph Specification");
		System.out.println("****************************");
		
		//Directed Graph Axiom 1
		System.out.println("Directed Graph Axiom 1: " + new DirectedGraph<Element<String>>().vertices().isEmpty());
		
		//Directed Graph Axiom 2
		System.out.println("Directed Graph Axiom 2: " + new DirectedGraph<Element<String>>().edges().isEmpty());
		
		//Directed Graph Axiom 3
		System.out.println("Directed Graph Axiom 3: " + (new DirectedGraph<Element<String>>().countAllVertices() == 0));
		
		//Directed Graph Axiom 4
		System.out.println("Directed Graph Axiom 4: " + (new DirectedGraph<Element<String>>().countAllEdges() == 0));
		
		//Directed Graph Axiom 5
		d = new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(w, v, elementY);
		ArrayList<Edge<Element<String>>> testIncomingEdges = new ArrayList<>();
		try {
			testIncomingEdges.add(d.getDirectedEdge(w, v));
			System.out.println("Directed Graph Axiom 5: " + d.incomingEdgesOf(v).equals(testIncomingEdges));
		}
		catch (Exception e) {
			System.out.println("Directed Graph Axiom 5: false :: Exception: " + e.getMessage());
		}
		
		//Directed Graph Axiom 6
		System.out.println("Directed Graph Axiom 6: " + (new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(w, v, elementY).inDegreeOf(v) == 1));
		
		//Directed Graph Axiom 7
		System.out.println("Directed Graph Axiom 7: " + (new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(w, v, elementY).outDegreeOf(v) == 1));
		
		//Directed Graph Axiom 8
		d = new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(w, v, elementY);
		ArrayList<Edge<Element<String>>> testOutgoingEdges = new ArrayList<>();
		try {
			testOutgoingEdges.add(d.getDirectedEdge(v, w));
			System.out.println("Directed Graph Axiom 8: " + d.outgoingEdgesOf(v).equals(testOutgoingEdges));
		}
		catch (Exception e) {
			System.out.println("Directed Graph Axiom 8: false :: Exception: " + e.getMessage());
		}
		
		//Directed Graph Axiom 9
		System.out.println("Directed Graph Axiom 9: " + (new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(u, w, elementY).inDegreeOf(w) == 2));
	
		//Directed Graph Axiom 10
		System.out.println("Directed Graph Axiom 10: " + (new DirectedGraph<Element<String>>().insertDirectedEdge(v, w, elementX).insertDirectedEdge(u, w, elementY).outDegreeOf(v) == 1));
				
	}

}
