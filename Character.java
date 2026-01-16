import java.util.ArrayList;

public class Character {
    private String name;
    private int health;
    private ArrayList<Item> inventory;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getHealth() { return health; }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory: " + inventory);
        }
    }
}
