import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static String playGame() {
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        Computer computer = new Computer();
        String game;
        String quitGame;

        // Welcome Message
        System.out.println("Welcome to Rock, Paper Scissors!");
        System.out.println("Enter two-player or computer");
        game = in.nextLine();
        System.out.println("You chose a " + game + " game.");

        // Ask for Names in a two player game
        if (game.equalsIgnoreCase("two-player")) {
            player1.selectPlayerName();
            player2.selectPlayerName();
            System.out.println("Hello " + player1.getName() + " and " + player2.getName() + "!");


            do {
                System.out.print(player1.getName() + " ");
                player1.selectPlayerMove();
                System.out.print(player2.getName() + " ");
                player2.selectPlayerMove();

                // Checks for  winner in a two-player game
                if (player1.getPlayerMove().equals(player2.getPlayerMove())) {
                    System.out.println("It's a tie");
                    scores.add(0);

                } else if (player1.getPlayerMove().equals("rock") && player2.getPlayerMove().equals("scissors") ||
                        (player1.getPlayerMove().equals("scissors") && player2.getPlayerMove().equals("paper")) ||
                        (player1.getPlayerMove().equals("paper") && player2.getPlayerMove().equals("rock"))) {
                    System.out.println(player1.getName() + " wins");
                    scores.add(1);

                } else {
                    System.out.println(player2.getName() + " wins");
                    scores.add(2);

                }

                int tie = 0;
                int player1Wins = 0;
                int player2Wins = 0;
                for(int i = 0; i < scores.size(); i++) {
                    if(scores.get(i) == 0) {
                        tie += 1;
                    } else if(scores.get(i) == 1) {
                        player1Wins +=1;
                    } else if(scores.get(i) == 2) {
                        player2Wins += 1;
                    }
                }
                System.out.println("Number of ties: " + tie + "\n" +
                        "Number of player 1 wins: "  + player1Wins + "\n" +
                        "Number of player 2 wins " + player2Wins);
                System.out.println("Continue playing? (Y = Yes, N = No)");
                quitGame = in.nextLine();

            } while(quitGame.toUpperCase().equals("Y"));
        } else {
            // Computer vs player game
            do {
                computer.selectPlayerMove();
                player1.selectPlayerName();
                System.out.print(player1.getName() + " ");
                player1.selectPlayerMove();
                System.out.println("Computers move is: " + computer.getPlayerMove());

                // Checks for  winner in player vs computer game
                if (player1.getPlayerMove().equals(computer.getPlayerMove())) {
                    System.out.println("It's a tie");
                    scores.add(0);

                } else if (player1.getPlayerMove().equals("rock") && computer.getPlayerMove().equals("scissors") ||
                        (player1.getPlayerMove().equals("scissors") && computer.getPlayerMove().equals("paper")) ||
                        (player1.getPlayerMove().equals("paper") && computer.getPlayerMove().equals("rock"))) {
                    System.out.println(player1.getName() + " wins");
                    scores.add(1);
                } else {
                    System.out.println("computer wins");
                    scores.add(2);
                }

                int tie = 0;
                int player1Wins = 0;
                int computerWins = 0;
                for(int i = 0; i < scores.size(); i++) {
                    if(scores.get(i) == 0) {
                        tie += 1;
                    } else if(scores.get(i) == 1) {
                        player1Wins +=1;
                    } else if(scores.get(i) == 2) {
                        computerWins += 1;
                    }
                }
                System.out.println("Number of ties: " + tie + "\n" +
                        "Number of player 1 wins: "  + player1Wins + "\n" +
                        "Number of Player2 wins " + computerWins);

                System.out.println("Continue playing? (Y = Yes, N = No)");
                quitGame = in.nextLine();
            } while (quitGame.toUpperCase().equals("Y"));
        }

        return "";
    }


    public static void main(String[] args) {
        playGame();
    }
}
