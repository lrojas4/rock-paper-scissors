
public class Computer extends Player {
    public void selectPlayerName() {
        setPlayerName("Computer");
    }

    // Assigns a computer move based on the random number
    public void selectPlayerMove() {
        int computer = (int)(Math.random() * 3);
        if (computer == 0) {
            setPlayerMove("rock");
        } else if(computer == 1) {
            setPlayerMove("paper");
        } else if(computer == 2) {
            setPlayerMove("scissors");
        } else {
            System.out.println("Not a valid move");
        }
    }

}
