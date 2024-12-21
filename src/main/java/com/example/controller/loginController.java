package com.example.controller;

import com.example.App;
import com.example.dao.PessoaDAO;
import com.example.dao.PessoaDAOImpl;
import com.example.model.Pessoa;
import com.example.model.UsuarioComum;
import com.example.model.Bibliotecario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class loginController {
    @FXML
    private Button botaoEntrar;
    @FXML
    private Hyperlink linkCadastro;
    @FXML
    private ImageView imagemLogo;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoSenha;

    private static Pessoa usuarioLogado;
    private PessoaDAO pessoaDAO;

    public loginController() {
        this.pessoaDAO = new PessoaDAOImpl();
    }

    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    @FXML
    private void initialize() {
        botaoEntrar.setDisable(true);

        campoEmail.textProperty().addListener((observable, oldValue, newValue) -> verificarCampos());
        campoSenha.textProperty().addListener((observable, oldValue, newValue) -> verificarCampos());
    }

    private void verificarCampos() {
        boolean todosPreenchidos = !campoEmail.getText().isEmpty() && !campoSenha.getText().isEmpty();
        botaoEntrar.setDisable(!todosPreenchidos);
    }

    @FXML
    private void login() throws IOException {
        String email = campoEmail.getText();
        String senha = campoSenha.getText();

        Pessoa pessoa = pessoaDAO.buscaPorEmail(email);
        if (pessoa != null && pessoa.getSenha().equals(senha)) {
            usuarioLogado = pessoa;
            App.setRoot("inicial");
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    @FXML
    private void irParaCadastro() throws IOException {
        App.setRoot("cadastro");
    }

    @FXML
    private void recuperaSenha() throws IOException {
        App.setRoot("login");
    }
}
