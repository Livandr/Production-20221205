package Produit;

public class ProToxic extends Produit implements EstToxique{
    // The ProToxic subclass adds one more field
    private boolean isToxic;

    // the ProToxic subclass has one constructor
    public ProToxic(String nom, double prix, String marque)
    {
        // invoking base-class(Produit) constructor
        super(nom, prix, marque);
        this.isToxic = EstToxic();
    }

    // the ProToxic subclass adds more method

    public boolean isToxic() {
        return isToxic;
    }
    public TypeProduit getType(){return TypeProduit.TOXIC;}

    // Méthodes


    @Override
    public boolean EstToxic() {
        return true;
    }
}
