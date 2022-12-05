package Produit;

public enum TypeProduit {

    REFRIGERATED ("refrigéré"),
    TOXIC("toxique"),
    TOXIC_AND_REFRIGERATED ("toxique et refrigéré"),
    NOT_TOXIC_AND_NOT_REFRIGERATED ("ni toxique, ni réfrigéré");

    private String typeProduit;

    TypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }
}
