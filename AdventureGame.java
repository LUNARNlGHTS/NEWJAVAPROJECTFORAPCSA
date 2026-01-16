import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Location[][] grid = new Location[5][5];

        // Fill map
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                grid[r][c] = new Location();
            }
        }

        // Special locations
        grid[2][2] = new Location("Town Square", "a fountain containing water is here");
        grid[1][2] = new Shop("Bakery", "mmmmm bread");
        grid[3][2] = new Building("Old Bookstore", "just a locked door nothing out of the ordinary here");
        grid[2][1] = new Location("Oak Garden", "a vast forest of oaks");

        // Items
        Treasure key = new Treasure("Golden Key", "a key for the old bookstore", 100);
        Food bread = new Food("Bread", "bread tastes better than key", 10, false);

        grid[1][2].addItem(bread);
        grid[2][1].addItem(key);

        // NPC
        NonPlayerCharacter merchant = new NonPlayerCharacter(
            "merchant",
            "you need the tree to find the key");
        grid[2][3].setNPC(merchant);

        Player player = new Player("skibidi", 100, 2 ,2);

        System.out.println("welcome to the skibidi's wacky crazy adventure");

        boolean playing = true;

        while (playing) {
            Location current = grid[player.getRow()][player.getCol()];
            System.out.println("\n" + current);
            System.out.println("\ntype help for a list of commands");
            System.out.print("\ncommand: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("move")) {
                String dir = input.substring(5);

                int oldRow = player.getRow();
                int oldCol = player.getCol();

                player.move(dir);

                if (player.getRow() < 0 || player.getRow() >= 5 ||
                    player.getCol() < 0 || player.getCol() >= 5) {

                    System.out.println("you hit a wall!");
                    player.setPosition(oldRow, oldCol);
                }
            }

            else if (input.startsWith("pick up")) {
                String itemName = input.substring(8);
                Item item = current.removeItem(itemName);

                if (item != null) {
                    player.addItem(item);
                    System.out.println("picked up: " + item.getItemName());
                } else {
                    System.out.println("that item isn't here.");
                }
            }

            else if (input.equals("inventory")) {
                player.showInventory();
            }

            else if (input.equals("talk")) {
                if (current.getNPC() != null) {
                    current.getNPC().talk();
                } else {
                    System.out.println("no ones there");
                }
            }

            else if (input.equals("quit")) {
                playing = false;
            } else if (input.equals("help")){
                System.out.println("help: displays this menu \nquit: quits the game");
                 System.out.println("talk: talks to npc characters \ninventory: displays items collected");
                 System.out.println("pick up + item: picks up an item present \nmove + direction: moves skibidi in a direction");
            }

            // WIN CONDITION
            for (Item i : player.getInventory()) {
                if (i.getItemName().equals("Golden Key") &&
                    current.getLocationName().equals("Old Bookstore")) {

                    System.out.println("\nyou unlock the bookstore");
                    System.out.println("winner winner chicken dinner");
                    playing = false;
                }
            }
        }

        System.out.println("thanks for playing");
        scanner.close();
    }
}
