package infnet.pedroVeira.banco.services;

import infnet.pedroVeira.banco.models.Cliente;
import infnet.pedroVeira.banco.models.ContaCorrente;

import java.util.HashMap;
import java.util.Map;

public class ContaCorrenteService {
    private static Map<Integer, ContaCorrente> contas = new HashMap();

    public static ContaCorrente cadastrarConta(Cliente cliente, Integer num){
        contas.put(num, new ContaCorrente(cliente, num));
        return contas.get(num);
    }
    public static ContaCorrente getConta(Integer num){
        return contas.get(num);
    }
    public static void deleteConta(Integer num){
        contas.remove(num);
    }
    public static void fazerTransferencia(ContaCorrente cedende, ContaCorrente recebedor, Double valor){
        cedende.sacar(valor);
        recebedor.depositar(valor);
    }


}
