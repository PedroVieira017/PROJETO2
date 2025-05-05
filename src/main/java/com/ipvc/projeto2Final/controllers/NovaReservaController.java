package com.ipvc.projeto2Final.controllers;

import com.ipvc.projeto2Final.models.*;
import com.ipvc.projeto2Final.services.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

@Component
public class NovaReservaController {

    @FXML private ComboBox<Hospede> comboHospede;
    @FXML private ComboBox<Quarto> comboQuarto;
    @FXML private DatePicker dataCheckIn;
    @FXML private DatePicker dataCheckOut;
    @FXML private Button btnGuardar;

    @Autowired private HospedeService hospedeService;
    @Autowired private QuartoService quartoService;
    @Autowired private ReservaService reservaService;
    @Autowired private ReservaquartoService reservaquartoService;
    @Autowired private GerenteService gerenteService;

    private Reserva reservaParaEditar;

    @FXML
    public void initialize() {
        comboHospede.getItems().addAll(hospedeService.getAllHospedes());
        comboQuarto.getItems().addAll(quartoService.getAllQuartosDisponiveis());
    }

    @FXML
    private void handleGuardar() {
        Hospede hospede = comboHospede.getValue();
        Quarto quarto = comboQuarto.getValue();
        Date checkin = Date.from(dataCheckIn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date checkout = Date.from(dataCheckOut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (hospede == null || quarto == null || checkin == null || checkout == null) {
            showAlert(Alert.AlertType.WARNING, "Preenche todos os campos obrigatórios.");
            return;
        }

        Gerente gerente = gerenteService.getAllGerentes().stream().findFirst().orElse(null);
        if (gerente == null) {
            showAlert(Alert.AlertType.ERROR, "Nenhum gerente disponível.");
            return;
        }

        long dias = (checkout.getTime() - checkin.getTime()) / (1000 * 60 * 60 * 24);
        BigDecimal precoTotal = quarto.getPreco().multiply(BigDecimal.valueOf(Math.max(dias, 1)));

        if (reservaParaEditar == null) {
            Reserva reserva = new Reserva();
            reserva.setHospede(hospede);
            reserva.setGerente(gerente);
            reserva.setDatacheckin(checkin);
            reserva.setDatacheckout(checkout);
            reserva.setStatus("Ativa");
            reserva.setPrecototal(precoTotal);

            Reserva reservaCriada = reservaService.save(reserva);

            Reservaquarto rq = new Reservaquarto(reservaCriada, quarto);
            reservaquartoService.saveReservaquarto(rq);

            quarto.setStatus("Reservado");
            quartoService.save(quarto);

        } else {
            reservaParaEditar.setHospede(hospede);
            reservaParaEditar.setDatacheckin(checkin);
            reservaParaEditar.setDatacheckout(checkout);
            reservaParaEditar.setPrecototal(precoTotal);
            reservaService.save(reservaParaEditar);
        }

        showAlert(Alert.AlertType.INFORMATION, "Reserva guardada com sucesso!");
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }

    public void setReservaParaEditar(Reserva reserva) {
        this.reservaParaEditar = reserva;
        comboHospede.setValue(reserva.getHospede());
        dataCheckIn.setValue(reserva.getDatacheckin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        dataCheckOut.setValue(reserva.getDatacheckout().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

