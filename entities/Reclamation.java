/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;


import java.sql.Date;
import tn.edu.esprit.entities.Etat;
import tn.edu.esprit.entities.TypeRec;


public class Reclamation {
    private int id;
    private String titre;
    private String description;
    private Date date;
    private int iduser;
    private TypeRec typeRec;
    private Etat etat;
    private String email;

    public Reclamation(int id, String titre, String description, Date date, int iduser, TypeRec typeRec, Etat etat, String email) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.iduser = iduser;
        this.typeRec = typeRec;
        this.etat = etat;
        this.email = email;
    }

    public Reclamation(String titre, String description, Date date, int iduser, TypeRec typeRec, Etat etat, String email) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.iduser = iduser;
        this.typeRec = typeRec;
        this.etat = etat;
        this.email = email;
    }

   

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
   

    public Reclamation(int aInt, String string, String string0, Date date, User user) {
       
    }

    public Reclamation() {
        
    }

    public Reclamation(int reclamation_id) {
        
    }

    public Reclamation(int id, String titre, String description, Date date, TypeRec typeRec, Etat etat) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.typeRec = typeRec;
        this.etat = etat;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

   
    

   

    public TypeRec getTypeRec() {
        return typeRec;
    }

    public void setTypeRec(TypeRec typeRec) {
        this.typeRec = typeRec;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

   

    public void setU(int id) {
        
    }

    public int getU(int id) {
        return id;
    }


    

    
}