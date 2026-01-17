import java.util.Scanner;

public class AdventureGame {
    //main class
    public static void main(String[] args) {
        //sets a scanner
        Scanner scanner = new Scanner(System.in);

        //makes a 2d array
        Location[][] grid = new Location[5][5];

        //fills with deafult locations
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                grid[r][c] = new Location();
            }
        }

        //adds specific locations
        grid[0][0] = new Location("Abandoned Shack", "an old broken house");
        grid[4][4] = new Location("River Bank", "a calm flowing river");
        grid[0][4] = new Location("Dark Cave", "its cold and dark inside");
        grid[2][2] = new Location("Town Square", "a fountain containing water is here");
        grid[1][2] = new Location("Bakery", "mmmmm bread");
        grid[3][2] = new Location("Old Bookstore", "just a locked door nothing out of the ordinary here");
        grid[2][1] = new Location("Oak Garden", "a vast forest of oaks");

        //makes key item and the very important bread that deserves its place here
        KeyItem key = new KeyItem("Golden Key", "a key for the old bookstore", grid[3][2]);
        Food bread = new Food("Bread", "bread tastes better than key", false);

        //adds them on the map
        grid[1][2].addItem(bread);
        grid[2][1].addItem(key);

       //makes key npc that gives a hint to beat game and puts it on the map
        NonPlayerCharacter merchant = new NonPlayerCharacter(
            "merchant",
            "you need the tree to find the key");
        grid[2][3].setNPC(merchant);
        
        //makes filler npcs and puts them around the map
        String[] npcNames = {"komatsu", "toriko", "rin", "terry", "midora"};
        String[] npcDialogue = {
        "I love cooking",
        "I love eating",
        "food can be dangerous",
        "woof",
        "im so hungry"
        };

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (grid[r][c].getNPC() == null && Math.random() < 0.3) {
                    int i = (int)(Math.random() * npcNames.length);
                    grid[r][c].setNPC(new NonPlayerCharacter(npcNames[i], npcDialogue[i]));
                }
            }
        }

        //makes filler foods and puts them around the map
        String[] foodNames = {"surprise apple", "pair", "ozone grass", "century soup", "god"};

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (Math.random() < 0.3) {
                    boolean allergic = Math.random() < 0.5;
                    String name = foodNames[(int)(Math.random() * foodNames.length)];

                    Food food = new Food(name, "some random food from a far off land", allergic);
                    grid[r][c].addItem(food);
                }
            }
        }

        //makes the player
        Player player = new Player("skibidi", 100, 2 ,2);

        //prints welcome message
        System.out.println("welcome to the skibidi's wacky crazy adventure");

        //boolean for game loop
        boolean playing = true;

        //main game loop
        while (playing) {
            //checks for player death and game over
            if (player.getPlayerHealth() <= 0) {
                System.out.println("\nyou have died.");
                System.out.println("game over loser");
                break;
            }

            //gets player location then displays current location health and inventory
            Location current = grid[player.getRow()][player.getCol()];
            System.out.println("\n=================================================");
            System.out.println("you are at: " + current.getLocationName());
            System.out.println(current.getLocationDescription());

            if (!current.getLocationItems().isEmpty()) {
                System.out.print("you see: ");
                for (Item i : current.getLocationItems()) {
                    System.out.print(i.getItemName() + "  ");
                }
                System.out.println();
            }

            if (current.getNPC() != null) {
                System.out.println("you notice someone here: " + current.getNPC().getCharacterName());
            }

            System.out.println("-------------------------------------------------");
            System.out.println("Health: " + player.getPlayerHealth() + "/100");
            System.out.print("Inventory: ");
            if (player.getPlayerInventory().isEmpty()) {
                System.out.println("empty");
            } else {
                for (Item item : player.getPlayerInventory()) {
                    System.out.print(item.getItemName() + "  ");
                }
                System.out.println();
            }
            System.out.println("=================================================");

            //prints to type the help command and adds a little command flair to highlight
            System.out.println("\ntype help for a list of commands");
            System.out.print("\ncommand: ");

            //gets the input of the user
            String input = scanner.nextLine().toLowerCase();

            //main commands that can be used
            //checks to see if the move is incomplete to prevent an error
            if (input.equals("move")) {
                System.out.println("please enter a direction");
            //uses the move command to move the player also slight chance of getting randomly hurt
            } else if (input.startsWith("move")) {
                if (Math.random() < 0.2) {
                    System.out.println("a wild raccoon steals 5 health from rabies");
                    player.setPlayerHealth(player.getPlayerHealth() - 5);
                }

                String dir = input.substring(5);

                int oldRow = player.getRow();
                int oldCol = player.getCol();

                player.move(dir);

                if (player.getRow() < 0 || player.getRow() >= 5 ||
                    player.getCol() < 0 || player.getCol() >= 5) {

                    System.out.println("you hit a wall!");
                    player.setPosition(oldRow, oldCol);
                }
            //checks to see if the pick up command is incomplete to prevent an error
            } else if (input.equals("pick up")) {
                System.out.println("put pick up plus an item");
            //uses the pick up command to add an item present to inventory
            } else if (input.startsWith("pick up")) {
                String itemName = input.substring(8);
                Item item = current.removeItem(itemName);

                if (item != null) {
                    player.addItem(item);
                    System.out.println("picked up: " + item.getItemName());
                } else {
                    System.out.println("that item isn't here.");
                }
            //uses talk command to play set npc dialouge
            } else if (input.equals("talk")) {
                if (current.getNPC() != null) {
                    current.getNPC().talk();
                } else {
                    System.out.println("no ones there");
                }
            //quits the game
            } else if (input.equals("quit")) {
                playing = false;
            //displays all commands
            } else if (input.equals("help")){
                System.out.println("help: displays this menu \nquit: quits the game");
                System.out.println("talk: talks to npc characters");
                System.out.println("pick up + item: picks up an item present \nmove + direction: moves skibidi in a direction");
                System.out.println("use + item: uses an item");
            //uses items from inventory
            } else if (input.startsWith("use ")) {
                String itemName = input.substring(4).trim();

                boolean won = player.useItem(itemName, current);

                if (won) {
                    playing = false;
                }
            }
        }

        //message for end of the game and closing scanner
        System.out.println("thanks for playing");
        scanner.close();
        
    }
}


