package com.example;

import java.util.Random;
import java.util.Scanner;

public class SheldonRPS {
    public static void main(String[] args) {
        Move[] moves = {new Rock(), new Paper(), new Scissors(), new Lizard(), new Spock()};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your move: (1) Rock, (2) Paper, (3) Scissors, (4) Lizard, (5) Spock");
        int playerChoice = scanner.nextInt() - 1;
        Move playerMove = moves[playerChoice];
        Move machineMove = moves[random.nextInt(5)];

        System.out.println("You: " + playerMove.getName() + " | Machine: " + machineMove.getName());
        if (playerMove.beats(machineMove)) System.out.println("You win!");
        else if (machineMove.beats(playerMove)) System.out.println("Machine wins!");
        else System.out.println("It's a tie!");

        scanner.close();
    }
}

abstract class Move {
    public abstract String getName();
    public abstract boolean beats(Move other);
}

class Rock extends Move {
    public String getName() { return "Rock"; }
    public boolean beats(Move other) {
        return other instanceof Scissors || other instanceof Lizard;
    }
}

class Paper extends Move {
    public String getName() { return "Paper"; }
    public boolean beats(Move other) {
        return other instanceof Rock || other instanceof Spock;
    }
}

class Scissors extends Move {
    public String getName() { return "Scissors"; }
    public boolean beats(Move other) {
        return other instanceof Paper || other instanceof Lizard;
    }
}

class Lizard extends Move {
    public String getName() { return "Lizard"; }
    public boolean beats(Move other) {
        return other instanceof Spock || other instanceof Paper;
    }
}

class Spock extends Move {
    public String getName() { return "Spock"; }
    public boolean beats(Move other) {
        return other instanceof Scissors || other instanceof Rock;
    }
}