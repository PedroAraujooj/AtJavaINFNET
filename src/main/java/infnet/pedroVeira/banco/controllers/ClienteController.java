package infnet.pedroVeira.banco.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import infnet.pedroVeira.banco.DTOs.ClienteDTO;
import infnet.pedroVeira.banco.models.Cliente;
import infnet.pedroVeira.banco.services.ClienteService;
import infnet.pedroVeira.banco.services.EnderecoService;
import spark.Route;

public class ClienteController {
    public static Route getCliente = ((request, response) -> {
        String cpf = request.params("cpf");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(ClienteService.getCliente(cpf));
    }
    );
    public static Route deleteCliente = ((request, response) -> {
        String cpf = request.params("cpf");
        ClienteService.deleteCliente(cpf);
        return "Cliente com o CPF " + cpf + " foi deletado.";
    }
    );
    public static Route cadastrarCliente = ((request, response) -> {
        ObjectMapper mapper = new ObjectMapper();
        ClienteDTO clienteDTO = mapper.readValue(request.body(), ClienteDTO.class);
        Cliente cliente = new Cliente(clienteDTO.nome(), clienteDTO.cpf(), clienteDTO.salarioMensal());
        cliente.setEndereco(EnderecoService.getEnderecoByCep(clienteDTO.cep()));
        return mapper.writeValueAsString(ClienteService.cadastrarCliente(cliente));
    }
    );
    public static Route cadastrarClienteCpf = ((request, response) -> {
        String cpf = request.params("cpf");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(ClienteService.cadastrarCliente(cpf));
    }
    );
}
