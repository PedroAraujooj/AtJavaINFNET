package infnet.pedroVeira.banco.services;


import infnet.pedroVeira.banco.models.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteService {
    private static Map<String, Cliente> clientes = new HashMap<>();

    public static Cliente cadastrarCliente(String nome, String cpf, Double salario){
        clientes.put(cpf,new Cliente(nome, cpf, salario));
        return clientes.get(cpf);
    }

    public static Cliente cadastrarCliente(String cpf){
        clientes.put(cpf, new Cliente(cpf));
        return clientes.get(cpf);
    }
    public static Cliente cadastrarCliente(Cliente cliente){
        clientes.put(cliente.getCpf(), cliente);
        return cliente;
    }
    public static Cliente getCliente( String cpf){
        return clientes.get(cpf);
    }

    public static void deleteCliente(String cpf){
        clientes.remove(cpf);
    }


}
