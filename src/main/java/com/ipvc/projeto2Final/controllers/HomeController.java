package com.ipvc.projeto2Final.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class HomeController {

    @FXML
    private void handleReservas(ActionEvent event) {
        abrirJanela("/reservas.fxml", "Gestão de Reservas");
    }

    @FXML
    private void handleRelatorios(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Relatórios", "Funcionalidade ainda em desenvolvimento.");
    }

    @FXML
    private void handleDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao abrir a Dashboard.");
        }
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void abrirJanela(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) root.lookup(".scene")).getScene().getWindow();
            stage.getScene().setRoot(root);
            stage.setTitle(titulo);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao abrir a janela: " + titulo);
        }
    }

    private void showAlert(Alert.AlertType alertType, String titulo, String mensagem) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Mensagem");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
