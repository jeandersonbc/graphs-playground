package com.example.graphsplayground;

import static org.junit.Assert.fail;

import org.junit.Test;

public class AppTest {

	@Test
	public void testGraphLoading() {
		String[] invalidPaths = new String[] { null, "", "asdasd/asdasd" };
		for (String badPath : invalidPaths) {
			try {
				App.loadGraph(badPath);
				fail("Should have throw a RuntimeException with \"" + badPath + "\"");
			} catch (IllegalArgumentException ex) {
				// Do nothing....
			}
		}
		App.loadGraph("./data/digraph1.txt");
		fail("To implement...");
	}
}
