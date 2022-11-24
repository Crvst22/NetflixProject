package domain;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fava_
 */
public class Cuenta {
    private int code;
    private int planCode;
    private String name;
    private String lastName;
    private String email;

  
    public Cuenta(int code, int planCode, String name, String lastName, String email) {
        this.code = code;
        this.planCode = planCode;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPlanCode() {
        return planCode;
    }

    public void setPlanCode(int planCode) {
        this.planCode = planCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "code=" + code + ", planCode=" + planCode + ", name=" + name + ", lastName=" + lastName + ", email=" + email + '}';
    }

 


   
    
}
