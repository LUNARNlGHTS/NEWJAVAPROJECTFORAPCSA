public class Item {
    //creates variables
    private String itemName;
    private String itemDescription;

    //paramaterized and unparameterized constructors
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;

    }

    public Item(){
        this("new item", "boring thingy");
    }

    //getters
    public String getItemName() { 
        return itemName; }

    public String getItemDescription(){
        return itemDescription;
    }

    //setters
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription){
        this.itemDescription = itemDescription;
    }

    //to string
    public String toString() {
        return itemName;
    }
}