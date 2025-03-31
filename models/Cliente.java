package models;

import annotations.CPFValido;
import annotations.NomeUnico;
import annotations.CampoObrigatorio;

public class Cliente {
    @CPFValido
    private String cpf;

    @NomeUnico
    private String nome;

    @CampoObrigatorio
    private String endereco;

    public Cliente(String cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

	public Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters e Setters
}
