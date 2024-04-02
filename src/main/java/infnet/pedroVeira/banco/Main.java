package infnet.pedroVeira.banco;

import infnet.pedroVeira.banco.controllers.ClienteController;
import infnet.pedroVeira.banco.controllers.ContaCorrenteController;
import infnet.pedroVeira.banco.controllers.EnderecoController;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.port(8080);
        System.out.println("Hello world!");

        Spark.get("/cliente/:cpf", ClienteController.getCliente );
        Spark.delete("/cliente/:cpf", ClienteController.deleteCliente );
        Spark.post("/cliente/", ClienteController.cadastrarCliente );
        Spark.post("/cliente/:cpf", ClienteController.cadastrarClienteCpf );

        Spark.get("/conta-corrente/:num", ContaCorrenteController.getConta );
        Spark.delete("/conta-corrente/:num", ContaCorrenteController.deleteConta );
        Spark.post("/conta-corrente/:num/:cpf", ContaCorrenteController.cadastrarConta );
        Spark.put("/conta-corrente/:num1/:num2/transferir", ContaCorrenteController.transferir );
        Spark.put("/conta-corrente/:num/depositar", ContaCorrenteController.depositar );
        Spark.put("/conta-corrente/:num/sacar", ContaCorrenteController.sacar );

        Spark.get("endereco/:cep", EnderecoController.getEnderecoByCep);
    }
}