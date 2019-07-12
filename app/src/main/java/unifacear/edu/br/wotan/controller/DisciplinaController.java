package unifacear.edu.br.wotan.controller;

import android.os.AsyncTask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import unifacear.edu.br.wotan.model.Disciplina;

import static unifacear.edu.br.wotan.MainActivity.ROOT_URL;

public class DisciplinaController extends AsyncTask<Void, Void, List<Disciplina>> {

    public DisciplinaController() {
    }

    @Override
    protected List<Disciplina> doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL( ROOT_URL + "disciplinas");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next() + " ");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(resposta.toString() == ""){
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            node = mapper.readTree(resposta.toString());
            node = node.get("disciplinas");
            disciplinas = mapper.readValue(node.traverse(), new TypeReference<List<Disciplina>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return disciplinas;

    }
}