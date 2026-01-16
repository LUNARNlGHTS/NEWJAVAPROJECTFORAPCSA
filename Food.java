public class Food extends Item {

    boolean isAllergic;

    public Food(String itemName, String itemDescription, int itemValue, boolean isAllergic) {
        super(itemName, itemDescription, itemValue);
        this.isAllergic = isAllergic;
    }

    public Food(){
        this("new food", "food from Toriko", 1, false);
    }
}