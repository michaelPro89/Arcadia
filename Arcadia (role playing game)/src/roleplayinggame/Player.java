/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

import java.util.ArrayList;

/**
 *
 * @author mikemike
 */
public class Player {

    private String playerName;
    private String playerChoice;
    boolean checkingInput;
    private String race;
    private final int HEROS_LIMIT = 3;
    ArrayList charactersList = new ArrayList(HEROS_LIMIT);
    private boolean inventoryFull = false;

    
    
    
    public String getPlayerName() {
        return playerName;
    }

    public int getHEROS_LIMIT() {
        return HEROS_LIMIT;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public void removeCharacter(String hero) {
        String heroToRemove = hero;
          this.charactersList.remove(heroToRemove);

    }

    public Boolean addCharacter(String character) {

        // Block from adding to inventory if the size of inventoryList is equal to or higher then available Inventory_size
        if (this.charactersList.size() < this.HEROS_LIMIT) {
            this.charactersList.add(character);

        } else {
            this.inventoryFull = true;
        }

        //return true if inventory is full
        return this.inventoryFull;

    }

    public boolean searchForHero(String hero) {

        boolean containsHero = false;

        if (this.charactersList.contains(hero)) {

            containsHero = true;

        }

        return containsHero;
    }

    public boolean isCharactersListEmpty() {
        boolean empty = false;

        if (this.charactersList.size() == 0) {
            empty = true;
        }

        return empty;
    }

    public int getCharacterListSize() {
        int size;

        size = this.charactersList.size();

        return size;
    }

    public String showCharacterAt(int index) {
        String hero;

        hero = this.charactersList.get(index).toString();

        return hero;
    }

}
