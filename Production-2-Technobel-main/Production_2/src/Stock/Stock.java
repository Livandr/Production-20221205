package Stock;

import Produit.*;
import Exception.*;


public class Stock <P extends Produit>{

    //1. Variables

    private final int tailleStock;

    private final Produit [] stock;

    private final int [] quantite;

    private final String adresse;

    private TypeProduit typeStock;


    //2. Encapsulation

    public int getTailleStock() {
        return tailleStock;
    }

    public Produit[] getStock() {
        return stock;
    }

    public int[] getQuantite() {
        return quantite;
    }

    public String getAdresse() {
        return adresse;
    }

    public TypeProduit getTypeStock() {
        return typeStock;
    }

    //3. Constructeur

    public Stock(int tailleStock, String adresse, TypeProduit type) {
        //si taille négative, adresse null ou vide: exception
        if(tailleStock<=0)
            throw new NotNegativeException();

        this.tailleStock = tailleStock;

        if (adresse == null)
            throw new IllegalArgumentException("Adresse ne peut être null");

        if (adresse.equals(""))
            throw new IllegalArgumentException("Adresse ne peut être vide");
        this.adresse = adresse;
        this.stock = new Produit[tailleStock];
        this.quantite = new int[tailleStock];
        this.typeStock = type;
    }

    //4. Méthodes

    public int produitPresent (String nom, double prix, String marque){

        //Boucle pour chercher si un produit est déjà présent

        for (int i = 0; i<stock.length; i++){
            if (stock[i] != null && nom.equals(stock[i].getNom()) && prix == stock[i].getPrix() && marque.equals(stock[i].getMarque())){
                return i;
            }
        } return -1;
    }


    public void addProduct(P Produit) {

        int totalStock = occupationStock(quantite);

        // Exception si stock déjà plein
        if (totalStock == tailleStock)
            throw new FullException();

        // Exception si le bon produit n'est pas dans le bon stock
        if (typeStock != Produit.getType())
            throw new DifferentTypeException();

        // Si le produit est présent (et qu'il reste de la place dans le stock), on ajoute le quantité
        if (produitPresent(Produit.getNom(), Produit.getPrix(), Produit.getMarque()) >= 0 && totalStock < tailleStock) {
            quantite[produitPresent(Produit.getNom(), Produit.getPrix(), Produit.getMarque())]++;
        } else if (totalStock < tailleStock) //Si le produit n'est pas présent, on cherche le premier espace vide pour mettre le produit dedans
            for (int i = 0; i < stock.length; i++) {
                if (stock[i] == null) {
                    stock[i] = Produit;
                    quantite[i] = 1;
                    break;
                }
            }
    }

    public void removeProduct(String nom, double prix, String marque) {

        // Cherche si le produit est présent puis mets "null" dans le tableau des Produits à l'index en question et le stock à 0

        if (produitPresent(nom, prix, marque) >= 0) {
                quantite[produitPresent(nom, prix, marque)] = 0;
                stock[produitPresent(nom, prix, marque)] = null;
        } else // Si produit non présent, lance une exception
            throw new NotPresentException();
    }

    public void modifyStockProduct(String nom, double prix, String marque, int nouveauStock){

        //Si Nouveau Stock négatif ou plus grand que la taille du stock: Exception
        if (nouveauStock <= 0 || nouveauStock > tailleStock)
            throw new IndexOutOfBoundsException("Nouveau stock invalide");

        //Si produit non présent, exception
        if (produitPresent(nom, prix, marque) == -1)
            throw new NotPresentException();

        // Calcul de la taille actuelle du stock
        int totalStock = occupationStock(quantite);

        //Si la taille du stock permet la modification, on change la quantité du Produit. Sinon exception stock plein
        if (totalStock + nouveauStock - quantite[produitPresent(nom, prix, marque)] <= tailleStock)
            quantite[produitPresent(nom, prix, marque)] = nouveauStock;
        else
            throw new FullException();
    }

    public int occupationStock(int [] tabQuantite){
        int totalStock = 0;

        for (int i = 0; i < tailleStock ; i++) {
            totalStock+=tabQuantite[i];
        }

        return totalStock;
    }
}
