package Produit;

public class ProRefrigere extends Produit implements EstRefrigere{
    //============================= Attributs =============================
    // The ProRefrigere subclass adds one more field
    private double temperature;
    private final TypeProduit type = TypeProduit.REFRIGERATED;

    // the ProRefrigere subclass has one constructor
    public ProRefrigere(String nom, double prix, String marque)
    {
        // invoking base-class(Produit) constructor
        super(nom, prix, marque);
        this.temperature = tRefrigerated();
    }

    //============================= Getters et Setters =============================
    // the ProRefriToxic subclass adds more method
    public double getTempepature() {
        return temperature;
    }
    public TypeProduit getType(){return TypeProduit.REFRIGERATED;}

    // Méthodes


    @Override
    public double tRefrigerated() {
        return 7;
    }
}
