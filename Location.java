import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private NonPlayerCharacter npc;

    public Location() {
        this("empty street", "merely a quiet street");
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npc = null;
    }

    public String getName() {
        return name; }

    public String getDescription() { 
        return description; }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        for (Item i : items) {
            if (i.getItemName().equalsIgnoreCase(itemName)) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setNPC(NonPlayerCharacter npc) {
        this.npc = npc;
    }

    public NonPlayerCharacter getNPC() {
        return npc;
    }

    
    public String toString() {
        String itemText = items.isEmpty() ? "nothing interesting here" : "Items: " + items;
        String npcText = (npc == null) ? "" : "\nsomeone is present" + npc.getCharacterName();
        return name + "\n" + description + "\n" + itemText + npcText;
    }
}