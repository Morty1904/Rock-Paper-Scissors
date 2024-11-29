package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Random;

public class SimpleRPSTest {

    @Test
    void testMainRockVsScissors() {
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 2;
            }
        };
        SimpleRPS.main(new String[0]);
        String output = outputStream.toString();
        assertTrue(output.contains("You: Rock"));
        assertTrue(output.contains("Machine: Scissors"));
        assertTrue(output.contains("You win!"));
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainPaperVsRock() {
        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 0;
            }
        };
        SimpleRPS.main(new String[0]);
        String output = outputStream.toString();
        assertTrue(output.contains("You: Paper"));
        assertTrue(output.contains("Machine: Rock"));
        assertTrue(output.contains("You win!"));
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainScissorsVsPaper() {
        String simulatedInput = "3\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 1;
            }
        };
        SimpleRPS.main(new String[0]);
        String output = outputStream.toString();
        assertTrue(output.contains("You: Scissors"));
        assertTrue(output.contains("Machine: Paper"));
        assertTrue(output.contains("You win!"));
        System.setIn(System.in);
        System.setOut(System.out);
    }
}