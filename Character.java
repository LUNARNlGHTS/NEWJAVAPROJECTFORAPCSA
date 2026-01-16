
public class Character {
    private String characterName;
    private int characterHealth;

    public Character(String characterName, int characterHealth) {
        this.characterName = characterName;
        this.characterHealth = characterHealth;
    }

    public Character(){
        this("null", 1);
    }

    public String getCharacterName() { 
        return characterName; 
    }

    public int getCharacterHealth() { 
        return characterHealth; 
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    public void setCharacterHealth(int characterHealth) {
        this.characterHealth = characterHealth;
    }

    
}
