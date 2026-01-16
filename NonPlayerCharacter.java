public class NonPlayerCharacter extends Character {
    private String dialogue;

    public NonPlayerCharacter(String characterName, String dialogue) {
        super(characterName, 100);
        this.dialogue = dialogue;
    }

    public void talk() {
        System.out.println(dialogue);
    }
}