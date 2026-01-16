public class Item {
    private String itemName;
    private String itemDescription;
    private int itemValue;

    public Item(String itemName, String itemDescription, int itemValue) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemValue = itemValue;
    }

    public Item(){
        this("new item", "boring thingy", 1);
    }

    public String getItemName() { 
        return itemName; }

    public String getItemDescription(){
        return itemDescription;
    }

    public int getItemValue(){
        return itemValue;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription){
        this.itemDescription = itemDescription;
    }

    public void setItemValue(int itemValue){
        this.itemValue = itemValue;
    }

    public String toString() {
        return itemName;
    }
}