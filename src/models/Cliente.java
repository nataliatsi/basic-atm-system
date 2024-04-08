package models;

import models.strategy.account.Conta;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String username;
    private String senha;
    private List<Conta> contas;

    public Cliente(String username, String senha) {
        this.username = username;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public String getSenha() {
        return senha;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", contas=" + contas +
                '}';
    }
}
