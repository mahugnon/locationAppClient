/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.Client;

import dao.Parc;
import dao.Voiture;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TECHNOPC
 */
public class Test {

    public static void main(String[] args) {
        metier.ImetierImpl mImpl = new ImetierImpl();
List<Voiture> voitures=mImpl.voitureParMotCle("","", "", "");
        for (Iterator<Voiture> iterator = voitures.iterator(); iterator.hasNext();) {
            Voiture next = iterator.next();
            System.out.println(next.getCarburantVoiture()+"\t"+next.getMarqueVoiture()+
                    "\t"+next.getModeleVoiture()+"\t"+next.getCategorieVoiture());
        }
      
    }
    
}
