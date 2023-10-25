/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;


/**
 * Cette énumération représente les différents types de réclamations possibles.
 */
public enum TypeRec {
    INCIDENT("Incident"),
    RECLAMATION("Réclamation"),
    AVIS("Avis");

    private final String libelle;

    TypeRec(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
