import java.util.ArrayList;

public class Character {
    private String characterName;
    private int characterHealth;
    private ArrayList<Item> characterInventory;

    public Character(String characterName, int characterHealth) {
        this.characterName = characterName;
        this.characterHealth = characterHealth;
        this.characterInventory = new ArrayList<>();
    }

    public Character(){
        this("null", 1);
    }

    public String getCharacterName() { 
        return characterName; 
    }

    public int getCharacterHealth() { 
        return characterHealth; 
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    public void setCharacterHealth(int characterHealth) {
        this.characterHealth = characterHealth;
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
