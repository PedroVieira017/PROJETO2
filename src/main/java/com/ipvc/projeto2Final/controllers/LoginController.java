package com.ipvc.projeto2Final.controllers;

import com.ipvc.projeto2Final.SpringFXMLLoader;
import com.ipvc.projeto2Final.models.Hospede;
import com.ipvc.projeto2Final.services.HospedeService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @Autowired
    private HospedeService hospedeService;

    @FXML
    private void handleLogin() {
        String email = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        hospedeService.findByEmail(email).ifPresentOrElse(h -> {
            if (h.getPassword().equals(password)) {
                abrirDashboard();
            } else {
                showAlert(Alert.AlertType.ERROR, "Password incorreta.");
            }
        }, () -> showAlert(Alert.AlertType.ERROR, "Utilizador não encontrado."));
    }

    private void abrirDashboard() {
        try {
            Parent root = springFXMLLoader.load("/dashboard.fxml");
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro ao abrir o dashboard.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
