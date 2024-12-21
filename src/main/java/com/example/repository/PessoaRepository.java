package com.example.repository;

import com.example.dao.PessoaDAO;
import com.example.dao.PessoaDAOImpl;
import com.example.model.Pessoa;

public class PessoaRepository {
    private PessoaDAO pessoaDAO;

    public PessoaRepository() {
        this.pessoaDAO = new PessoaDAOImpl();
    }

    public Pessoa buscaPorEmail(String email) {
        return pessoaDAO.buscaPorEmail(email);
    }

    public void salvar(Pessoa pessoa) {
        pessoaDAO.salvar(pessoa);
    }
}
