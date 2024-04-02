package infnet.pedroVeira.banco.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import infnet.pedroVeira.banco.DTOs.ClienteDTO;
import infnet.pedroVeira.banco.models.Cliente;
import infnet.pedroVeira.banco.models.Endereco;
import infnet.pedroVeira.banco.services.ClienteService;
import infnet.pedroVeira.banco.services.ContaCorrenteService;
import infnet.pedroVeira.banco.services.EnderecoService;
import spark.Route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class EnderecoController {
    public static Route getEnderecoByCep = ((request, response) -> {
        String cep = request.params("cep");
        Endereco endereco =EnderecoService.getEnderecoByCep(cep);
        if(endereco != null){
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(endereco);
        }else{
            return "Endereço não localizado";
        }
    }
    );
}
