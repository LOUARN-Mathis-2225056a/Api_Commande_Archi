package fr.univamu.iut.commande.echangeDeDonnees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import fr.univamu.iut.commande.data.CommandeRepository;
import fr.univamu.iut.commande.domaine.Commande;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Objects;

@Path("preparer-commande")
public class PreparerCommande {
    @POST
    @Consumes("application/json")
    public JsonObject preparerCommande(JsonObject data){
        return CommandeRepository.getCommande(
                CommandeRepository.ajouterCommande(
                        Commande.creerCommande(
                                data.getString("nomdata"),
                                data.getJsonArray("contenu"),
                                data.getString("adresseDeLivraison"),
                                data.getString("adresseDeLivraison"),
                                data.getString("adresseDeLivraison")
                        ))).getJSON();
    }
}
