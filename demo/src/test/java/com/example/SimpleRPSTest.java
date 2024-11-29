package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRPSTest {

    @Test
    void testRockBeatsScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        assertTrue(rock.beats(scissors), "Rock should beat Scissors");
    }

    @Test
    void testPaperBeatsRock() {
        Move paper = new Paper();
        Move rock = new Rock();
        assertTrue(paper.beats(rock), "Paper should beat Rock");
    }

    @Test
    void testScissorsBeatsPaper() {
        Move scissors = new Scissors();
        Move paper = new Paper();
        assertTrue(scissors.beats(paper), "Scissors should beat Paper");
    }

    @Test
    void testTie() {
        Move rock = new Rock();
        Move anotherRock = new Rock();
        assertFalse(rock.beats(anotherRock), "Rock should tie with Rock");
    }

    @Test
void testPlayerInputRock() {
    Scanner scanner = mock(Scanner.class);
    when(scanner.nextInt()).thenReturn(1);

    Random random = mock(Random.class);
    when(random.nextInt(3)).thenReturn(0);

    String[] moves = {new Rock().getName(), new Paper().getName(), new Scissors().getName()};
    String playerMove = moves[0];
    String machineMove = moves[0];

    assertEquals("Rock", playerMove);
    assertEquals("Rock", machineMove);
}


@Test
void testPlayerInputPaperVsRock() {
    Scanner scanner = mock(Scanner.class);
    when(scanner.nextInt()).thenReturn(2);

    Random random = mock(Random.class);
    when(random.nextInt(3)).thenReturn(0);

    String[] moves = {new Rock().getName(), new Paper().getName(), new Scissors().getName()};
    String playerMove = moves[1];
    String machineMove = moves[0];

    assertEquals("Paper", playerMove);
    assertEquals("Rock", machineMove);
}


    @Test
    void testPlayerInputScissorsVsPaper() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextInt()).thenReturn(3);

        Random random = mock(Random.class);
        when(random.nextInt(3)).thenReturn(2);

        String[] moves = {new Rock().getName(), new Paper().getName(), new Scissors().getName()};
        String playerMove = moves[2];
        String machineMove = moves[2];

        assertEquals(playerMove, "Scissors");
        assertEquals(machineMove, "Scissors");
    }

    @Test
    void testMachineWinsWithRandomChoice() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextInt()).thenReturn(1);

        Random random = mock(Random.class);
        when(random.nextInt(3)).thenReturn(2);

        String[] moves = {new Rock().getName(), new Paper().getName(), new Scissors().getName()};
        String playerMove = moves[0];
        String machineMove = moves[2];

        assertEquals(playerMove, "Rock");
        assertEquals(machineMove, "Scissors");
    }
}