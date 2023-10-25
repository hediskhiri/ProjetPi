package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class statics implements Initializable {
    private Connection connect;
    @FXML
    private Button EXIT;
    @FXML
    private Label totalReclamationsLabel;
    @FXML
    private BarChart<String, Number> statBarChart;
    @FXML
    private CategoryAxis statCategoryAxis;
    @FXML
    private NumberAxis statNumberAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayStatisticsInBarChart();
    }

    private int getTotalutilisateurFromDatabase() {
        int totalutilisateur = 0;

        try {
            connect = database.connectDb();
            String query = "SELECT COUNT(*) FROM utilisateur";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalutilisateur = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalutilisateur;
    }

    public void EXIT() {
        System.exit(0);
    }

    private void displayStatisticsInBarChart() {
        statBarChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("utilisateur");

        int totalutilisateur = getTotalutilisateurFromDatabase();
        series.getData().add(new XYChart.Data<>("Total", totalutilisateur));

        statBarChart.getData().add(series);
    }
}
