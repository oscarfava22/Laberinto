package com.example.oscar.laberinto;

/**
 * Created by oscar on 18/02/2018.
 */

public class JsonManager {
    /**
    public static void generarFitxer(){

        try {
            Gson gson = new Gson();

            String json = "{\"Usuaris\":";

            json += gson.toJson(menu.ranking.array);

            json += gson.toJson(menu.ranking.usuariActual);

            json += "}";
        }catch ()

    }

    public static void llegirFitxer(){

        JsonParser parser = new JsonParser();
        try {

            FileReader fr = newFileReader("path.json");

            JsonElement jsonElement = parser.parse(fr);

            JsonObject dades = (JsonObject) jsonElement;
            Gson gson = new Gson();

            for(Usuari usuari: array){
            menu.ranking.array.add(gson.fromJson(dades.getAsJsonArray("Usuaris"), Usuari[].class));
             }
        }catch(FileNotFoundException e){

            throw new FileNotFoundException("Error al carregar el fitxer .");

        }catch(JsonSyntaxException e){

            System.err.println("Error en la sintaxis de json");
        }catch (ClassCastException e){

            System.err.println("Possiblement, el fitxer no te dades");
        }
    }
         **/
}
