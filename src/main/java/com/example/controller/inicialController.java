package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import com.example.App;
import com.example.dao.LivroDAO;
import com.example.dao.LivroDAOimpl;
import com.example.dao.PessoaDAOImpl;
import com.example.model.Livro;
import com.example.util.IdUtil;

import java.io.IOException;
import java.util.Set;

public class inicialController {
    @FXML
    private Label nomeLabel;
    @FXML
    private ImageView imagemLivro1;
    @FXML
    private Label textoLivro1;
    @FXML
    private ImageView imagemLivro2;
    @FXML
    private Label textoLivro2;
    @FXML
    private TextField campoPesquisa;

    private LivroDAO livroDAO;

    public inicialController() {
        this.livroDAO = new LivroDAOimpl();
    }

    @FXML
    private void initialize() {

        try {
            Set<Integer> idAleatorios = IdUtil.gerarIdAleatorios(2, 4);
            Integer[] ids = idAleatorios.toArray(new Integer[0]);

            Livro livro1 = livroDAO.buscarLivroPorId(ids[0]);
            if (livro1 != null) {
                imagemLivro1.setImage(new Image(livro1.getImagemUrl()));
                textoLivro1.setText(livro1.getTitulo());
            }
            Livro livro2 = livroDAO.buscarLivroPorId(ids[1]);
            if (livro2 != null) {
                imagemLivro2.setImage(new Image(livro2.getImagemUrl()));
                textoLivro2.setText(livro2.getTitulo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irParaLivro(ActionEvent event) throws IOException {
        App.setRoot("inicial");
    }

    @FXML
    private void buscar(ActionEvent event) {
        // pesquisa
    }

    @FXML
    private void verEmprestimos(ActionEvent event) {
        // ver empréstimos
    }

    @FXML
    private void editarConta(ActionEvent event) {
        // editar conta
    }
}
