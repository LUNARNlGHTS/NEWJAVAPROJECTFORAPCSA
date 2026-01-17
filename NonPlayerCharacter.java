public class NonPlayerCharacter extends Character {
    //creates variable
    private String dialogue;

    //paramaterized and unparameterized constructors
    public NonPlayerCharacter(String characterName, String dialogue) {
        super(characterName);
        this.dialogue = dialogue;
    }

    public NonPlayerCharacter(){
        this("new npc", "what're you buyin");
    }

    //getter
    public String getDialouge(){
        return dialogue;
    }

    //setter
    public void setDialouge(String dialouge){
        this.dialogue = dialouge;
    }   

    //prints dialouge for the talk command
    public void talk() {
        System.out.println(dialogue);
    }
}