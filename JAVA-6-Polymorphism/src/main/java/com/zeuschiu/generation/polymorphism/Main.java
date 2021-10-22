package com.zeuschiu.generation.polymorphism;

abstract class Character{
    public int hp;
    abstract boolean nearDeath();
    boolean hello(){
        return true;
    }
}
class RPG{//Game Engine
    public static void update(Character character){
        if(character.nearDeath())
            System.out.println("Alert");
        else
            System.out.println("You are still ok");
    }
}

class Hero{
    public int hp=10;
    public boolean nearDeath(){
        return true;
    }
}
class Warrior extends  Character{
    @Override
    public boolean nearDeath() {
        return hp<10;
    }//Near Death if hp < 10
}
class Witch extends  Character{
    @Override
    public boolean nearDeath() {
        return hp<20;
    }//Near Death if hp < 20
}

public class Main {
    public static void main(String[] args){
        Warrior zeus=new Warrior();
        Witch hugo=new Witch();
        RPG.update(zeus);
        RPG.update(hugo);
    }
}
