package infnet.pedroVeira.banco.models;

public class Cliente {

    private String nome;
    private Double salarioMensal = 0.0;
    private String cpf;

    private Endereco endereco;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, Double salarioMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
        this.cpf = cpf;
    }
    public Cliente(String cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
