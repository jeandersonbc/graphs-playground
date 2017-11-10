package com.example.graphsplayground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.example.graphsplayground.model.Graph;

public class AppTest {

	@Test
	public void testGraphLoading() {
		checkBadInput(null, IllegalArgumentException.class);
		checkBadInput("", FileNotFoundException.class);
		checkBadInput("asdasd/asdasd", FileNotFoundException.class);

		Graph<String> graph = null;
		try {
			graph = App.loadGraph("./data/digraph1.txt");
		} catch (FileNotFoundException e) {
			fail("File is supposed to exist.");
		}
		assertNotNull("Should not be null", graph);
		assertEquals("Expected number of vertices is 4", 4, graph.numVertices());
		assertEquals("Expected number of edges is 5", 5, graph.numEdges());
	}

	private void checkBadInput(String input, Class<?> class1) {
		try {
			App.loadGraph(input);
			fail("Should have throw an Exception with \"" + input + "\"");
		} catch (Exception ex) {
			assertEquals(class1.getName(), ex.getClass().getName());
		}
	}
}
