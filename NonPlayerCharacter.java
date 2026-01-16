public class NonPlayerCharacter extends Character {
    private String dialogue;

    public NonPlayerCharacter(String name, String dialogue) {
        super(name, 100);
        this.dialogue = dialogue;
    }

    public void talk() {
        System.out.println(dialogue);
    }
}