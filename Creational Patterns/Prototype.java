
class Player implements Cloneable {

    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }
}

class PlayerFactory {

    Player prototypeChar;

    public PlayerFactory() {
        this.prototypeChar = new Player();
    }

    public Player createPlayer() throws CloneNotSupportedException {
        Player clonedPlayer = (Player) prototypeChar.clone();
        return clonedPlayer;
    }

}

class Prototype {

    public static void main(String[] jayesh) {
        PlayerFactory playerFactory = new PlayerFactory();
        try {
            System.out.println(playerFactory.createPlayer());
        } catch (Exception e) {
        }
    }
}
