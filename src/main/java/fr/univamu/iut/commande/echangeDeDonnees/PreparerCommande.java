package fr.univamu.iut.commande.echangeDeDonnees;

import fr.univamu.iut.commande.data.CommandeRepository;
import fr.univamu.iut.commande.domaine.Commande;

import jakarta.json.JsonObject;
import jakarta.ws.rs.*;

import java.sql.SQLException;


@Path("preparer-commande")
public class PreparerCommande {
    @POST
    @Consumes("application/json")
    public JsonObject preparerCommande(JsonObject data) throws SQLException, ClassNotFoundException {
        return CommandeRepository.getCommande(
                CommandeRepository.ajouterCommande(
                        Commande.creerCommande(
                                data.getString("nomMenu"),
                                data.getJsonArray("contenu"),
                                data.getString("adresseDeLivraison"),
                                data.getString("adresseDeLivraison"),
                                data.getString("adresseDeLivraison")
                        ))).getJSON();
    }
}
