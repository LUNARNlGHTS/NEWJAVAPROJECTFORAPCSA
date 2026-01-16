public class Building extends Location {

    public Building(String name, String description) {
        super(name, description);
    }

    public Building(){
        this("new building", "nothing notable");
    }

    public void enter(Player player) {
        System.out.println("You enter the " + getLocationName());
    }

    public void exit(Player player) {
        System.out.println("You leave the " + getLocationName());
    }
}