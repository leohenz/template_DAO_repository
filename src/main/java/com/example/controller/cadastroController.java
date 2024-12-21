package com.example.controller;

import com.example.App;
import com.example.dao.PessoaDAO;
import com.example.dao.PessoaDAOImpl;
import com.example.model.Pessoa;
import com.example.model.UsuarioComum;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import java.io.IOException;

public class cadastroController {

    @FXML
    private Hyperlink linkVoltar;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button botaoCriarConta;

    private PessoaDAO pessoaDAO;

    public cadastroController() {
        this.pessoaDAO = new PessoaDAOImpl();
    }

    @FXML
    private void initialize() {
        botaoCriarConta.setDisable(true);

        campoNome.textProperty().addListener((observable, oldValue, newValue) -> verificarCampos());
        campoEmail.textProperty().addListener((observable, oldValue, newValue) -> verificarCampos());
        campoSenha.textProperty().addListener((observable, oldValue, newValue) -> verificarCampos());
    }

    private void verificarCampos() {
        boolean todosPreenchidos = !campoNome.getText().isEmpty() && !campoEmail.getText().isEmpty()
                && !campoSenha.getText().isEmpty();
        botaoCriarConta.setDisable(!todosPreenchidos);
    }

    @FXML
    private void criarConta() throws IOException {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String senha = campoSenha.getText();
        Pessoa novoUsuario = new UsuarioComum(nome, email, senha, "comum");
        boolean registrado = pessoaDAO.registrarUsuario(novoUsuario);

        if (registrado) {
            System.out.println("Usuário cadastrado com sucesso!");
            App.setRoot("login");
        } else {
            System.out.println("Erro ao cadastrar usuário.");
        }
    }

    @FXML
    private void voltarParaLogin() throws IOException {
        App.setRoot("login");
    }
}
