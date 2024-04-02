package infnet.pedroVeira.banco.models;

public class ContaCorrente extends Conta{
    public static final Double SALARIOMIN = 1412.0;

    private Double limite = 0.0;


    public ContaCorrente(Cliente cliente, Integer numeroConta) {
        this.setCliente(cliente);
        this.setNumeroConta(numeroConta);
    }

    public void sacar(Double valor){
        if(this.getSaldo() >= valor && valor > 0){
            setSaldo(getSaldo() - valor);
        }
    }
    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
        }
    }

    private Double calcularLimite(){
        Double salarioMensal = getCliente().getSalarioMensal();
        if(salarioMensal < 2*SALARIOMIN){
            return salarioMensal;
        }
        else if(salarioMensal >= 2*SALARIOMIN &&  salarioMensal < 5*SALARIOMIN){
            return salarioMensal*2;
        }
        else {
            return salarioMensal*5;
        }
    }
}
