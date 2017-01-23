/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Client;
import dao.Login;
import dao.Reservation;
import dao.TcPays;
import dao.Voiture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import metier.ImetierImpl;

/**
 *
 * @author TECHNOPC
 */
@ManagedBean
@SessionScoped
public class GestionClient {

    private final metier.Imetier metier;
    private Client client;
    private List<Client> clients;
    private Login login;
    private List<TcPays> nationalites;
    private Client cl;
    private Reservation rsv;
    private Voiture vt;

    /**
     * Creates a new instance of GestionClient
     */
    public GestionClient() {
        metier = new ImetierImpl();
        clients = metier.listerClient();
        login = new Login("", "");
        nationalites = metier.listerPays();
        rsv=new Reservation();
    }

    public String verifier() {
        boolean b = false;
        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
            Client next = iterator.next();
            if (next.getNomCl().equals(login.getNom()) && next.getMotDePasse().equals(login.getMdp())) {
                b = true;
                System.out.println(next.toString());
                cl = next;
                break;
            }
        }
        if (!(b = true)) {
            return "";
        } else {
            return "acceil/acceil?faces-redirect=true";
        }
    }
    
    public List<Reservation> rsvClient(){
        List<Reservation> rsvs=new ArrayList<>();
        for (Iterator<Reservation> iterator = metier.listerReservation().iterator(); iterator.hasNext();) {
            Reservation next = iterator.next();
            if(Objects.equals(next.getClient().getId(), cl.getId())){
                rsvs.add(next);
            }
        }
        return rsvs;
    }
    
  

    public boolean rsvVerif(Reservation rsv){
        System.out.println(rsv.getEtatReserve());
        return !rsv.getEtatReserve().equals("Non confirmée");
    }
    
    public String reserver(Voiture v){
        if(cl==null)
            return "/acceil/auth?faces-redirect=true";

        if(rsv.getDateDebutReserv().before(rsv.getDateFinReserv()))
        {
             rsv.setClient(cl);
            rsv.setVoiture(v);
            rsv.setEtatReserve("Non confirmée");
            metier.ajouterReservation(rsv);
            v.setEtatVoiture("Réservé");
            metier.modifierVoiture(v);
            rsv=new Reservation();
            System.out.println("succes");
       return "/acceil/acceil?faces-redirect=true";
        } else{
          
           return "/detail/detailvoiture?faces-redirect=true"; 
        }  
     
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients() {
        clients = metier.listerClient();
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<TcPays> getNationalites() {
        return nationalites;
    }

    public void setNationalites(List<TcPays> nationalites) {
        this.nationalites = nationalites;
    }

    public Reservation getRsv() {
        return rsv;
    }

    public void setRsv(Reservation rsv) {
        this.rsv = rsv;
    }

}
