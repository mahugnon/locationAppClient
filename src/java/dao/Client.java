package dao;
// Generated 20 janv. 2017 05:45:27 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client  implements java.io.Serializable {


     private Integer id;
     private String cinCl;
     private String civilite;
     private String nomCl;
     private String prenomCl;
     private String numPermi;
     private Date dateNaissanceCl;
     private String nationnaliteCl;
     private String fideliteCl;
     private String adresseCl;
     private int numTelCl;
     private String adresseMailCl;
     private String motDePasse;
     private Set factures = new HashSet(0);
     private Set contrats = new HashSet(0);
     private Set reservations = new HashSet(0);

    public Client() {
    }

	
    public Client(String cinCl, String civilite, String nomCl, String prenomCl, String numPermi, Date dateNaissanceCl, String nationnaliteCl, String fideliteCl, String adresseCl, int numTelCl, String adresseMailCl) {
        this.cinCl = cinCl;
        this.civilite = civilite;
        this.nomCl = nomCl;
        this.prenomCl = prenomCl;
        this.numPermi = numPermi;
        this.dateNaissanceCl = dateNaissanceCl;
        this.nationnaliteCl = nationnaliteCl;
        this.fideliteCl = fideliteCl;
        this.adresseCl = adresseCl;
        this.numTelCl = numTelCl;
        this.adresseMailCl = adresseMailCl;
    }
    public Client(String cinCl, String civilite, String nomCl, String prenomCl, String numPermi, Date dateNaissanceCl, String nationnaliteCl, String fideliteCl, String adresseCl, int numTelCl, String adresseMailCl, String motDePasse, Set factures, Set contrats, Set reservations) {
       this.cinCl = cinCl;
       this.civilite = civilite;
       this.nomCl = nomCl;
       this.prenomCl = prenomCl;
       this.numPermi = numPermi;
       this.dateNaissanceCl = dateNaissanceCl;
       this.nationnaliteCl = nationnaliteCl;
       this.fideliteCl = fideliteCl;
       this.adresseCl = adresseCl;
       this.numTelCl = numTelCl;
       this.adresseMailCl = adresseMailCl;
       this.motDePasse = motDePasse;
       this.factures = factures;
       this.contrats = contrats;
       this.reservations = reservations;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCinCl() {
        return this.cinCl;
    }
    
    public void setCinCl(String cinCl) {
        this.cinCl = cinCl;
    }
    public String getCivilite() {
        return this.civilite;
    }
    
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    public String getNomCl() {
        return this.nomCl;
    }
    
    public void setNomCl(String nomCl) {
        this.nomCl = nomCl;
    }
    public String getPrenomCl() {
        return this.prenomCl;
    }
    
    public void setPrenomCl(String prenomCl) {
        this.prenomCl = prenomCl;
    }
    public String getNumPermi() {
        return this.numPermi;
    }
    
    public void setNumPermi(String numPermi) {
        this.numPermi = numPermi;
    }
    public Date getDateNaissanceCl() {
        return this.dateNaissanceCl;
    }
    
    public void setDateNaissanceCl(Date dateNaissanceCl) {
        this.dateNaissanceCl = dateNaissanceCl;
    }
    public String getNationnaliteCl() {
        return this.nationnaliteCl;
    }
    
    public void setNationnaliteCl(String nationnaliteCl) {
        this.nationnaliteCl = nationnaliteCl;
    }
    public String getFideliteCl() {
        return this.fideliteCl;
    }
    
    public void setFideliteCl(String fideliteCl) {
        this.fideliteCl = fideliteCl;
    }
    public String getAdresseCl() {
        return this.adresseCl;
    }
    
    public void setAdresseCl(String adresseCl) {
        this.adresseCl = adresseCl;
    }
    public int getNumTelCl() {
        return this.numTelCl;
    }
    
    public void setNumTelCl(int numTelCl) {
        this.numTelCl = numTelCl;
    }
    public String getAdresseMailCl() {
        return this.adresseMailCl;
    }
    
    public void setAdresseMailCl(String adresseMailCl) {
        this.adresseMailCl = adresseMailCl;
    }
    public String getMotDePasse() {
        return this.motDePasse;
    }
    
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public Set getFactures() {
        return this.factures;
    }
    
    public void setFactures(Set factures) {
        this.factures = factures;
    }
    public Set getContrats() {
        return this.contrats;
    }
    
    public void setContrats(Set contrats) {
        this.contrats = contrats;
    }
    public Set getReservations() {
        return this.reservations;
    }
    
    public void setReservations(Set reservations) {
        this.reservations = reservations;
    }




}

