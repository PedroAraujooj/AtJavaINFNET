package infnet.pedroVeira.banco.models;

public class ContaCorrente extends Conta{
    public static final Double SALARIOMIN = 1412.0;
    private Double limite = 0.0;
    private Double investimentos  = 0.0;


    public ContaCorrente(Cliente cliente, Integer numeroConta) {
        this.setCliente(cliente);
        this.setNumeroConta(numeroConta);
    }
    public void addInvestimento(Double investimento){
        this.investimentos += investimento * 1.2;
    }
    private Double calcularLimite(){
        Double salarioMensal = getCliente().getSalarioMensal();
        if(salarioMensal < 2*SALARIOMIN){
            limite = salarioMensal;
            return limite;
        }
        else if(salarioMensal >= 2*SALARIOMIN &&  salarioMensal < 5*SALARIOMIN){
            limite = salarioMensal*2;
            return limite;
        }
        else {
            limite = salarioMensal*5;
            return limite;
        }
    }
}
