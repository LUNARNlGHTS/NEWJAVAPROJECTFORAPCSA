public class Player extends Character {
    private int row;
    private int col;

    public Player(String name) {
        super(name, 100);
        this.row = 2;
        this.col = 2;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public void move(String direction) {
        if (direction.equals("north")) row--;
        else if (direction.equals("south")) row++;
        else if (direction.equals("east")) col++;
        else if (direction.equals("west")) col--;
    }

    public void setPosition(int r, int c) {
        this.row = r;
        this.col = c;
    }
}