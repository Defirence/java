package com.example.jobtracker.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JobTrackerGUI extends Application {

    private TextField companyNameField;
    private TextField positionField;
    private ComboBox<String> statusComboBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Job Tracker");

        initializeUI();

        Button saveButton = createSaveButton();

        VBox layout = new VBox(10, companyNameField, positionField, statusComboBox, saveButton);
        layout.setPadding(new Insets(10)); // Add padding for better aesthetics

        Scene scene = new Scene(layout, 400, 300); // Increased size for better layout
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeUI() {
        companyNameField = new TextField();
        companyNameField.setPromptText("Company Name");

        positionField = new TextField();
        positionField.setPromptText("Position");

        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Applied", "Interviewed", "Rejected", "No Response");
        statusComboBox.setPromptText("Select Status"); // Added prompt text
    }

    private Button createSaveButton() {
        Button saveButton = new Button("Save Job");
        saveButton.setOnAction(e -> saveJobData());
        return saveButton;
    }

    private void saveJobData() {
        String companyName = companyNameField.getText();
        String position = positionField.getText();
        String status = statusComboBox.getValue();

        // TODO: Send data to backend API
        System.out.println("Saved: " + companyName + ", " + position + ", " + status);
        // You can add error handling and validation here
    }

    public static void main(String[] args) {
        launch(args);
    }
}