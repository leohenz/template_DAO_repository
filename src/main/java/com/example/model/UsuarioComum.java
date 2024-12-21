package com.example.model;

public class UsuarioComum extends Pessoa {

    public UsuarioComum(String nome, String email, String senha, String tipoUsuario) {
        super(nome, email, senha, "comum");
    }
}
