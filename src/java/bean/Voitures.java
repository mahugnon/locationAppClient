/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Reservation;
import dao.Voiture;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import metier.ImetierImpl;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class Voitures {
    private Voiture voiture;
    private List<Voiture> vts;
    private List<Voiture> filtrevts;
    private final metier.Imetier metier;
    private Reservation reservation;
    private List<Reservation> reservations;
    private String categorie,marque,modele,caburant;

    public Voitures() {
        this.categorie = "";
        this.marque = "";
        this.modele = "";
        this.caburant = "";
         metier = new ImetierImpl();
        vts=metier.listerVoiture();
        reservations=metier.listerReservation();
        reservation=new Reservation();
       
    }
     
 
   //StreamContent
    
    public StreamedContent getStreamedImageById() {
    FacesContext context = FacesContext.getCurrentInstance();

    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
        return new DefaultStreamedContent();
    }
    else {
        // So, browser is requesting the image. Get ID value from actual request param.
        String id = context.getExternalContext().getRequestParameterMap().get("inv");
        System.out.println(id);
        byte[] image = metier.voitureParId(Integer.parseInt(id)).getImage();
        return new DefaultStreamedContent(new ByteArrayInputStream(image));
    }
}
 public StreamedContent getStreamedImage() {
    FacesContext context = FacesContext.getCurrentInstance();

    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
        return new DefaultStreamedContent();
    }
    else {
        // So, browser is requesting the image. Get ID value from actual request param.
        Integer id = voiture.getIdVoiture();
        System.out.println(id);
        byte[] image = metier.voitureParId(id).getImage();
        return new DefaultStreamedContent(new ByteArrayInputStream(image));
    }
}

public String recupererVoiture(Voiture v){
    this.voiture=v;
    System.out.println(v.toString());
    return"/detail/detailvoiture?faces-redirect=true";
}   
    
    public String retour(){
       vts=metier.listerVoiture();
        this.categorie = "";
        this.marque = "";
        this.modele = "";
        this.caburant = "";
        return "acceil?faces-redirect=true";
    }
     public String rechercher(){
         if(marque==null)
             marque="";
         if(modele==null)
             modele="";
         if(categorie==null)
             categorie="";
         if(caburant==null)
             caburant="";
     this.filtrevts=metier.voitureParMotCle(modele,marque, categorie,caburant);
     return "filtre?faces-redirect=true";
    }
    //listenner
     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ""+((Voiture) event.getObject()).getIdVoiture());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<Voiture> getVts() {
        vts=metier.listerVoiture();
        return vts;
    }

    public void setVts(List<Voiture> vts) {
        this.vts = vts;
    }

    

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCaburant() {
        return caburant;
    }

    public void setCaburant(String caburant) {
        this.caburant = caburant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<Voiture> getFiltrevts() {
        return filtrevts;
    }

    public void setFiltrevts(List<Voiture> filtrevts) {
        this.filtrevts = filtrevts;
    }
 
}
