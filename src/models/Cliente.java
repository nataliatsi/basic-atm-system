package models;

import models.strategies.contas.Conta;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private long numDaConta;
    private ArrayList<Conta> contas;

    public Cliente(String nome, String cpf, String endereco, String telefone, long numDaConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numDaConta =  numDaConta;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getNumDaConta() {
        return numDaConta;
    }

    public void setNumDaConta(long numDaConta) {
        this.numDaConta = numDaConta;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nome).append(", CPF: ").append(cpf).append("\n");
        sb.append("Endereço: ").append(endereco).append(", Telefone: ").append(telefone).append("\n");
        sb.append("Numero da Conta: ").append(numDaConta).append("\n");
        sb.append("Contas: \n");
        for (Conta conta : contas) {
            sb.append("- ").append(conta).append("\n");
        }
        return sb.toString();
    }

}

