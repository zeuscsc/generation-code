package com.zeuschiu.collections.oop;

class Products{
    public String name;
    public Integer quantity;
    public Double earn;
    public Products(String name,Integer quantity){
        this.name=name;
        this.quantity =quantity;
        earn=0.0;
    }
    public void buy(){
        quantity--;
        earn+=10.0;
    }
}
class FoodStock extends Products{
    public FoodStock(String name,Integer quantity){
        super(name,quantity);
    }
    public void buySet(DrinkStock drinkStock){
        buy();
        drinkStock.buy();
    }
}
class DrinkStock extends Products{
    public DrinkStock(String name,Integer quantity){
        super(name,quantity);
    }
}
public class Main {

    public static void main(String[] args) {
        FoodStock hamburger=new FoodStock("Hamburger",100);
        DrinkStock cola=new DrinkStock("Cola",100);
        cola.buy();
        hamburger.buySet(cola);
    }
}
