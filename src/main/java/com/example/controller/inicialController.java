package com.example.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.App;
import com.example.banco.conexaoBanco;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class inicialController {

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image3;

    @FXML
    private TextField field1;

    @FXML
    private ImageView image4;

    @FXML
    private Hyperlink buttonEmprestimo;

    @FXML
    private Hyperlink buttonEditarConta;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label textNome;

    @FXML
    private void initialize() {

    }
    
    @FXML
    private void Search() throws IOException {
        App.setRoot("inicial");
    }

    @FXML
    private void verEmprestimos() throws IOException {
        App.setRoot("inicial");
    }

    @FXML
    private void editarConta() throws IOException {
        App.setRoot("inicial");
    }
}
