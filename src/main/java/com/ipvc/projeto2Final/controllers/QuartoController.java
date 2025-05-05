package com.ipvc.projeto2Final.controllers;

import com.ipvc.projeto2Final.models.Quarto;
import com.ipvc.projeto2Final.services.QuartoService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartoController {

    @FXML private TableView<Quarto> tabelaQuartos;
    @FXML private TableColumn<Quarto, String> colNumero;
    @FXML private TableColumn<Quarto, String> colTipo;
    @FXML private TableColumn<Quarto, String> colStatus;
    @FXML private TableColumn<Quarto, String> colPreco;
    @FXML private Button btnNovoQuarto;

    @Autowired private QuartoService quartoService;

    private ObservableList<Quarto> quartos;

    @FXML
    public void initialize() {
        carregarDados();
        configurarColunas();
    }

    private void carregarDados() {
        quartos = FXCollections.observableArrayList(quartoService.getAllQuartos());
        tabelaQuartos.setItems(quartos);
    }

    private void configurarColunas() {
        colNumero.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getNumero()))
        );

        colTipo.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getTipo() != null ?
                                String.valueOf(cellData.getValue().getTipo().getIdtipo()) :
                                "Sem Tipo"
                )
        );

        colStatus.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(cellData.getValue().getStatus())
        );

        colPreco.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getPreco() != null ?
                                cellData.getValue().getPreco().toPlainString() :
                                "0.00"
                )
        );
    }

    @FXML
    private void handleNovoQuarto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Novo Quarto");
        alert.setHeaderText(null);
        alert.setContentText("Funcionalidade ainda em desenvolvimento.");
        alert.showAndWait();
    }
}
