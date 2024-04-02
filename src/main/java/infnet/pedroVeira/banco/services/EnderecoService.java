package infnet.pedroVeira.banco.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import infnet.pedroVeira.banco.models.ContaCorrente;
import infnet.pedroVeira.banco.models.Endereco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class EnderecoService {

    public static Endereco getEnderecoByCep(String cep) throws IOException {
        String url ="https://viacep.com.br/ws/" + cep + "/json";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                responseBuilder.append(line);
            }
            reader.close();

            ObjectMapper mapper = new ObjectMapper();
            String json = responseBuilder.toString();
            return mapper.readValue(json, Endereco.class);
        }else{
            return null;
        }
    }
}
