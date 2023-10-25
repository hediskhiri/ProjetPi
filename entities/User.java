/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 * @author Lenovo
 */
public class User {

    int idUser;
    Panier panier;

    public User(int id, Panier panier) {
        this.idUser= id;

    }

    public User() {
    }

    public User(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return idUser;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setId(int id) {
        this.idUser= id;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }


}
