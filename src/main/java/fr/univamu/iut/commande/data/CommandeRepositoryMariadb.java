package fr.univamu.iut.commande.data;

import com.google.gson.JsonObject;
import fr.univamu.iut.book.Book;
import fr.univamu.iut.commande.domaine.Commande;
import jakarta.json.Json;


import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant d'accèder aux livres stockés dans une base de données Mariadb
 */
public class CommandeRepositoryMariadb implements Closeable {

    /**
     * Accès à la base de données (session)
     */
    protected Connection dbConnection;

    /**
     * Constructeur de la classe
     *
     * @param infoConnection chaîne de caractères avec les informations de connexion
     *                       (p.ex. jdbc:mariadb://mysql-[compte].alwaysdata.net/[compte]_library_db
     * @param user           chaîne de caractères contenant l'identifiant de connexion à la base de données
     * @param pwd            chaîne de caractères contenant le mot de passe à utiliser
     */
    public CommandeRepositoryMariadb(String infoConnection, String user, String pwd) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        dbConnection = DriverManager.getConnection(infoConnection, user, pwd);
    }

    @Override
    public void close() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public void stockerCommande(Commande commande) {

        String query = "INSERT INTO `Commande`(`idCommande`, `nomMenu`, `prixTotal`, `adresseDeLivraison`, `dateDeCommande`, `dateDeLivraison`, `contenu`) VALUES ('?','?','?','?','?','?','?')";

        // construction et exécution d'une requête préparée
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, commande.getStringIDCommande());
            ps.setString(2, commande.getNomMenu());
            ps.setString(3, commande.getPrixTotal().toString());
            ps.setString(4, commande.getAdresseDeLivraison());
            ps.setString(5, commande.getDateDeCommande());
            ps.setString(6, commande.getDateDeLivraison());
            ps.setString(7, commande.getContenu().toString());

            // exécution de la requête
            ResultSet result = ps.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Commande getCommande(String idCommande) {

        String query = "SELECT * FROM Commande WHERE idCommande=?";

        Commande commande = null;

        // construction et exécution d'une requête préparée
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, idCommande);
            ResultSet result = ps.executeQuery();


            // récupération du premier (et seul) tuple résultat
            while (result.next()) {
                String idCommande1 = result.getString("idCommande");
                String nomMenu = result.getString("nomMenu");
                String prixTotal = result.getString("prixTotal");
                String adresseDeLivraison = result.getString("adresseDeLivraison");
                String dateDelivraison = result.getString("dateDelivraison");
                String dateDeCommande = result.getString("dateDeCommande");
                String contenu = result.getString("contenu");

                commande = Commande.creerCommande(nomMenu, Json.createArrayBuilder().add(contenu).build(), adresseDeLivraison, dateDeCommande, dateDelivraison);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commande;
    }
}
