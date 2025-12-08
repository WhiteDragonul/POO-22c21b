/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicul;

/**
 *
 * @author adina
 */
public class Electrica extends Masina implements Reincarcabil, Serializable {
    int capacitateBaterie;
    
    /*public Electrica(){
        super();
        this.capacitateBaterie=200;
    }*/
            
    public Electrica(String marca, float pret, byte vitezaMaxima, int capacitateBaterie){
        super(marca,pret,vitezaMaxima);
        this.capacitateBaterie=capacitateBaterie;
    }
    
    public Electrica(Electrica other){
        super(other);
        this.capacitateBaterie=other.capacitateBaterie;
    }
    
    @Override
    public String toString(){
        return super.toString()+" capacitate baterie"+ capacitateBaterie;
    }
    
    @Override
    public void reincarca(){
       System.out.println("Perioada de incarcare="+capacitateBaterie/10);
    }
}
