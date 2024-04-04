package fr.univamu.iut.commande.service;

import java.util.ArrayList;
import jakarta.json.JsonArray;

public class JsonArrayToArrayListConverter {
    public static ArrayList<String> convert(JsonArray array){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            arrayList.add(array.getString(i));
        }
        return arrayList;
    }
}
