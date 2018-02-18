package com.example.oscar.laberinto;

/**
 * Created by oscar on 18/02/2018.
 */

public class JsonManager {
    /**
    public static void generarFitxer(){

        try {
            Gson gson = new Gson();

            String json = "{\"videos\":";

            json += gson.toJson(DadesPreferits.videos_aux);

            json += ",\"channels\":";

            json += gson.toJson(DadesPreferits.channels_aux);

            json += ",\"playlists\":";

            json += gson.toJson(DadesPreferits.playLists_aux);

            json += "}";
        }catch ()

    }

    public static void llegirFitxer(){

        JsonParser parser = new JsonParser(); // tipus parser per obtenir el format desitjat
        try {
            //cargo el fitxero amb la classe fileReader, busco en el relative path
            FileReader fr = newFileReader("jsonFiles/favouriteResults.json");

            JsonElement jsonElement = parser.parse(fr); //per a passar a format json de tipus element usant el "parse"

            JsonObject dades = (JsonObject) jsonElement; //vull anar parsejant array a array

            Gson gson = new Gson(); // crear gson per tractar automaticament el JsonElement

            //agafarem un array auxiliar de videos per carregar tota l'estructura i despres passar un a un el video a l'arrayList
            DadesPreferits.introduirInfo(gson.fromJson(dades.getAsJsonArray("videos"), Video[].class), 1); // carreguem tota la estructura
            DadesPreferits.introduirInfo(gson.fromJson(dades.getAsJsonArray("channels"), Channel[].class), 2);
            DadesPreferits.introduirInfo(gson.fromJson(dades.getAsJsonArray("playlists"), PlayList[].class), 3);

        }catch(FileNotFoundException e){

            throw new FileNotFoundException("Error al carregar el fitxer de preferits.");

        }catch(JsonSyntaxException e){

            System.err.println("Error en la sintaxis de json");
        }catch (ClassCastException e){

            System.err.println("Possiblement, el fitxer no te dades i no podras fer un cast de cap element");
        }
    }
         **/
}
