public class Building extends Location {

    public Building(String name, String description) {
        super(name, description);
    }

    public void enter(Player player) {
        System.out.println("You enter the " + getName() + ".");
    }

    public void exit(Player player) {
        System.out.println("You leave the " + getName() + ".");
    }
}