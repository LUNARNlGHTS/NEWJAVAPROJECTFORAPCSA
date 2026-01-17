import java.util.ArrayList;

public class Location {
    //creates variables
    private String locationName;
    private String locationDescription;
    private ArrayList<Item> locationItems;
    private NonPlayerCharacter npc;

    //paramaterized and unparameterized constructors
    public Location(String locationName, String locationDescription) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationItems = new ArrayList<>();
        this.npc = null;
    }

    public Location() {
        this("empty street", "merely a quiet street");
    }

    //getters
    public String getLocationName() {
        return locationName; }

    public String getLocationDescription() { 
        return locationDescription; }

    
    public ArrayList<Item> getLocationItems() {
        return locationItems;
    }

    public NonPlayerCharacter getNPC() {
        return npc;
    }

    //setters
    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public void setLocationDescription(String locationDescription){
        this.locationDescription = locationDescription;
    }

    public void setLocationItems(ArrayList<Item> locationItems){
        this.locationItems = locationItems;
    }

    public void setNPC(NonPlayerCharacter npc) {
        this.npc = npc;
    }
    
    //adds an item to a location
    public void addItem(Item item) {
        locationItems.add(item);
    }

    //removes an item from a location
    public Item removeItem(String itemName) {
        for (Item i : locationItems) {
            if (i.getItemName().equalsIgnoreCase(itemName)) {
                locationItems.remove(i);
                return i;
            }
        }
        return null;
    }
    
    //to string
    public String toString() {
        String itemText = locationItems.isEmpty() ? "nothing interesting here" : "Items: " + locationItems;
        String npcText = (npc == null) ? "" : "\nsomeone is present " + npc.getCharacterName();
        return locationName + "\n" + locationDescription + "\n" + itemText + npcText;
    }
}