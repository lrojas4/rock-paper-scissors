import java.util.Scanner;

public class Main {

    public static String playGame() {
        Scanner in = new Scanner(System.in);
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        Computer computer = new Computer();
        String game;
        boolean gameOver = false;

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


            while (!gameOver) {
                System.out.print(player1.getName() + " ");
                player1.selectPlayerMove();
                System.out.print(player2.getName() + " ");
                player2.selectPlayerMove();

                // Checks for  winner in a two-player game
                if (player1.getPlayerMove().equals(player2.getPlayerMove())) {
                    System.out.println("It's a tie");

                } else if (player1.getPlayerMove().equals("rock") && player2.getPlayerMove().equals("scissors") ||
                        (player1.getPlayerMove().equals("scissors") && player2.getPlayerMove().equals("paper")) ||
                        (player1.getPlayerMove().equals("paper") && player2.getPlayerMove().equals("rock"))) {
                    System.out.println(player1.getName() + " wins");
                } else {
                    System.out.println(player2.getName() + " wins");
                }
                gameOver = true;
            }
        } else {
            // Player plays against the computer
            computer.selectPlayerMove();
            player1.selectPlayerName();
            System.out.print(player1.getName() + " ");
            player1.selectPlayerMove();
            System.out.println("Computers move is: " + computer.getPlayerMove());

            // Checks for  winner in player vs computer game
            if (player1.getPlayerMove().equals(computer.getPlayerMove())) {
                System.out.println("It's a tie");

            } else if (player1.getPlayerMove().equals("rock") && computer.getPlayerMove().equals("scissors") ||
                    (player1.getPlayerMove().equals("scissors") && computer.getPlayerMove().equals("paper")) ||
                    (player1.getPlayerMove().equals("paper") && computer.getPlayerMove().equals("rock"))) {
                System.out.println(player1.getName() + " wins");
            } else {
                System.out.println("computer wins");
            }
        }

        gameOver = true;
        return "";
    }

    public static void main(String[] args) {
        playGame();
    }
}
