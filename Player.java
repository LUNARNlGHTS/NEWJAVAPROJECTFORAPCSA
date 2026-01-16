import java.util.ArrayList;

public class Player extends Character {
    private int row;
    private int col;
    private ArrayList<Item> characterInventory;

    public Player(String characterName, int characterHealth, int row, int col) {
        super(characterName, characterHealth);
        this.row = row;
        this.col = col;
    }

    public int getRow() { 
        return row; 
    }
    public int getCol() { 
        return col; 
    }

    public void move(String direction) {
        if (direction.equals("north")) row--;
        else if (direction.equals("south")) row++;
        else if (direction.equals("east")) col++;
        else if (direction.equals("west")) col--;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public ArrayList<Item> getInventory() {
        return characterInventory;
    }

    public void addItem(Item item) {
        characterInventory.add(item);
    }

    public void showInventory() {
        if (characterInventory.isEmpty()) {
            System.out.println("inventory is empty");
        } else {
            System.out.println("inventory: " + characterInventory);
        }
    }
}