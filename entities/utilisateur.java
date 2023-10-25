/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Lenovo
 */
public class utilisateur {
      private  int idUser ;
    private  String username;
    private  String email;
    private  String password;
    private  String role;

    private  String gender;

    private  String image;

    private   String date;



    public utilisateur() {
    }

    public utilisateur(int idUser, String username, String email, String password, String role, String gender, String image, String date) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.image = image;
        this.date = date;
    }

    public int getId() {
        return idUser;
    }

    public  String getUsername() {
        return username;
    }

    public  String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public  String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public  String getDate() {
        return date;
    }

    public void setEmail(String string) {
       
    }
    
}
