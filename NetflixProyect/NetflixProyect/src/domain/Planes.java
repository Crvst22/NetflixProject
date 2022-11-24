package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fava_
 */
public class Planes {
    private int code;
    private String typePlan;
    private int price;
    private int quantity;

    public Planes(int code, String typePlan, int price, int quantity) {
        this.code = code;
        this.typePlan = typePlan;
        this.price = price;
        this.quantity = quantity;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTypePlan() {
        return typePlan;
    }

    public void setTypePlan(String typePlan) {
        this.typePlan = typePlan;
    }
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Planes{" + "code=" + code + ", typePlan=" + typePlan + ", price=" + price + ", quantity=" + quantity + '}';
    }
  
}
