/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Client;
import dao.Reservation;
import dao.TcPays;
import dao.Voiture;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import metier.ImetierImpl;

@ManagedBean
@SessionScoped
public class Reservationbean {
    private Client cl;
    private Voiture vt;
    private Reservation rsv;
    private List<TcPays> pays;
    private metier.Imetier metier;
    public Reservationbean() {
        metier=new ImetierImpl();
        pays=metier.listerPays();
        rsv=new Reservation();
        cl=new Client();
    }
    
      public String recupererVt(Voiture vt){
        this.vt=vt;
        return"reservation?faces-redirect=true";
    }
    public String resv() {
        Long d1=rsv.getDateDebutReserv().getTime();
        Long d2=rsv.getDateFinReserv().getTime();
        if(d1<=d2){
            
        
        List<Client> cls = metier.listerClient();
        Client ancient = null;
        for (Iterator<Client> iterator = cls.iterator(); iterator.hasNext();) {
            Client next = iterator.next();
            if (next.getCinCl().equals(cl.getCinCl())) {
                ancient=next;
                break;
            }
           

        }
        if(ancient!=null){
              rsv.setClient(ancient);
        cl.setFideliteCl("Infidèle");
         rsv.setVoiture(vt);
         rsv.setEtatReserve("Non confirmée");
         metier.ajouterReservation(rsv);
         vt.setEtatVoiture("Réservée");
         metier.modifierVoiture(vt);
         rsv=new Reservation();
         cl=new Client();
        }else{
            cl.setFideliteCl("Infidèle");
           rsv.setClient(cl);
            metier.ajouterClient(cl);
        rsv.setEtatReserve("Non comfirmée");
         rsv.setVoiture(vt);
         metier.ajouterReservation(rsv);
         vt.setEtatVoiture("Réservée");
         metier.modifierVoiture(vt);
         rsv=new Reservation();
         cl=new Client();  
        }
 FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes", "Votre reservation à été bien ajouter");
            context.addMessage(null, message);
        return "/acceil/acceil?faces-redirect=true";
        }else{
            FacesContext context=FacesContext.getCurrentInstance();
            FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "La date de fin de reservation ne dois pas être avant la date de debut reservation!!!");
            context.addMessage(null, message);
            return"";
        }
    }

    public Client getCl() {
        return cl;
    }

    public void setCl(Client cl) {
        this.cl = cl;
    }

    public Reservation getRsv() {
        return rsv;
    }

    public void setRsv(Reservation rsv) {
        this.rsv = rsv;
    }

    public List<TcPays> getPays() {
        return pays;
    }

    public Voiture getVt() {
        return vt;
    }

    public void setVt(Voiture vt) {
        this.vt = vt;
    }
    
    
    
}
