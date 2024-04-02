package infnet.pedroVeira.banco.DTOs;

import infnet.pedroVeira.banco.models.Endereco;

public record ClienteDTO( String nome,
                          Double salarioMensal,
                          String cpf,
                          String cep) {
}
