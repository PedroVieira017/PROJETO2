package com.ipvc.projeto2Final.controllers;

import com.ipvc.projeto2Final.models.Hospede;
import com.ipvc.projeto2Final.services.HospedeService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospedeController {

    @FXML private TableView<Hospede> tabelaHospedes;
    @FXML private TableColumn<Hospede, String> colId;
    @FXML private TableColumn<Hospede, String> colNome;
    @FXML private TableColumn<Hospede, String> colEmail;
    @FXML private TableColumn<Hospede, String> colTelefone;
    @FXML private Button btnNovoHospede;

    @Autowired private HospedeService hospedeService;

    private ObservableList<Hospede> hospedes;

    @FXML
    public void initialize() {
        carregarDados();
        configurarColunas();
    }

    private void carregarDados() {
        hospedes = FXCollections.observableArrayList(hospedeService.getAllHospedes());
        tabelaHospedes.setItems(hospedes);
    }

    private void configurarColunas() {
        colId.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getIdhospede() != null ?
                                String.valueOf(cellData.getValue().getIdhospede()) :
                                "N/A"
                )
        );

        colNome.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getNome() != null ?
                                cellData.getValue().getNome() :
                                "Sem Nome"
                )
        );

        colEmail.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getEmail() != null ?
                                cellData.getValue().getEmail() :
                                "Sem Email"
                )
        );

        colTelefone.setCellValueFactory(cellData ->
                new ReadOnlyStringWrapper(
                        cellData.getValue().getTelefone() != null ?
                                cellData.getValue().getTelefone() :
                                "Sem Telefone"
                )
        );
    }

    @FXML
    private void handleNovoHospede() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Novo Hóspede");
        alert.setHeaderText(null);
        alert.setContentText("Funcionalidade ainda em desenvolvimento.");
        alert.showAndWait();
    }
}
