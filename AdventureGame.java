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
        grid[2][2] = new Location("Town Square", "A bright fountain sits here.");
        grid[1][2] = new Shop("Bakery", "Smells like fresh bread.");
        grid[3][2] = new Building("Old Bookstore", "A locked door stands before you.");
        grid[2][1] = new Location("Oak Garden", "A tall oak tree stands here.");

        // Items
        Treasure key = new Treasure("Golden Key", "A shiny golden key.", 100);
        Food bread = new Food("Bread", "Freshly baked bread.", 10);

        grid[1][2].addItem(bread);
        grid[2][1].addItem(key);

        // NPC
        NonPlayerCharacter stranger = new NonPlayerCharacter(
            "Stranger",
            "You seek the Golden Key? Check behind the oak tree..."
        );
        grid[2][3].setNPC(stranger);

        Player player = new Player("Hero");

        System.out.println("Welcome to the Neighborhood Adventure!");

        boolean playing = true;

        while (playing) {
            Location current = grid[player.getRow()][player.getCol()];
            System.out.println("\n" + current);

            System.out.print("\nCommand: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("move")) {
                String dir = input.substring(5);

                int oldRow = player.getRow();
                int oldCol = player.getCol();

                player.move(dir);

                if (player.getRow() < 0 || player.getRow() >= 5 ||
                    player.getCol() < 0 || player.getCol() >= 5) {

                    System.out.println("You hit a wall!");
                    player.setPosition(oldRow, oldCol);
                }
            }

            else if (input.startsWith("pick up")) {
                String itemName = input.substring(8);
                Item item = current.removeItem(itemName);

                if (item != null) {
                    player.addItem(item);
                    System.out.println("Picked up: " + item.getName());
                } else {
                    System.out.println("That item isn't here.");
                }
            }

            else if (input.equals("inventory")) {
                player.showInventory();
            }

            else if (input.equals("talk")) {
                if (current.getNPC() != null) {
                    current.getNPC().talk();
                } else {
                    System.out.println("No one to talk to.");
                }
            }

            else if (input.equals("quit")) {
                playing = false;
            }

            // WIN CONDITION
            for (Item i : player.getInventory()) {
                if (i.getName().equals("Golden Key") &&
                    current.getName().equals("Old Bookstore")) {

                    System.out.println("\nYou unlock the bookstore!");
                    System.out.println("🎉 YOU WIN! 🎉");
                    playing = false;
                }
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
