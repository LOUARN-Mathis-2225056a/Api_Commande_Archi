package fr.univamu.iut.commande.domaine;

import fr.univamu.iut.commande.service.CalculPrixTotal;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Commande {
    private int idCommande;
    private String nomMenu;
    private ArrayList<ArrayList<Objects>> contenu;
    private Number prixTotal;
    private String adresseDeLivraison;
    private String dateDeCommande;
    private String dateDeLivraison;
    private static int prochainID = 0;

    public Commande(String nomMenu, ArrayList<ArrayList<Objects>> contenu, String adresseDeLivraison, String dateDeCommande, String dateDeLivraison) {
        this.idCommande = prochainID;
        this.nomMenu = nomMenu;
        this.contenu = contenu;
        this.prixTotal = CalculPrixTotal.calculerPrixTotal(contenu);
        this.adresseDeLivraison = adresseDeLivraison;
        this.dateDeCommande = dateDeCommande;
        this.dateDeLivraison = dateDeLivraison;
        prochainID++;
    }

    public static Commande creerCommande(String nomMenu, ArrayList<ArrayList<Objects>> contenu, String adresseDeLivraison, String dateDeCommande, String dateDeLivraison) {
        return new Commande(nomMenu,contenu,adresseDeLivraison,dateDeCommande,dateDeLivraison);
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public Number getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Number prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getAdresseDeLivraison() {
        return adresseDeLivraison;
    }

    public void setAdresseDeLivraison(String adresseDeLivraison) {
        this.adresseDeLivraison = adresseDeLivraison;
    }

    public String getDateDeCommande() {
        return dateDeCommande;
    }

    public void setDateDeCommande(String dateDeCommande) {
        this.dateDeCommande = dateDeCommande;
    }

    public String getDateDeLivraison() {
        return dateDeLivraison;
    }

    public void setDateDeLivraison(String dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
    }

    public ArrayList<ArrayList<Objects>> getContenu() {
        return contenu;
    }

    public void setContenu(ArrayList<ArrayList<Objects>> contenu) {
        this.contenu = contenu;
    }
}
