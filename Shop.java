public class Shop extends Building {

    public Shop(String name, String description) {
        super(name, description);
    }

    public void buyItem(Player player, Item item) {
        player.addItem(item);
        System.out.println("You bought: " + item.getName());
    }
}