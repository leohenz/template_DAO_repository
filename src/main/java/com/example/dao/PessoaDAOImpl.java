package com.example.dao;

import com.example.model.Pessoa;
import com.example.model.UsuarioComum;
import com.example.model.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.banco.conexaoBanco;

public class PessoaDAOImpl implements PessoaDAO {

    @Override
    public Pessoa buscaPorEmail(String email) {
        String consulta = "SELECT nome, email, senha, tipo_usuario FROM BD_usuario WHERE email = ?";
        try (Connection conexao = conexaoBanco.getConnection();
                PreparedStatement comandoSQL = conexao.prepareStatement(consulta)) {

            comandoSQL.setString(1, email);
            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                String nome = resultado.getString("nome");
                String senha = resultado.getString("senha");
                String tipoUsuario = resultado.getString("tipo_usuario");

                if ("comum".equalsIgnoreCase(tipoUsuario)) {
                    return new UsuarioComum(nome, email, senha, tipoUsuario);
                } else if ("bibliotecario".equalsIgnoreCase(tipoUsuario)) {
                    return new Bibliotecario(nome, email, senha, tipoUsuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void salvar(Pessoa pessoa) {
        String consulta = "INSERT INTO BD_usuario (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";
        try (Connection conexao = conexaoBanco.getConnection();
                PreparedStatement comandoSQL = conexao.prepareStatement(consulta)) {

            comandoSQL.setString(1, pessoa.getNome());
            comandoSQL.setString(2, pessoa.getEmail());
            comandoSQL.setString(3, pessoa.getSenha());
            comandoSQL.setString(4, pessoa.getTipoUsuario());

            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override

    public boolean registrarUsuario(Pessoa pessoa) {
        String consulta = "INSERT INTO BD_usuario (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conexao = conexaoBanco.getConnection();
                PreparedStatement comandoSQL = conexao.prepareStatement(consulta)) {

            comandoSQL.setString(1, pessoa.getNome());
            comandoSQL.setString(2, pessoa.getEmail());
            comandoSQL.setString(3, pessoa.getSenha());

            comandoSQL.setString(4, pessoa.getTipoUsuario()); // Usar o tipo de usuário da pessoa

            int resultado = comandoSQL.executeUpdate();
            return resultado > 0; // Retorna true se a inserção foi bem-sucedida

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
