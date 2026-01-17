import java.util.ArrayList;

public class Player extends Character {
    //creates variables
    private int playerHealth;
    private int row;
    private int col;
    private ArrayList<Item> playerInventory;

    //paramaterized and unparameterized constructors
    public Player(String characterName, int playerHealth, int row, int col) {
        super(characterName);
        this.playerHealth = playerHealth;
        this.row = row;
        this.col = col;
        this.playerInventory = new ArrayList<>();
    }

    public Player(){
        this("new player", 1, 2, 2);
    }

    //getters
    public int getPlayerHealth(){
        return playerHealth;
    }

    public int getRow() { 
        return row; 
    }

    public int getCol() { 
        return col; 
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    //setters
    public void setPlayerHealth(int playerHealth){
        this.playerHealth = playerHealth;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setInventory(ArrayList<Item> playerInventory){
        this.playerInventory = playerInventory;
    }

    //used for the move command to change position on 2d array based on direction
    public void move(String direction) {
        if (direction.equals("north")) row--;
        else if (direction.equals("south")) row++;
        else if (direction.equals("east")) col++;
        else if (direction.equals("west")) col--;
    }

    // sets the position on the 2d array
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //adds an item to player inventory
    public void addItem(Item item) {
        playerInventory.add(item);
    }

    //shows the inventory of the player
    public void showInventory() {
        if (playerInventory.isEmpty()) {
            System.out.println("inventory is empty");
        } else {
            System.out.println("inventory: " + playerInventory);
        }
    }

    //used for the use item command and deals with both food items and adding or losing health and win condition of using the key at the bookstore
    public boolean useItem(String itemName, Location current) {
        
        for (Item i : playerInventory) {
            if (i.getItemName().equalsIgnoreCase(itemName)) {
                if (i instanceof Food) {
                    Food food = (Food) i;

                    if (food.getIsAllergic()) {
                        System.out.println("you eat the food and have an allergic reaction nerd");
                        playerHealth -= 25;
                        System.out.println("you lose 25 health");
                    } else {
                        System.out.println("you eat the food delicious");
                        playerHealth += 5;
                        System.out.println("you gain 5 health");
                    }

                    playerInventory.remove(i);
                    return false;
                }

                if (i instanceof KeyItem) {
                    KeyItem key = (KeyItem) i;

                    if (current.getLocationName().equals(key.getIsUseable().getLocationName())) {
                        System.out.println("\nyou unlock the door with the golden key");
                        System.out.println("WINNER WINNER CHICKEN DINNER");
                        return true; 
                    } else {
                        System.out.println("you cant use the key here");
                        return false;
                    }
                }

                System.out.println("that item cant be used");
                return false;
            }
        }

        System.out.println("you dont have that item");
        return false;
    }
}