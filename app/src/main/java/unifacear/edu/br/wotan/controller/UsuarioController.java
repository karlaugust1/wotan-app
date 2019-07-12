package unifacear.edu.br.wotan.controller;

import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import unifacear.edu.br.wotan.model.Estudante;

import static unifacear.edu.br.wotan.MainActivity.ROOT_URL;

public class UsuarioController {

    public Estudante login(Estudante student) {

        StringBuffer jsonString = new StringBuffer();

        try {

            URL url = new URL(ROOT_URL + "usuarios/estudante/login");

            System.out.println(url);

            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            String line;

            uc.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            uc.setRequestMethod("POST");
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setInstanceFollowRedirects(false);
            uc.connect();
            OutputStreamWriter writer = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");
            writer.write(new Gson().toJson(student));
            writer.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            while ((line = br.readLine()) != null) {
                jsonString.append(line + " ");
            }
            br.close();
            uc.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(jsonString.toString() == ""){
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        Estudante estudante = null;
        try {
            node = mapper.readTree(jsonString.toString());
            node = node.get("estudante");
            if (node == null) {
                return null;
            }
            estudante = mapper.readValue(node.traverse(), new TypeReference<Estudante>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudante;
    }

}