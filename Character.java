
public class Character {
    //makes variable
    private String characterName;

    //paramaterized and unparameterized constructors
    public Character(String characterName) {
        this.characterName = characterName;
    }

    public Character(){
        this("new character");
    }

    //getter
    public String getCharacterName() { 
        return characterName; 
    }

    //setter
    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }


    
}
