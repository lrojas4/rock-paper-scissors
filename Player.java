public abstract class Player {
    private String name;
    private String playerMove;


    public void setPlayerName(String name) {
        this.name = name;
    }
    public abstract void selectPlayerName();

    // Gets player name
    public String getName() {
        return name;
    }

    // Set player's name
    public void setName(String name) {
        this.name = name;
    }

    // Get player move
    public String getPlayerMove() {
        return playerMove;
    }

    // Set Player move
    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }
    public abstract void selectPlayerMove();
}









