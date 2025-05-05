package com.ipvc.projeto2Final.JavaFXApp;

import com.ipvc.projeto2Final.SpringFXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class Main extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(com.ipvc.projeto2Final.Projeto2FinalApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        SpringFXMLLoader loader = context.getBean(SpringFXMLLoader.class);
        Parent root = loader.load("/login.fxml");
        stage.setScene(new Scene(root));
        stage.setTitle("Hotel Login");
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
