package fr.univamu.iut.commande.service;

import jakarta.json.JsonArray;

import java.lang.reflect.Array;

public class CalculPrixTotal {
    public static int calculerPrixTotal(JsonArray contenu) {
        int prixTotal = 0;
        for (int i = 0; i < contenu.size(); i++) {
            prixTotal +=  contenu.getJsonObject(i).getInt("prix");
        }
        return prixTotal;
    }
}
