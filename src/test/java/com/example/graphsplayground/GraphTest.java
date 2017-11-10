package com.example.graphsplayground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph<Integer> graph;

	@Before
	public void setUp() throws Exception {
		graph = new AdjacencyList<>();
	}

	@Test
	public void testVertexAddition() {
		assertTrue("Should not have vertices at this moment", graph.numVertices() == 0);

		int[] vertices = { 1, 2, 3, 4, 5 };
		for (int vertex : vertices) {
			int before = graph.numVertices();
			assertTrue(graph.addVertex(vertex));
			assertEquals(before + 1, graph.numVertices());
		}
		assertEquals(vertices.length, graph.numVertices());
		for (int vertex : vertices) {
			assertFalse("Should not allow duplicates", graph.addVertex(vertex));
		}
	}

	@Test
	public void testEdgeAddition() {
		assertTrue("Should not have edges at this moment", graph.numEdges() == 0);

		int[] vertices = { 1, 2, 3, 4, 5 };
		for (int vertex : vertices) {
			assertTrue(graph.addVertex(vertex));
		}

		int missingVertex = 123;
		try {
			this.graph.addEdge(new Edge<>(1, missingVertex));
			fail(String.format("Should have thrown a IllegalArgumentException because %d doesn't exist on this graph",
					missingVertex));
		} catch (IllegalArgumentException e) {
			// Do nothing...
		}

		List<Edge<Integer>> edges = Arrays.asList(new Edge<>(1, 2), new Edge<>(3, 4), new Edge<>(3, 5));
		for (Edge<Integer> e : edges) {
			int before = graph.numEdges();
			graph.addEdge(e);
			assertEquals(before + 1, graph.numEdges());
		}
	}

	@Test
	public void testNeighborhood() {
		int[] vertices = { 1, 2, 3, 4, 5 };
		for (int vertex : vertices) {
			assertTrue(graph.addVertex(vertex));
		}

		int vertex = 1;
		assertNotNull(this.graph.neighborsFrom(vertex));
		assertTrue(this.graph.neighborsFrom(vertex).isEmpty());

		int[] neighborhood = { 2, 3, 4 };
		for (int neighbor : neighborhood) {
			int before = this.graph.neighborsFrom(vertex).size();
			graph.addEdge(new Edge<>(vertex, neighbor));
			assertEquals(before + 1, this.graph.neighborsFrom(vertex).size());
		}

		List<Edge<Integer>> neighbors = this.graph.neighborsFrom(vertex);
		for (int pos = 0; pos < neighborhood.length; pos++) {
			assertTrue(neighbors.get(pos).getVertexB().equals(neighborhood[pos]));
		}

	}

}
