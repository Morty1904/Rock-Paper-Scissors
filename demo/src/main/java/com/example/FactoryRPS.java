package com.example;

import java.util.Random;
import java.util.Scanner;

public class FactoryRPS {
    public static void main(String[] args) {
        MoveFactory factory = new MoveFactory();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your move: (1) Rock, (2) Paper, (3) Scissors, (4) Lizard, (5) Spock");
        int playerChoice = scanner.nextInt();
        Move playerMove = factory.createMove(playerChoice);
        Move machineMove = factory.createMove(random.nextInt(5) + 1);

        System.out.println("You: " + playerMove.getName() + " | Machine: " + machineMove.getName());
        if (playerMove.beats(machineMove)) System.out.println("You win!");
        else if (machineMove.beats(playerMove)) System.out.println("Machine wins!");
        else System.out.println("It's a tie!");

        scanner.close();
    }
}

class MoveFactory {
    public Move createMove(int choice) {
        if (choice == 1) {
            return new Rock();
        } else if (choice == 2) {
            return new Paper();
        } else if (choice == 3) {
            return new Scissors();
        } else if (choice == 4) {
            return new Lizard();
        } else if (choice == 5) {
            return new Spock();
        } else {
            throw new IllegalArgumentException("Invalid move choice");
        }
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