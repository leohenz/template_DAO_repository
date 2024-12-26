package com.example.dao;

import com.example.model.Livro;

public interface LivroDAO {
    Livro buscarLivroPorId(int id);

    void inserirLivro(Livro livro);
}
