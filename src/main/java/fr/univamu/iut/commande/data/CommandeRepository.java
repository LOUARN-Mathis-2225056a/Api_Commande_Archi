package fr.univamu.iut.commande.data;

import fr.univamu.iut.commande.domaine.Commande;

import java.util.ArrayList;

public class CommandeRepository {
    private static ArrayList<Commande> commandeRepository;

    public static void ajouterCommande(Commande commande){
        commandeRepository.add(commande);
    }
}
