package com.ipvc.projeto2Final.controllers;

import com.ipvc.projeto2Final.models.Reserva;
import com.ipvc.projeto2Final.models.Hospede;
import com.ipvc.projeto2Final.models.Reservaquarto;
import com.ipvc.projeto2Final.services.ReservaService;
import com.ipvc.projeto2Final.services.ReservaquartoService;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ReservaController {

    @FXML private TableView<Reserva> tabelaReservas;
    @FXML private TableColumn<Reserva, String> colHospede;
    @FXML private TableColumn<Reserva, String> colQuarto;
    @FXML private TableColumn<Reserva, String> colData;
    @FXML private TableColumn<Reserva, Void> colEditar;
    @FXML private TableColumn<Reserva, Void> colCancelar;
    @FXML private Button btnNovaReserva;

    @Autowired private ReservaService reservaService;
    @Autowired private ReservaquartoService reservaquartoService;

    private ObservableList<Reserva> reservas;

    @FXML
    public void initialize() {
        carregarDados();
        configurarColunas();
    }

    private void carregarDados() {
        reservas = FXCollections.observableArrayList(reservaService.getAllReservas());
        tabelaReservas.setItems(reservas);
    }

    private void configurarColunas() {
        colHospede.setCellValueFactory(cellData -> {
            Hospede hospede = cellData.getValue().getHospede();
            return new ReadOnlyStringWrapper(hospede != null ? hospede.getNome() : "Desconhecido");
        });

        colQuarto.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            Optional<Reservaquarto> rq = reservaquartoService.findByReserva(reserva);
            return new ReadOnlyStringWrapper(
                    rq.map(r -> String.valueOf(r.getQuarto().getNumero())).orElse("N/A")
            );
        });

        colData.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(
                cellData.getValue().getDatacheckin().toString())
        );

        colEditar.setCellFactory(col -> criarBotao("Editar", this::editarReserva));
        colCancelar.setCellFactory(col -> criarBotao("Cancelar", this::cancelarReserva));
    }

    private interface ReservaCallback {
        void execute(Reserva reserva);
    }

    private TableCell<Reserva, Void> criarBotao(String texto, ReservaCallback acao) {
        return new TableCell<>() {
            private final Button btn = new Button(texto);
            {
                btn.setOnAction(e -> {
                    Reserva reserva = getTableView().getItems().get(getIndex());
                    acao.execute(reserva);
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        };
    }

    private void editarReserva(Reserva reserva) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NovaReserva.fxml"));
            Parent root = loader.load();
            NovaReservaController controller = loader.getController();
            controller.setReservaParaEditar(reserva);

            Stage stage = new Stage();
            stage.setTitle("Editar Reserva");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            carregarDados();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro ao abrir editor de reserva.");
        }
    }

    private void cancelarReserva(Reserva reserva) {
        reserva.setStatus("Cancelada");
        reservaService.save(reserva);
        carregarDados();
    }

    @FXML
    private void handleNovaReserva() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NovaReserva.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Nova Reserva");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            carregarDados();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erro ao abrir nova reserva.");
        }
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
