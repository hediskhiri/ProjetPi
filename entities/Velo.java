/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author 21655
 */
public class Velo {
 
    private int id_v;
    private String model;
    private String type;
    private String status;
    private Station sta;
    

    public Velo(){
        
    }

    public Velo(int id_v, String model, String type, String status, Station sta) {
        this.id_v = id_v;
        this.model = model;
        this.type = type;
        this.status = status;
        this.sta = sta;
    }

   

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Station getSta() {
        return sta;
    }

    public void setSta(Station sta) {
        this.sta = sta;
    }
    
    
  

  
}
