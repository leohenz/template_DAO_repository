package com.example.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.App;
import com.example.banco.conexaoBanco;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class loginController {

    @FXML
    private Button botton1;

    @FXML
    private ImageView image;

    @FXML
    private TextField field1;

    @FXML
    private Hyperlink botton3;

    @FXML
    private Hyperlink botton2;

    @FXML
    private TextField field2;

    @FXML
    private void initialize() {
        botton1.setDisable(true);

        field1.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        field2.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
    }

    private void checkFields() {
        boolean allFilled = !field1.getText().isEmpty() && !field2.getText().isEmpty();
        botton1.setDisable(!allFilled);
    }

    @FXML
    private void cadastro() throws IOException {
        App.setRoot("cadastro");
    }

    @FXML
    private void login() throws IOException {
        String email = field1.getText();
        String senha = field2.getText();

        if (verificarCredenciais(email, senha)) {
            // Autenticação bem-sucedida, redirecionar para a próxima tela
            App.setRoot("inicial");
        } else {
            // Exibir mensagem de erro
            System.out.println("Email ou senha incorretos.");
        }
    }

    private boolean verificarCredenciais(String email, String senha) {
        String query = "SELECT * FROM BD_usuario WHERE email = ? AND senha = ?";

        try (Connection connection = conexaoBanco.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Retorna true se as credenciais forem válidas

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void recuperaSenha() throws IOException {
        App.setRoot("login");
    }
}
