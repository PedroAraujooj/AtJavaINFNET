package infnet.pedroVeira.banco.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
}
