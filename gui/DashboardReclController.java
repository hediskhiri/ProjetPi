/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tn.edu.esprit.tools.DatabaseConnection;

public class DashboardReclController implements Initializable {
    private Connection cnx;
    private PreparedStatement prepare;
    private ResultSet result;
      @FXML
    private Button EXIT;
    @FXML
    private Label totalReclamationsLabel;
    @FXML
    private Label reclamationsTraiteesLabel;
    @FXML
    private Label reclamationsEnAttenteLabel;
    @FXML
    private BarChart<String, Number> statBarChart;
    @FXML
    private CategoryAxis statCategoryAxis;
    @FXML
    private NumberAxis statNumberAxis;
    
    // Méthode d'initialisation du tableau de bord
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayStatisticsInBarChart();
        
    }

    // Méthode pour récupérer le nombre total de réclamations depuis la base de données
    private int getTotalReclamationsFromDatabase() {
        int totalReclamations = 0;

        try {
            // Établissez une connexion à votre base de données (remplacez les détails de connexion par les vôtres)
            cnx = DatabaseConnection.getInstance().getConnection();

            // Créez une requête SQL pour récupérer le nombre total de réclamations
            String query = "SELECT COUNT(*) FROM reclamation";

            // Créez une instruction préparée
            PreparedStatement preparedStatement = cnx.prepareStatement(query);

            // Exécutez la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si des résultats sont renvoyés, récupérez la valeur
            if (resultSet.next()) {
                totalReclamations = resultSet.getInt(1);
            }

            // Fermez la connexion et les ressources
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalReclamations;
    }
public void EXIT() {
         try {
            // Charger le fichier FXML de la vue "statics.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Backrecl.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène et y ajouter la vue chargée
            Scene scene = new Scene(root);

            // Accéder à la scène actuelle à partir du bouton (ou d'un autre nœud)
            Stage stage = (Stage) EXIT.getScene().getWindow();

            // Définir la nouvelle scène sur la fenêtre principale
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    // Méthode pour récupérer le nombre de réclamations traitées depuis la base de données
    private int getReclamationsTraiteesFromDatabase() {
        int reclamationsTraitees = 0;

        try {
            // Établissez une connexion à votre base de données (remplacez les détails de connexion par les vôtres)
            cnx = DatabaseConnection.getInstance().getConnection();

            // Créez une requête SQL pour compter les réclamations traitées
            String query = "SELECT COUNT(*) FROM reclamation WHERE etat = 'TRAITE'";

            // Créez une instruction préparée
            PreparedStatement preparedStatement = cnx.prepareStatement(query);

            // Exécutez la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si des résultats sont renvoyés, récupérez la valeur
            if (resultSet.next()) {
                reclamationsTraitees = resultSet.getInt(1);
            }

           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reclamationsTraitees;
    }

    private int getReclamationsEnAttenteFromDatabase() {
        int reclamationsEnAttente = 0;

        try {
            // Établissez une connexion à votre base de données (remplacez les détails de connexion par les vôtres)
            cnx = DatabaseConnection.getInstance().getConnection();

            // Créez une requête SQL pour compter les réclamations en attente
            String query = "SELECT COUNT(*) FROM reclamation WHERE etat = 'NON_TRAITE'";

            // Créez une instruction préparée
            PreparedStatement preparedStatement = cnx.prepareStatement(query);

            // Exécutez la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si des résultats sont renvoyés, récupérez la valeur
            if (resultSet.next()) {
                reclamationsEnAttente = resultSet.getInt(1);
            }

           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reclamationsEnAttente;
    }

    // Méthode pour afficher les statistiques sous forme de graphique
    private void displayStatisticsInBarChart() {
        // Effacez les données précédentes du graphique
        statBarChart.getData().clear();

        // Créez une série de données pour le graphique
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Réclamations");

        // Récupérez les données depuis la base de données en utilisant les méthodes que nous avons définies précédemment
        int totalReclamations = getTotalReclamationsFromDatabase();
        int reclamationsTraitees = getReclamationsTraiteesFromDatabase();
        int reclamationsEnAttente = getReclamationsEnAttenteFromDatabase();

        // Ajoutez les données au graphique
        series.getData().add(new XYChart.Data<>("Total", totalReclamations));
        series.getData().add(new XYChart.Data<>("Traitées", reclamationsTraitees));
        series.getData().add(new XYChart.Data<>("En Attente", reclamationsEnAttente));

        // Ajoutez la série au graphique
        statBarChart.getData().add(series);
    }
}

