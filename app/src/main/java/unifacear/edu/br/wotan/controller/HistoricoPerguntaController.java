package unifacear.edu.br.wotan.controller;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import unifacear.edu.br.wotan.model.HistoricoPergunta;

import static unifacear.edu.br.wotan.MainActivity.ROOT_URL;

public class HistoricoPerguntaController {

    public Void save(HistoricoPergunta historicoPergunta) {

        StringBuffer jsonString = new StringBuffer();

        try {

            URL url = new URL(ROOT_URL + "historico-pergunta");

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
            writer.write(new Gson().toJson(historicoPergunta));
            writer.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            br.close();
            uc.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}