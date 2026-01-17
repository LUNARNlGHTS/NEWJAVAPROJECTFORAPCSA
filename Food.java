public class Food extends Item {

    //creates variable
    boolean isAllergic;

    //paramaterized and unparameterized constructors
    public Food(String itemName, String itemDescription, boolean isAllergic) {
        super(itemName, itemDescription);
        this.isAllergic = isAllergic;
    }

    public Food(){
        this("new food", "food from Toriko", false);
    }

    //getter
    public boolean getIsAllergic(){
        return isAllergic;
    }

    //setter
    public void setIsAllergic(boolean isAllergic){
        this.isAllergic = isAllergic;
    }
}