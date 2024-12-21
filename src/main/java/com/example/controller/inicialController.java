package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import com.example.App;
import com.example.model.Pessoa;
import com.example.controller.loginController;

public class inicialController {
    @FXML
    private ImageView imagem1;
    @FXML
    private ImageView imagem2;
    @FXML
    private ImageView imagem3;
    @FXML
    private ImageView imagem4;
    @FXML
    private ImageView imagem5;
    @FXML
    private ImageView imagem6;
    @FXML
    private TextField campoBusca;
    @FXML
    private Hyperlink linkEmprestimo;
    @FXML
    private Hyperlink linkEditarConta;
    @FXML
    private Label nomeLabel;

    @FXML
    private void initialize() {
        nomeLabel.setText("Bem-vindo, " + loginController.getUsuarioLogado().getNome());
    }

    @FXML
    private void buscar(ActionEvent event) {
        // Implementação da ação de pesquisa
    }

    @FXML
    private void verEmprestimos(ActionEvent event) {
        // Implementação da ação de ver empréstimos
    }

    @FXML
    private void editarConta(ActionEvent event) {
        // Implementação da ação de editar conta
    }
}
