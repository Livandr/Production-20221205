package Stock;

import Produit.*;

import java.util.ArrayList;

public class Complex {

    // 1. Variables
    private ArrayList<Stock> listeDesStocks = new ArrayList<>();

    // 2. Encapsulation

    public ArrayList<Stock> getListeDesStocks() {
        return listeDesStocks;
    }

    // 3. Constructeur (Constructeur vide utilisé)


    //4. Méthodes

    public void creerStock (TypeProduit typeDeStock, int tailleDuStock, String adresse){

        //Création d'un stock selon le type
        switch(typeDeStock){
            case TOXIC_AND_REFRIGERATED: listeDesStocks.add(new Stock<ProRefriToxic>(tailleDuStock, adresse, TypeProduit.TOXIC_AND_REFRIGERATED));
                break;

            case TOXIC: listeDesStocks.add(new Stock<ProToxic>(tailleDuStock, adresse, TypeProduit.TOXIC));
                break;

            case REFRIGERATED: listeDesStocks.add(new Stock<ProRefrigere>(tailleDuStock, adresse, TypeProduit.REFRIGERATED));
                break;

            case NOT_TOXIC_AND_NOT_REFRIGERATED: listeDesStocks.add(new Stock<Produit>(tailleDuStock, adresse, TypeProduit.NOT_TOXIC_AND_NOT_REFRIGERATED));
                break;
        }
    }


}
