package fr.univamu.iut.commande.data;

import fr.univamu.iut.commande.domaine.Commande;
import jakarta.ws.rs.NotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CommandeRepository {
    private static ArrayList<Commande> commandeRepository;

    public static int ajouterCommande(Commande commande) throws SQLException, ClassNotFoundException {
        commandeRepository.add(commande);
        CommandeRepositoryMariadb db = null;
        try {
            db = new CommandeRepositoryMariadb("jdbc:mariadb://mysql-louarn-mathis-controle.alwaysdata.net/louarn-mathis-controle_annonces", "347369", "Mathis200'");
            db.stockerCommande(commande);
        }catch (Exception e){
            System.err.println(e);
        }
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
