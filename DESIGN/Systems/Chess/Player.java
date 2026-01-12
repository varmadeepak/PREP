
public class Player {
    private String id;
    private String name;
    private boolean isCurrentPlayer;
    private boolean isHuman;

    Player(String id,String name) {
        this.id = id;
        this.name = name;
    }
    public void setCurrentPlayer() {
        isCurrentPlayer = true;
    }
    public void setHuman() {
        isHuman = true;
    }
    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }
    public boolean isHuman() {
        return isHuman;
    }
}
