package com.example.dao;

import com.example.model.Pessoa;

public interface PessoaDAO {
    Pessoa buscaPorEmail(String email);

    void salvar(Pessoa pessoa);

    boolean registrarUsuario(Pessoa pessoa);
}
