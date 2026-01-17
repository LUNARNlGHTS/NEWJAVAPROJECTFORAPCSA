public class KeyItem extends Item {
    //creates variable
    private Location isUseable;

    //paramaterized constructor
    public KeyItem(String itemName, String itemDescription, Location isUseable) {
        super(itemName, itemDescription);
        this.isUseable = isUseable;
    }

    //getter
    public Location getIsUseable(){
        return isUseable;
    }

    //setter
    public void setIsUseable(Location isUseable){
        this.isUseable = isUseable;
    }
}