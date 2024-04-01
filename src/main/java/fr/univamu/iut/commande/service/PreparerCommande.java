package fr.univamu.iut.commande.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import fr.univamu.iut.commande.data.CommandeRepository;
import fr.univamu.iut.commande.domaine.Commande;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("preparer-commande")
public class PreparerCommande {
    @POST
    @Consumes("application/json")
    public void preparerCommande(JsonObject menu){
        Gson gson = new Gson();
        CommandeRepository.ajouterCommande(
                Commande.creerCommande(
                        menu.getString("nomMenu"),
                        menu.getJsonArray("contenu").stream().toArray(),
                        menu.getString("adresseDeLivraison"),
                        menu.getString("adresseDeLivraison"),
                        menu.getString("adresseDeLivraison")

        ));
    }
}
