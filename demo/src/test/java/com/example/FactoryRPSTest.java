package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryRPSTest {

    private final MoveFactory factory = new MoveFactory();

    @Test
    public void testCreateRock() {
        Move move = factory.createMove(1);
        assertNotNull(move);
        assertEquals("Rock", move.getName());
    }

    @Test
    public void testCreatePaper() {
        Move move = factory.createMove(2);
        assertNotNull(move);
        assertEquals("Paper", move.getName());
    }

    @Test
    public void testCreateScissors() {
        Move move = factory.createMove(3);
        assertNotNull(move);
        assertEquals("Scissors", move.getName());
    }

    @Test
    public void testCreateLizard() {
        Move move = factory.createMove(4);
        assertNotNull(move);
        assertEquals("Lizard", move.getName());
    }

    @Test
    public void testCreateSpock() {
        Move move = factory.createMove(5);
        assertNotNull(move);
        assertEquals("Spock", move.getName());
    }

    @Test
    public void testRockBeatsScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        assertTrue(rock.beats(scissors));
        assertFalse(scissors.beats(rock));
    }

    @Test
    public void testPaperBeatsRock() {
        Move paper = new Paper();
        Move rock = new Rock();
        assertTrue(paper.beats(rock));
        assertFalse(rock.beats(paper));
    }

    @Test
    public void testScissorsBeatsPaper() {
        Move scissors = new Scissors();
        Move paper = new Paper();
        assertTrue(scissors.beats(paper));
        assertFalse(paper.beats(scissors));
    }

    @Test
    public void testLizardBeatsSpock() {
        Move lizard = new Lizard();
        Move spock = new Spock();
        assertTrue(lizard.beats(spock));
        assertFalse(spock.beats(lizard));
    }

    @Test
    public void testSpockBeatsScissors() {
        Move spock = new Spock();
        Move scissors = new Scissors();
        assertTrue(spock.beats(scissors));
        assertFalse(scissors.beats(spock));
    }

    @Test
    public void testTie() {
        Move rock1 = new Rock();
        Move rock2 = new Rock();
        assertFalse(rock1.beats(rock2));
        assertFalse(rock2.beats(rock1));
    }

    @Test
    public void testInvalidChoice() {
        assertThrows(IllegalArgumentException.class, () -> factory.createMove(6));
    }
}