package Produit;

public class ProRefriToxic extends Produit implements EstToxique, EstRefrigere{
    // The ProRefriToxic subclass adds one more field
    private double tempepature;
    private boolean isToxic;

    private final TypeProduit type = TypeProduit.TOXIC_AND_REFRIGERATED;

    // the ProRefriToxic subclass has one constructor
    public ProRefriToxic(String nom, double prix, String marque)
    {
        // invoking base-class(Produit) constructor
        super(nom, prix, marque);

    }

    // the ProRefriToxic subclass adds more method
    public double getTempepature() {
        return tempepature;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public TypeProduit getType(){return TypeProduit.TOXIC_AND_REFRIGERATED;}

    // Méthodes

    @Override
    public double tRefrigerated() {
        return 7;
    }

    @Override
    public boolean EstToxic() {
        return true;
    }

}
