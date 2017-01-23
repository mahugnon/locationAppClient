package dao;
// Generated 20 janv. 2017 05:45:27 by Hibernate Tools 4.3.1



/**
 * Entretient generated by hbm2java
 */
public class Entretient  implements java.io.Serializable {


     private Integer idEnt;
     private Voiture voiture;
     private int typeEnt;
     private int dateEnt;
     private long montantEnt;

    public Entretient() {
    }

    public Entretient(Voiture voiture, int typeEnt, int dateEnt, long montantEnt) {
       this.voiture = voiture;
       this.typeEnt = typeEnt;
       this.dateEnt = dateEnt;
       this.montantEnt = montantEnt;
    }
   
    public Integer getIdEnt() {
        return this.idEnt;
    }
    
    public void setIdEnt(Integer idEnt) {
        this.idEnt = idEnt;
    }
    public Voiture getVoiture() {
        return this.voiture;
    }
    
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
    public int getTypeEnt() {
        return this.typeEnt;
    }
    
    public void setTypeEnt(int typeEnt) {
        this.typeEnt = typeEnt;
    }
    public int getDateEnt() {
        return this.dateEnt;
    }
    
    public void setDateEnt(int dateEnt) {
        this.dateEnt = dateEnt;
    }
    public long getMontantEnt() {
        return this.montantEnt;
    }
    
    public void setMontantEnt(long montantEnt) {
        this.montantEnt = montantEnt;
    }




}


