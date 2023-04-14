import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Checks for winner and displays ties and wins
    public static void displayScores(ArrayList<Integer> arr){
        int tie = 0;
        int player1Wins = 0;
        int player2Wins = 0;
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) == 0) {
                tie += 1;
            } else if(arr.get(i) == 1) {
                player1Wins +=1;
            } else if(arr.get(i) == 2) {
                player2Wins += 1;
            }
        }
        if (arr.get(0) == 4) {
            System.out.println("Number of ties: " + tie + "\n" +
                    "Number of player 1 wins: " + player1Wins + "\n" +
                    "Number of Computer wins " + player2Wins);
        }else if(arr.get(0) == 5){
            System.out.println("Number of ties: " + tie + "\n" +
                    "Number of player 1 wins: " + player1Wins + "\n" +
                    "Number of Player2 wins " + player2Wins);
        }
    }

    // Computer vs player game
    public static void playComputer() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(4);

        Global.computer.selectPlayerMove();
        System.out.print(Global.player1.getName() + " ");
        Global.player1.selectPlayerMove();

        // Verify if move is Valid
        if (!Global.player1.getPlayerMove().equalsIgnoreCase("rock") &&
                !Global.player1.getPlayerMove().equalsIgnoreCase("paper") &&
                !Global.player1.getPlayerMove().equalsIgnoreCase("scissors")) {
            System.out.println("Not a valid move");
            System.out.print(Global.player1.getName() + " ");
            Global.player1.selectPlayerMove();
        }

        System.out.println("Computers move is: " + Global.computer.getPlayerMove());

        // Checks for  winner in player vs computer game
        if (Global.player1.getPlayerMove().equals(Global.computer.getPlayerMove())) {
            System.out.println("It's a tie");
            scores.add(0);

        } else if (Global.player1.getPlayerMove().equals("rock") && Global.computer.getPlayerMove().equals("scissors") ||
                (Global.player1.getPlayerMove().equals("scissors") && Global.computer.getPlayerMove().equals("paper")) ||
                (Global.player1.getPlayerMove().equals("paper") && Global.computer.getPlayerMove().equals("rock"))) {
            System.out.println(Global.player1.getName() + " wins");
            scores.add(1);
        } else {
            System.out.println("computer wins");
            scores.add(2);
        }
        displayScores(scores);
    }

    public static void playPlayer() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(5);

        System.out.print(Global.player1.getName() + " ");
        Global.player1.selectPlayerMove();

        // Verify if player 1 move is valid
        if (!Global.player1.getPlayerMove().equalsIgnoreCase("rock") &&
                !Global.player1.getPlayerMove().equalsIgnoreCase("paper") &&
                !Global.player1.getPlayerMove().equalsIgnoreCase("scissors")) {
            System.out.println("Not a valid move");
            System.out.print(Global.player1.getName() + " ");
            Global.player1.selectPlayerMove();
        }

        System.out.print(Global.player2.getName() + " ");
        Global.player2.selectPlayerMove();

        // Verify if move is Valid
        if (!Global.player2.getPlayerMove().equalsIgnoreCase("rock") &&
                !Global.player2.getPlayerMove().equalsIgnoreCase("paper") &&
                !Global.player2.getPlayerMove().equalsIgnoreCase("scissors")) {
            System.out.println("Not a valid move");
            System.out.print(Global.player2.getName() + " ");
            Global.player2.selectPlayerMove();
        }

        // Checks for  winner in a two-player game
        if (Global.player1.getPlayerMove().equals(Global.player2.getPlayerMove())) {
            System.out.println("It's a tie");
            scores.add(0);

        } else if (Global.player1.getPlayerMove().equals("rock") && Global.player2.getPlayerMove().equals("scissors") ||
                (Global.player1.getPlayerMove().equals("scissors") && Global.player2.getPlayerMove().equals("paper")) ||
                (Global.player1.getPlayerMove().equals("paper") && Global.player2.getPlayerMove().equals("rock"))) {
            System.out.println(Global.player1.getName() + " wins");
            scores.add(1);
        } else {
            System.out.println(Global.player2.getName() + " wins");
            scores.add(2);
        }
        displayScores(scores);
    }

    // Play game
    public static void playGame() {
        int k = 0;
        do{
            if (k > 0){
                // Welcome Message
                System.out.println("Enter two-player or computer to change game modes");
                Global.game = Global.in.nextLine();
                System.out.println("You chose a " + Global.game + " game.");
            }else{
                System.out.println("Welcome to Rock, Paper Scissors!");
                System.out.println("Enter two-player or computer");
                Global.game = Global.in.nextLine();
                System.out.println("You chose a " + Global.game + " game.");
            }

            if (Global.game.equalsIgnoreCase("two-player")) {
                Global.player1.selectPlayerName();
                Global.player2.selectPlayerName();
                System.out.println("Hello " + Global.player1.getName() + " and " + Global.player2.getName() + "!");
            } else {
                Global.player1.selectPlayerName();
            }
            // Determines if the game is two player or vs the computer
            do {
                if (Global.game.equalsIgnoreCase("two-player")) {
                    playPlayer();
                } else {
                    // Computer vs player game
                    playComputer();
                }
                System.out.println("Continue playing? (Y = Yes, N = No, S = Switch mode)");
                Global.quitGame = Global.in.nextLine();
            } while (Global.quitGame.toUpperCase().equals("Y"));
            k += 1;
        } while (Global.quitGame.toUpperCase().equals("S"));

    }
    public static void main(String[] args) {
        playGame();
    }
}