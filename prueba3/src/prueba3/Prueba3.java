/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba3;

/**
 *
 * @author torre
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Lorena Barrios
 */
public class Prueba3 {

    /**
     * @param args the command line arguments
     */
    public static String consumoGetWebService() throws MalformedURLException, IOException {

       /**
         * Con la clase HttpURLConnection nos ayuda a hacer la conexion con el
         * WebService definiendo el tipo de metodo que se consumira GET, los
         * detalles de la cabezera del Request
         *
         */
        URL url = new URL("https://securetransfer.redsis.com/rest/forms/v1/teamGoAny/payload");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("GET");

        System.out.println("submitFormLink: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        /**Aqui se lee el response*/
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
            response.append(output);

        }
        in.close();
        // imprime el response en consola
        System.out.println("Response:-" + response.toString());
        String deploydJSON = response.toString();

        System.out.println("Token: " + deploydJSON.subSequence(78, 187));

        return deploydJSON.subSequence(78, 187).toString();
    }

    public static void consumePostWebService(String uriWithToken) throws MalformedURLException, IOException {
        /**
         * Con la clase HttpURLConnection nos ayuda a hacer la conexion con el
         * WebService definiendo el tipo de metodo que se consumira POST, los
         * detalles de la ebzera del Request
         *
         */
        String yourURLStr = java.net.URLEncoder.encode(uriWithToken, "UTF-8");
        //java.net.URL url = new java.net.URL(yourURLStr);
        //System.out.println("uriWithToken:-" + uriWithToken);
        URL url = new URL(uriWithToken);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"nombre\": \"ingresoRedsis\", \"apellido\": \"Qwerty0909$\"}";
        /*Aqui la cadana con el objeto JSON lo  traemos a un arreglo de bytes para escribirlo en el archivo*/
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        /**
         * las suiguientes lineas se lee el response para imprimirloen consola
         */
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        /* aqui primero consumiemos el GetWebService  lo cual nos regresara la uri con el token
    para despues si consumir PostWebService, asi se desplegara el response en consola**/
        String uri = consumoGetWebService();
        consumePostWebService(uri);
    }

}
