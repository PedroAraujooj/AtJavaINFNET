package infnet.pedroVeira.banco.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import infnet.pedroVeira.banco.DTOs.ClienteDTO;
import infnet.pedroVeira.banco.DTOs.ValorDTO;
import infnet.pedroVeira.banco.models.Cliente;
import infnet.pedroVeira.banco.services.ClienteService;
import infnet.pedroVeira.banco.services.ContaCorrenteService;
import spark.Route;

public class ContaCorrenteController {
    public static Route getConta = ((request, response) -> {
        Integer num = Integer.valueOf(request.params("num"));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(ContaCorrenteService.getConta(num));
    }
    );
    public static Route deleteConta = ((request, response) -> {
        Integer num = Integer.valueOf(request.params("num"));
        ContaCorrenteService.deleteConta(num);
        return "A conta corrente de número " + num + " foi deletada.";
    }
    );
    public static Route cadastrarConta = ((request, response) -> {
        Integer num = Integer.valueOf(request.params("num"));
        String cpf = request.params("cpf");
        ObjectMapper mapper = new ObjectMapper();
        Cliente cliente = ClienteService.getCliente(cpf);
        return mapper.writeValueAsString(ContaCorrenteService.cadastrarConta(cliente, num));}
    );
    public static Route transferir = ((request, response) -> {
        Integer num1 = Integer.valueOf(request.params("num1"));
        Integer num2 = Integer.valueOf(request.params("num2"));
        ObjectMapper mapper = new ObjectMapper();
        ValorDTO valorDTO = mapper.readValue(request.body(), ValorDTO.class);
        ContaCorrenteService.fazerTransferencia(ContaCorrenteService.getConta(num1),ContaCorrenteService.getConta(num2), valorDTO.valor());
        return "Transferencia feita";
    }
    );
    public static Route depositar = ((request, response) -> {
        Integer num = Integer.valueOf(request.params("num"));
        ObjectMapper mapper = new ObjectMapper();
        ValorDTO valorDTO = mapper.readValue(request.body(), ValorDTO.class);
        ContaCorrenteService.getConta(num).depositar(valorDTO.valor());
        return "Transação feita";
    }
    );public static Route sacar = ((request, response) -> {
        Integer num = Integer.valueOf(request.params("num"));
        ObjectMapper mapper = new ObjectMapper();
        ValorDTO valorDTO = mapper.readValue(request.body(), ValorDTO.class);
        ContaCorrenteService.getConta(num).sacar(valorDTO.valor());
        return "Transação feita";
    }
    );
}
