import java.util.Scanner;
public class Player2 extends Player {
    Scanner in = new Scanner(System.in);

    // Sets player 2 name
    public void selectPlayerName() {
        System.out.println("Player 2: Enter your name: ");
        String name = in.nextLine();
        setPlayerName(name);
    }

    // Sets player 2 move
    public void selectPlayerMove() {
        System.out.println("enter your move: rock, paper, or scissors");
        String myMove = in.nextLine();
        setPlayerMove(myMove);
    }
}
