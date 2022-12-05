import Produit.TypeProduit;

import java.util.Scanner;

public class Tools {

    public static boolean ouiOuNon(){
        //fonction oui ou non
        Scanner sc = new Scanner (System.in);
        boolean choixU=false, repeat;
        String temp;

        do{
            // Vérifie l'entrée utilisateur pour le transformer en boolean
            System.out.println("Oui (O) ou non(N)");
            temp= sc.nextLine();
            if((((temp.charAt(0))==('o'))||((temp.charAt(0))==('O')))&&(temp.length()==1)){
                choixU=true;
                repeat=false;
            }else if((((temp.charAt(0))==('n'))||((temp.charAt(0))==('N')))&&(temp.length()==1)){
                repeat=false;
            }else{
                System.out.println("Choix invalide");
                repeat=true;
            }
        }while (repeat);
        return choixU;
    }

    public static int demanderNB(int min, int max){
        //Entrée nombre
        Scanner sc = new Scanner (System.in);
        int nbUser=0;
        boolean entreeOK;

        //Vérification de l'entrée utilisateur
        do {
            try {
                nbUser = Integer.parseInt(sc.nextLine());
                if((nbUser>min-1)&&(nbUser<max+1)){
                    entreeOK=true;
                }else{
                    System.out.println("Ce nombre n'est pas compris entre " + min + " et " + max);
                    entreeOK=false;
                }

            } catch(NumberFormatException e){
                System.out.println("Ce n'est pas un nombre. Réessayez!");
                entreeOK=false;
            }
            // Si le nombre n'est pas ok, l'utilisateur doit recommencer
        }while(!entreeOK);
        return nbUser;
    }

    public static double demanderPrix(){
        //Entrée nombre
        Scanner sc = new Scanner (System.in);
        double nbUser=0;
        boolean entreeOK;

        do {
            //demande à l'utilisateur d'entrer un nombre, si pas correct il recommence
            try {
                nbUser = Integer.parseInt(sc.nextLine());
                if((nbUser>0)){
                    entreeOK=true;
                }else{
                    System.out.println("Ce nombre ne peux être négatif");
                    entreeOK=false;
                }

            } catch(NumberFormatException e){
                System.out.println("Ce n'est pas un nombre. Réessayez!");
                entreeOK=false;
            }
        }while(!entreeOK);
        return nbUser;
    }

    public static TypeProduit typeProduit (int num){
        //Enum selon le choix utilisateur
        switch (num){
            case 1: return TypeProduit.NOT_TOXIC_AND_NOT_REFRIGERATED;
            case 2: return TypeProduit.TOXIC;
            case 3: return TypeProduit.REFRIGERATED;
            case 4: return TypeProduit.TOXIC_AND_REFRIGERATED;
            default: throw new IllegalArgumentException("Choix inconnu");
        }
    }

    public static String demanderString(String message){
        Scanner sc = new Scanner (System.in);

        System.out.println(message);
        return sc.nextLine();
    }
}
