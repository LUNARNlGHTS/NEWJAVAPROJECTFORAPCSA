import java.util.ArrayList;

public class Location {
    private String locationName;
    private String locationDescription;
    private ArrayList<Item> items;
    private NonPlayerCharacter npc;

    public Location(String locationName, String locationDescription) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.items = new ArrayList<>();
        this.npc = null;
    }

    public Location() {
        this("empty street", "merely a quiet street");
    }

    public String getLocationName() {
        return locationName; }

    public String getLocationDescription() { 
        return locationDescription; }

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
        return locationName + "\n" + locationDescription + "\n" + itemText + npcText;
    }
}