package infnet.pedroVeira.banco.models;

public class Conta {
    private Cliente cliente;
    private Double saldo = 0.0;
    private Integer numeroConta;

    public Conta(Cliente cliente, Double saldo, Integer numeroConta) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public Conta() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }
}
