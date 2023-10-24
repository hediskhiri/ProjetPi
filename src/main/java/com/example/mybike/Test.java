/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybike;

import entity.Location;
import entity.Velo;

/**
 *
 * @author houss
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Velo v1 = new Velo(1,"g152","disponible");
        Velo v2 = new Velo(68,"aaa745","non disponible");
        Location l1= new Location(1,1,"2023-10-18","2023-10-25");
        Location l2= new Location(1,1,5,"2023-10-13","2023-10-28",50);

        Velo v3 = v1;
      //  System.out.println(v1);
       
        
       ServiceVelo sv = new ServiceVelo();
      // sv.ajouter(v1);
       sv.modifier(v2);

       //sv.afficher();
       ServiceLocation sl =new ServiceLocation();
       //sl.ajouter(l2);
      // sl.modifier(l1);
       // sl.supprimer(4);
       // System.out.println(l1);

            ServiceVelo serviceVelo = new ServiceVelo();
            int nombreVeloDisponibles = serviceVelo.getNombreVeloDisponibles();
            System.out.println("Nombre de vélos disponibles : " + nombreVeloDisponibles);


        }





    }
    

