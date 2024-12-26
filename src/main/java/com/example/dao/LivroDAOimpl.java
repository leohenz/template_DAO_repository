package com.example.dao;

import com.example.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.banco.conexaoBanco;

public class LivroDAOimpl implements LivroDAO {

    public Livro buscarLivroPorId(int id) {
        String query = "SELECT titulo, autor, ano_publicacao, disponivel, imagem_url FROM BD_livro WHERE livro_id_pk = ?";
        try (Connection connection = conexaoBanco.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int ano = resultSet.getInt("ano_publicacao");
                boolean disponivel = resultSet.getBoolean("disponivel");
                String imagemUrl = resultSet.getString("imagem_url");

                return new Livro(titulo, autor, ano, disponivel, imagemUrl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void inserirLivro(Livro livro) {
        String query = "INSERT INTO BD_livro (titulo, autor, ano_publicacao, disponivel, imagem_url) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = conexaoBanco.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno());
            preparedStatement.setBoolean(4, livro.isDisponivel());
            preparedStatement.setString(5, livro.getImagemUrl());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
