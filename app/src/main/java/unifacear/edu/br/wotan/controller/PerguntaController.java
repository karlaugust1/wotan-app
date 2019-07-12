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

import unifacear.edu.br.wotan.MainActivity;
import unifacear.edu.br.wotan.fragment.PerguntasFragment;
import unifacear.edu.br.wotan.model.Pergunta;

import static unifacear.edu.br.wotan.MainActivity.ROOT_URL;

public class PerguntaController extends AsyncTask<Long, Void, List<Pergunta>> {

    public PerguntaController() {
    }

    @Override
    protected List<Pergunta> doInBackground(Long... longs) {

        StringBuilder resposta = new StringBuilder();

        try {
            URL url = null;
            if(longs.length == 0){
                url = new URL(ROOT_URL + "perguntas/estudante/" + MainActivity.estudante.getId() + "/false");
            } else {
                url = new URL(ROOT_URL + "perguntas/disciplina/" + longs[0] + "/estudante/" + MainActivity.estudante.getId() + "/false");
            }

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
        List<Pergunta> perguntas = new ArrayList<>();
        try {
            node = mapper.readTree(resposta.toString());
            node = node.get("perguntas");
            perguntas = mapper.readValue(node.traverse(), new TypeReference<List<Pergunta>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return perguntas;

//        Alternativa alternativa = new Alternativa(1L,
//                "Enfia no cu os ingredientes e rebola",
//                false,
//                1L);
//        Alternativa alternativa2 = new Alternativa(1L,
//                "Enfia no cu os ingredientes e rebola",
//                true,
//                1L);
//        Pergunta pergunta = new Pergunta(1L,
//                "Como fazer bolo de cenoura?",
//               "02/06/2019 14:26",
//                "17/12/2019 02:00",
//                6.0,
//                true,
//                true,
//                1L,
//                "Camada OSI", new ArrayList<Alternativa>());
//
//        return new ArrayList<>(Arrays.asList(pergunta));


    }
}
