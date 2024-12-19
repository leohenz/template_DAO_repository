package com.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.App;
import com.example.banco.conexaoBanco;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class cadastroController {

    @FXML
    private Button botton1;

    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private TextField field3;

    @FXML
    private void initialize() {
        botton1.setDisable(true);

        field1.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        field2.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        field3.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
    }

    private void checkFields() {
        boolean allFilled = !field1.getText().isEmpty() && !field2.getText().isEmpty() && !field3.getText().isEmpty();
        botton1.setDisable(!allFilled);
    }

    @FXML
    private void criarConta() throws IOException {
        String nome = field1.getText();
        String email = field2.getText();
        String senha = field3.getText();

        if (registrarUsuario(nome, email, senha)) {
            // Registro bem-sucedido, redirecionar para a tela de login
            App.setRoot("login");
        } else {
            // Exibir mensagem de erro
            System.out.println("Erro ao criar conta. Tente novamente.");
        }
    }

    private boolean registrarUsuario(String nome, String email, String senha) {
        String query = "INSERT INTO BD_usuario (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, 'comum')";

        try (Connection connection = conexaoBanco.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);

            int result = preparedStatement.executeUpdate();
            return result > 0; // Retorna true se a inserção foi bem-sucedida

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void voltarLogin() throws IOException {
        App.setRoot("login");
    }
}
