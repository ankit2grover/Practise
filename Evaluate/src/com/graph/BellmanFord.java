package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BellmanFord {

	HashMap<String, Vertex> vertexList = new HashMap<String, Vertex>();
	HashMap<String, Integer> vertexWeightsMap = new HashMap<String, Integer>();
	public void createGraph() {
		
		// A vertex
		Vertex vertex = new Vertex();
		vertex.data = "A";
		vertex.edge = new LinkedList<Edge>();
		
		Edge edge = new Edge();
		edge.data = "B";
		edge.weight = 8;
		vertex.edge.add(edge);
		
		edge = new Edge();
		edge.data = "E";
		edge.weight = 6;
		vertex.edge.add(edge);
		this.vertexList.put("A", vertex);
		
		// Vertex B
		vertex = new Vertex();
		vertex.data = "B";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "C";
		edge.weight = 6;
		vertex.edge.add(edge);
		this.vertexList.put("B", vertex);
		
		// Vertex C
		vertex = new Vertex();
		vertex.data = "C";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "H";
		edge.weight = 4;
		vertex.edge.add(edge);
		this.vertexList.put("C", vertex);
		
		// Vertex D
		vertex = new Vertex();
		vertex.data = "D";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "B";
		edge.weight = 2;
		vertex.edge.add(edge);
		this.vertexList.put("D", vertex);
		
		// Vertex E
		vertex = new Vertex();
		vertex.data = "E";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "F";
		edge.weight = 3;
		vertex.edge.add(edge);
		
		edge = new Edge();
		edge.data = "G";
		edge.weight = 2;
		vertex.edge.add(edge);
		this.vertexList.put("E", vertex);
		
		// Vertex F
		vertex = new Vertex();
		vertex.data = "F";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "G";
		edge.weight = 6;
		vertex.edge.add(edge);
		this.vertexList.put("F", vertex);
		
		// Vertex G
		vertex = new Vertex();
		vertex.data = "G";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "D";
		edge.weight = 1;
		vertex.edge.add(edge);
		
		edge = new Edge();
		edge.data = "C";
		edge.weight = -1;
		vertex.edge.add(edge);
		this.vertexList.put("G", vertex);
		
		// Vertex H
		vertex = new Vertex();
		vertex.data = "H";
		vertex.edge = new LinkedList<Edge>();
		
		edge = new Edge();
		edge.data = "G";
		edge.weight = -2;
		vertex.edge.add(edge);
		this.vertexList.put("H", vertex);
		
		//System.out.println("Vertex")
		
	}
	
	public void bellmanFord() {
		int index = 0;
		while (index < this.vertexList.size() -1) {
			List<String> unvisitedVertices = new ArrayList<String>();
			List<String> visitedVertices = new ArrayList<String>();
			
			Iterator<String> iterator = this.vertexList.keySet().iterator();
			while (iterator.hasNext()) {
				unvisitedVertices.add(iterator.next());
			}
			
			vertexWeightsMap.put("A", 0);
			
			
			Stack<String> stack = new Stack<String>();
			int weightFromSource = 0;
			String currVertex = "A";
			stack.push(currVertex);
		
			while (!stack.isEmpty()) {
				currVertex = stack.pop();
				if (!visitedVertices.contains(currVertex)) {
					if (vertexWeightsMap.containsKey(currVertex)) {
						weightFromSource = vertexWeightsMap.get(currVertex);
					} else {
						weightFromSource = 0;
					}
					for (Edge edge : this.vertexList.get(currVertex).edge) {
						String data = edge.data;
						int weight = edge.weight;
						weight = weight + weightFromSource;
						int currVertexWeight = 1000;
						if (vertexWeightsMap.containsKey(data)) {
							currVertexWeight = vertexWeightsMap.get(data);
						}
						int minWeight = Math.min(currVertexWeight , weight);
						vertexWeightsMap.put(edge.data, minWeight);
						if (!stack.contains(edge.data) && !visitedVertices.contains(edge.data)) {
							stack.push(edge.data);
						}
					}
					visitedVertices.add(currVertex);
					unvisitedVertices.remove(currVertex);
					//currVertex = stack.pop();
				}
				
			}
		++index;
		}
	}
	
	public static void main(String[] args) {
		BellmanFord bellmanFord = new BellmanFord();
		bellmanFord.createGraph();
		bellmanFord.bellmanFord();
		System.out.println("Vertices weight after 1st iteration");
		Iterator<String> keySet = bellmanFord.vertexWeightsMap.keySet().iterator();
		while (keySet.hasNext()) {
			String key = keySet.next();
			int value = bellmanFord.vertexWeightsMap.get(key);
			System.out.println("Key = " + key + " Value = " + value);
		}
	}
}
