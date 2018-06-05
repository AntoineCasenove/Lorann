package model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LorannTest {
	
	@Test
	public void testMoveUp() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveUp();
		int expected = 0;
		assertEquals(expected,lorann.getY());
	}

	@Test
	public void testMoveDown() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveDown();
		int expected = 2;
		assertEquals(expected,lorann.getY());
	}

	@Test
	public void testMoveRight() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveRight();
		int expected = 2;
		assertEquals(expected,lorann.getX());
	}

	@Test
	public void testMoveLeft() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveLeft();
		int expected = 0;
		assertEquals(expected,lorann.getX());
	}

	@Test
	public void testMoveRightUp() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveRightUp();
		int expectedX = 2;
		int expectedY = 0;
		assertEquals(expectedX,lorann.getX());
		assertEquals(expectedY,lorann.getY());
	}

	@Test
	public void testMoveLeftUp() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveLeftUp();
		int expectedX = 0;
		int expectedY = 0;
		assertEquals(expectedX,lorann.getX());
		assertEquals(expectedY,lorann.getY());
	}

	@Test
	public void testMoveRightDown() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveRightDown();
		int expectedX = 2;
		int expectedY = 2;
		assertEquals(expectedX,lorann.getX());
		assertEquals(expectedY,lorann.getY());
	}

	@Test
	public void testMoveLeftDown() throws IOException {
		Lorann lorann = new Lorann("sprites/lorann_1.png");
		lorann.setPosition(1, 1);
		lorann.moveLeftDown();
		int expectedX = 0;
		int expectedY = 2;
		assertEquals(expectedX,lorann.getX());
		assertEquals(expectedY,lorann.getY());
	}
}
