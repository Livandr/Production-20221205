package Produit;

import Exception.*;

public class Produit {
    //============================= Attributs =============================
    private String nom;
    private double prix;
    private String marque;



    //============================= Constructeurs =============================
    public Produit(String nom, double prix, String marque) {
        setNom(nom);
        setPrix(prix);
        setMarque(marque);
    }


    //============================= Getters et Setters =============================
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        //Si nom null ou vide, Exception
        if(nom == null)
            throw new IllegalArgumentException("Nom ne peut être null");

        if(nom.equals(""))
            throw new IllegalArgumentException("Nom ne peut être vide");

        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        //Si prix negatif: exception
        if (this.getPrix()>0)
            throw new NotNegativeException();

        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        //Si marque null ou vide, Exception
        if(marque == null)
            throw new IllegalArgumentException("Nom ne peut être null");

        if(marque.equals(""))
            throw new IllegalArgumentException("Nom ne peut être vide");

        this.marque = marque;
    }

    public TypeProduit getType() {
        return TypeProduit.NOT_TOXIC_AND_NOT_REFRIGERATED;
    }


}