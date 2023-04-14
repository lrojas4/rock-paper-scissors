import java.util.Scanner;
public class Player1 extends Player {
    Scanner in = new Scanner(System.in);

    // Sets player 1 name
    public void selectPlayerName() {
        System.out.println("Player 1: Enter your name: ");
        String name = in.nextLine();
        setPlayerName(name);
    }

    // Sets player 1 move
    public void selectPlayerMove() {
        System.out.println("enter your move: rock, paper, or scissors");
        String myMove = in.nextLine();
        setPlayerMove(myMove);
    }

}

