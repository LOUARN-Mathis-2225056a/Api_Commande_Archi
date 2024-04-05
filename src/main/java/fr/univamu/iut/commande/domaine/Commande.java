package fr.univamu.iut.commande.domaine;

import fr.univamu.iut.commande.service.CalculPrixTotal;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Commande {
    private int idCommande;
    private String nomMenu;
    private JsonArray contenu;
    private Number prixTotal;
    private String adresseDeLivraison;
    private String dateDeCommande;
    private String dateDeLivraison;
    private static int prochainID = 0;

    public Commande(String nomMenu, JsonArray contenu, String adresseDeLivraison, String dateDeCommande, String dateDeLivraison) {
        this.idCommande = prochainID;
        this.nomMenu = nomMenu;
        this.contenu = contenu;
        this.prixTotal = CalculPrixTotal.calculerPrixTotal(contenu);
        this.adresseDeLivraison = adresseDeLivraison;
        this.dateDeCommande = dateDeCommande;
        this.dateDeLivraison = dateDeLivraison;
        prochainID++;
    }

    public static Commande creerCommande(String nomMenu, JsonArray contenu, String adresseDeLivraison, String dateDeCommande, String dateDeLivraison) {
        return new Commande(nomMenu,contenu,adresseDeLivraison,dateDeCommande,dateDeLivraison);
    }

    public int getIdCommande() {
        return idCommande;
    }
    public String getStringIDCommande(){
        return ""+idCommande;
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

    public JsonArray getContenu() {
        return contenu;
    }

    public void setContenu(JsonArray contenu) {
        this.contenu = contenu;
    }

    public JsonObject getJSON(){
        return Json.createObjectBuilder()
                .add("idCommande",this.idCommande)
                .add("nomMenu", this.nomMenu)
                .add("contenu", this.contenu)
                .add("adresseDeLivraison", this.adresseDeLivraison)
                .add("dateDeLivraison", this.dateDeLivraison)
                .add("dateDeCommande", this.dateDeCommande)
                .add("prixTotal", this.prixTotal.toString())
                .build(); //convertit l'objet createObjectBuilder en JsonObject
    }
}

//URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
//
//// Open a connection(?) on the URL(??) and cast the response(???)
//HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//// Now it's "open", we can set the request method, headers etc.
//connection.setRequestProperty("accept", "application/json");
//
//// This line makes the request
//InputStream responseStream = connection.getInputStream();
//
//// Manually converting the response body InputStream to APOD using Jackson
//ObjectMapper mapper = new ObjectMapper();
//APOD apod = mapper.readValue(responseStream, APOD.class);
//
//// Finally we have the response
//System.out.println(apod.title);