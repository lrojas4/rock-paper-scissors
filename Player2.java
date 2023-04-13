import java.util.Scanner;
public class Player2 extends Player {
    Scanner in = new Scanner(System.in);

    public void selectPlayerName() {
        System.out.println("Player 2: Enter your name: ");
        String name = in.nextLine();
        setPlayerName(name);
    }
    public void selectPlayerMove() {
        System.out.println("enter your move: rock, paper, or scissors");
        String myMove = in.nextLine();
        setPlayerMove(myMove);
    }
}
