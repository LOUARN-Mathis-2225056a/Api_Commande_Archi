package fr.univamu.iut.commande;

import java.util.ArrayList;
import java.util.Map;

public class Commande {
    private int idCommande;
    private String nomMenu;
    private ArrayList<Map<String,Number>> contenu;
    private Number prixTotal;
    private String adresseDeLivraison;
    private String dateDeCommande;
    private String dateDeLivraison;
    private static int prochainID = 0;
}
