/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;


/**
 * Cette énumération représente les différents états d'une réclamation.
 */
public enum Etat {
    TRAITE("Traité"),
    NON_TRAITE("Non traité");

    private final String libelle;

    Etat(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}