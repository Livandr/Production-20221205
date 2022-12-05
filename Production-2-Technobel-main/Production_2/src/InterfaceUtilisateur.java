import Produit.*;
import Stock.*;

import java.util.Scanner;

public class InterfaceUtilisateur {

    public void start(){

        Complex complex = new Complex();
        int choixU;
        boolean repeat;
        boolean nouveauStock;

        //Création du complex

        nouveauStock(complex);



        do{
            // Demande à l'utilisateur sur quel stock il veut agir
            System.out.println("Dans quel n° de stock voulez vous intéragir? (0. Aucun, Max " + complex.getListeDesStocks().size() +")");
            for(int i=0; i<complex.getListeDesStocks().size(); i++){
                System.out.print("Stock " +(i+1)+ ": "+ complex.getListeDesStocks().get(i).getTypeStock());
                System.out.println(" - Places occupées: " + complex.getListeDesStocks().get(i).occupationStock(complex.getListeDesStocks().get(i).getQuantite()) + " sur " + complex.getListeDesStocks().get(i).getTailleStock());
            }
            choixU = Tools.demanderNB(0,complex.getListeDesStocks().size());


            if(choixU > 0){
                choixU --;

                //Obtention du stock dans la liste pour travailler avec
                System.out.println("Stock pour: " + complex.getListeDesStocks().get(choixU).getTypeStock());

                Stock stock = complex.getListeDesStocks().get(choixU);

                // Affichage produit

                for(int i=0; i<stock.getTailleStock();i++){
                    if(stock.getQuantite()[i]==0)
                        break;

                    System.out.println("Article: " + stock.getStock()[i].getNom() + " , " + stock.getStock()[i].getPrix() + " €, " + stock.getStock()[i].getMarque() + " - Quantité: " + stock.getQuantite()[i]);
                }

                //Choix de l'action
                System.out.println("Que voulez-vous faire? 0. Revenir 1. Ajouter un produit, 2. Modifier un produit, 3. Supprimer un produit");
                choixU = Tools.demanderNB(0,3);

                switch(choixU){
                    case 0: break;
                    case 1: interfaceCreerProduit(stock);
                            break;

                    case 2: interfaceModifierProduit(stock);
                            break;

                    case 3: interfaceSupprimerProduit(stock);
                            break;
                }
            } else{

                //Si l'utilisateur ne choisit pas de stock, demande pour en creer un
                System.out.println("Voulez-vous creer un nouveau stock?");
                nouveauStock = Tools.ouiOuNon();

                if(nouveauStock)
                    nouveauStock(complex);

            }

            //Demande si l'utilisateur veut continuer à travailler
            System.out.println("Voulez-faire une autre action?");
            repeat = Tools.ouiOuNon();

        }while(repeat);

        System.out.println("Programme terminé");

    }

    public void interfaceCreerProduit(Stock stock){

            //demande à l'utilisateur les information pour ajouter un produit au stock
            String nom = Tools.demanderString("Quel est son nom?");
            System.out.println("Quel est son prix?");
            double prix = Tools.demanderPrix();
            String marque = Tools.demanderString("Quel est sa marque?");
            System.out.println("Quel est type du Produit? 1. Classique, 2. Toxique, 3. Refrigéré, 4. Toxique et Refrigéré");
            TypeProduit type = Tools.typeProduit(Tools.demanderNB(1,4));

            try{
                switch(type){
                    case REFRIGERATED : stock.addProduct(new ProRefrigere(nom,prix,marque));
                        break;

                    case TOXIC: stock.addProduct(new ProToxic(nom,prix,marque));
                        break;

                    case TOXIC_AND_REFRIGERATED: stock.addProduct(new ProRefriToxic(nom,prix,marque));
                        break;
                    case NOT_TOXIC_AND_NOT_REFRIGERATED: stock.addProduct(new Produit(nom,prix,marque));
                        break;

                }

                System.out.println("Produit ajouté!");

                //Si l'ajout à echoué, retour de l'erreur dans la console
            } catch (RuntimeException e){
                System.out.println(e);
            }

    }

    public void interfaceModifierProduit(Stock stock){

        //demande à l'utilisateur les information pour la modification du produit au stock
        String nom = Tools.demanderString("Quel est son nom?");
        System.out.println("Quel est son prix?");
        double prix = Tools.demanderPrix();
        String marque = Tools.demanderString("Quel est sa marque?");
        System.out.println("Quel est sa nouvelle quantité? taille du stock: " + stock.getTailleStock());
        int quantite = Tools.demanderNB(0,stock.getTailleStock());

        try{

        stock.modifyStockProduct(nom, prix, marque, quantite);

            System.out.println("Produit modifié");

            //Si la modification à echouée, retour de l'erreur dans la console
        } catch (RuntimeException e){
            System.out.println(e);
        }

    }

    public void interfaceSupprimerProduit(Stock stock){


        //demande à l'utilisateur les information pour la suppression du produit
        String nom = Tools.demanderString("Quel est son nom?");
        System.out.println("Quel est son prix?");
        double prix = Tools.demanderPrix();
        String marque = Tools.demanderString("Quel est sa marque?");

        try{

            stock.removeProduct(nom, prix, marque);

            System.out.println("Produit supprimé");

            //Si la suppression à echouée, retour de l'erreur dans la console
        } catch (RuntimeException e){
            System.out.println(e);
        }

    }

    public void nouveauStock(Complex complex){
        Scanner sc = new Scanner(System.in);
        int taille;
        String adresse;
        TypeProduit typeDeStock;

        //Collecte des information pour creer un stock
        System.out.println("Quel type de stock voulez-vous creer? 1. Classique, 2. Toxique, 3. Refrigéré, 4. Toxique et Refrigéré");
        typeDeStock = Tools.typeProduit(Tools.demanderNB(1,4));

        System.out.println("Quel taille (max 1 000 000 000)?");
        taille = Tools.demanderNB(1,1000000000);

        System.out.println("Quelle adresse?");
        adresse = sc.nextLine();

        complex.creerStock(typeDeStock, taille, adresse);
    }


}
