package fr.univamu.iut.commande.data;

import fr.univamu.iut.commande.domaine.Commande;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;

public class CommandeRepository {
    private static ArrayList<Commande> commandeRepository;

    public static int ajouterCommande(Commande commande){
        commandeRepository.add(commande);
        return commande.getIdCommande();
    }

    public static ArrayList<Commande> getCommandeRepository() {
        return commandeRepository;
    }

    public static Commande getCommande(int idCommande){
        for (Commande commande : commandeRepository) {
            if (commande.getIdCommande() == idCommande) {
                return commande;
            }
        }
        throw new NotFoundException("La commande n'est pas présente dans la base de donnée");
    }
}
