/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author mikemike
 */
public class FightMode 
{
    
    private int playerHP;
    private int enemyHP;
    private int heroToughness;
    private int enemyToughness;
    private String heroName;
    private String enemyName;
    private String heroSkill;
    private int heroSkillPower;
    private boolean fightSetup;
    private int heroDamage;
    private int enemyDamage;
    private int enemySkillPower;
    private boolean chooseNewHero;
    private boolean fightWithBoss;
    private boolean fightWithEnemy;
    private boolean fightWithGuard;
    private boolean fightWithEnemySouth;
    private boolean fightWithEnemyEast;
    private boolean fightWithEnemyWest;
    private final int ENEMY_INVENTORY_LIMIT = 5;
    private final int PLAYER_INVENTORY_LIMIT = 5;
    ArrayList enemyInventory = new ArrayList(ENEMY_INVENTORY_LIMIT);
    ArrayList playerInventory = new ArrayList(PLAYER_INVENTORY_LIMIT);
    SecureRandom random = new SecureRandom();

    
    
    public void addItems(ArrayList heroInventory) {

        for (int count = 0; count < this.enemyInventory.size(); count++) {

            heroInventory.add(this.enemyInventory.get(count));

        }

    }

    public void retrieveItems(ArrayList heroInventory) {

        for (int count = 0; count < this.playerInventory.size(); count++) {

            heroInventory.add(this.playerInventory.get(count));

        }

    }
    
    
    public ArrayList getEnemyInventory() {
        return enemyInventory;
    }

    public void setEnemyInventory(ArrayList enemyInventory) {
        this.enemyInventory = enemyInventory;
    }

    public ArrayList getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(ArrayList playerInventory) {
        this.playerInventory = playerInventory;
    }

    
    public boolean isFightWithEnemySouth() {
        return fightWithEnemySouth;
    }

    public void setFightWithEnemySouth(boolean fightWithEnemySouth) {
        this.fightWithEnemySouth = fightWithEnemySouth;
    }

    public boolean isFightWithEnemyEast() {
        return fightWithEnemyEast;
    }

    public void setFightWithEnemyEast(boolean fightWithEnemyEast) {
        this.fightWithEnemyEast = fightWithEnemyEast;
    }

    public boolean isFightWithEnemyWest() {
        return fightWithEnemyWest;
    }

    public void setFightWithEnemyWest(boolean fightWithEnemyWest) {
        this.fightWithEnemyWest = fightWithEnemyWest;
    }   
    
     
    public boolean isFightWithBoss() {
        return fightWithBoss;
    }

    public void setFightWithBoss(boolean fightWithBoss) {
        this.fightWithBoss = fightWithBoss;
    }

    public boolean isFightWithEnemy() {
        return fightWithEnemy;
    }

    public void setFightWithEnemy(boolean fightWithEnemy) {
        this.fightWithEnemy = fightWithEnemy;
    }

    public boolean isFightWithGuard() {
        return fightWithGuard;
    }

    public void setFightWithGuard(boolean fightWithGuard) {
        this.fightWithGuard = fightWithGuard;
    }

    public boolean isChooseNewHero() {
        return chooseNewHero;
    }

    public void setChooseNewHero(boolean chooseNewHero) {
        this.chooseNewHero = chooseNewHero;
    }
    

    
    public int getEnemySkillPower() {
        return enemySkillPower;
    }

    public void setEnemySkillPower(int enemySkillPower) {
        this.enemySkillPower = enemySkillPower;
    }

    
    public int getHeroDamage() {
        return heroDamage;
    }

    public void setHeroDamage(int heroDamage) {
        this.heroDamage = heroDamage;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    
    public int getHeroToughness() {
        return heroToughness;
    }

    public void setHeroToughness(int heroToughness) {
        this.heroToughness = heroToughness;
    }

    public int getEnemyToughness() {
        return enemyToughness;
    }

    public void setEnemyToughness(int enemyToughness) {
        this.enemyToughness = enemyToughness;
    }

   
    public boolean isFightSetup() {
        return fightSetup;
    }

    public void setFightSetup(boolean fightSetup) {
        this.fightSetup = fightSetup;
    }

    
    public String getHeroSkill() {
        return heroSkill;
    }

    public int getHeroSkillPower() {
        return heroSkillPower;
    }

    public void setHeroSkill(String heroSkill) {
        this.heroSkill = heroSkill;
    }

    public void setHeroSkillPower(int heroSkillPower) {
        this.heroSkillPower = heroSkillPower;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getEnemyName() {
        return enemyName;
    }
    
    
    
    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }
    
    
    public int getPlayerHP() {
        return playerHP;
    }
  

    public void setEnemyHP(int enemyHP) {
        this.enemyHP = enemyHP;
    }


    public int getEnemyHP() {
        return enemyHP;
    }


    public int attackEnemy() {
        int randomDamage;

        randomDamage = random.nextInt(this.heroSkillPower- this.enemyToughness) + 1;

        this.enemyHP = this.enemyHP - randomDamage;

        return randomDamage;
    }

    public int attackPlayer() {
        int randomDamage;

        randomDamage = random.nextInt(this.enemySkillPower - this.heroToughness) + 1;

        this.playerHP = this.playerHP - randomDamage;

        return randomDamage;

    }

}
