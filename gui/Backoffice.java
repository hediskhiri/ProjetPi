/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import tn.edu.esprit.entities.userr;
import tn.edu.esprit.entities.utilisateur;
import tn.edu.esprit.tools.DatabaseConnection;
import workshopjdbc.MainApp;

public class Backoffice implements Initializable {
    
      @FXML
    private Button laison_back;

       @FXML
    private Button maintenance;
    @FXML
    private Circle circle_back;
    @FXML
    private Label hello;
    @FXML
    private Button home_back;
    @FXML
    private Button edit_back;
    @FXML
    private Button amine;
    
     @FXML
    private Button rawef; 
    @FXML
    private AnchorPane admin_page;
    @FXML
    private Label file_path;
    @FXML
    private ImageView imageview_back;

    @FXML
    private AnchorPane backoffice1;

    @FXML
    private Button clear_back;

    @FXML
    private DatePicker date_back;

    @FXML
    private TableColumn<utilisateur, String> date_col;

    @FXML
    private Button delete_back;

    @FXML
    private TextField email_back;

    @FXML
    private TableColumn<utilisateur, String> email_col;

    @FXML
    private ComboBox<?> gender_back;

    @FXML
    private TableColumn<utilisateur, String> gender_col;

    @FXML
    private TextField id_back;

    @FXML
    private TableColumn<utilisateur, Integer> id_col;

    @FXML
    private Button image_back;

    @FXML
    private TableColumn<utilisateur, String> image_col;

    @FXML
    private Button insert_back;

    @FXML
    private TextField password_back;

    @FXML
    private TableColumn<utilisateur, String> password_col;

    @FXML
    private ComboBox<String> role_back;

    @FXML
    private TableColumn<utilisateur, String> role_col;

    @FXML
    private TableView<utilisateur> table_view;

    @FXML
    private Button update_back;

    @FXML
    private TextField username_back;

    @FXML
    private TableColumn<utilisateur, String> username_col;
    private Connection cnx;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    private Image image;

    private String genderData[] = {"Male", "Female", "Others"};

    public void comboBox(){

        List<String> list = new ArrayList<>();

        for(String data1: genderData){

            list.add(data1);

        }

        ObservableList dataList = FXCollections.observableArrayList(list);

        gender_back.setItems(dataList);

    }

    private String role[] = {"admin", "client", "employee"};

    public void comboBox1(){

        List<String> list = new ArrayList<>();

        for(String data1: role){

            list.add(data1);

        }

        ObservableList dataList = FXCollections.observableArrayList(list);

        role_back.setItems(dataList);

    }
    public void changefxml(ActionEvent event) { 
           MainApp.getInstance().loadBack();
//    try {
////        // Load the FXML file
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));
////        Parent root = loader.load();
////
////        // Get the controller associated with the FXML
////        AjouterProduitController ajouterProduitController = loader.getController();
////
////        // Create a new scene with the loaded FXML content
////        Scene scene = new Scene(root);
////
////        // Get the stage from the event source (usually a button click)
////        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////
////        // Set the new scene on the stage and show it
////        stage.setScene(scene);
////        stage.show();
////    } catch (IOException ex) {
////        System.err.println("Error loading AjouterProduit.fxml: " + ex.getMessage());
////        ex.printStackTrace(); // This will print the full exception stack trace for debugging.
////    }
}

    public void insert() {
        cnx = DatabaseConnection.getInstance().getConnection();

        String sql = "INSERT INTO utilisateur (username, password, email, image, idUser, gender, date,role) VALUES (?,?,?,?,?,?,?,?)";

        try {
            if (id_back.getText().isEmpty() || username_back.getText().isEmpty()
                    || password_back.getText().isEmpty()
                    || email_back.getText().isEmpty()
                    || gender_back.getSelectionModel().isEmpty()
                    || role_back.getSelectionModel().isEmpty()
                    || date_back.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs !");
                alert.showAndWait();

            } else {
                String file = file_path.getText().replace("\\", "\\\\");

                prepare = cnx.prepareStatement(sql);
                prepare.setString(1, username_back.getText());
                prepare.setString(2, password_back.getText());
                prepare.setString(3, email_back.getText());
                prepare.setString(4, file);
                prepare.setString(5, id_back.getText());
                prepare.setString(6, (String)gender_back.getSelectionModel().getSelectedItem()); // Utilisez getValue() pour obtenir la valeur sélectionnée du DatePicker
                prepare.setString(7, date_back.getValue().toString());
                prepare.setString(8, (String)role_back.getSelectionModel().getSelectedItem());// Utilisez getValue() pour obtenir la date depuis DatePicker

                prepare.executeUpdate();

                // Pour afficher immédiatement les données actuelles
                showData();
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear(){

        id_back.setText("");
        username_back.setText("");
        password_back.setText("");
        email_back.setText("");

        gender_back.getSelectionModel().clearSelection();
        role_back.getSelectionModel().clearSelection();
        file_path.setText("");
        imageview_back.setImage(null);
        date_back.setValue(null);

    }
    
    public void afficherStatistiques() {
        try {
            // Charger le fichier FXML de la vue "statics.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Backrecl.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène et y ajouter la vue chargée
            Scene scene = new Scene(root);

            // Accéder à la scène actuelle à partir du bouton (ou d'un autre nœud)
            Stage stage = (Stage) amine.getScene().getWindow();

            // Définir la nouvelle scène sur la fenêtre principale
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void aziz() {
        try {
            // Charger le fichier FXML de la vue "statics.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajoutstation.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène et y ajouter la vue chargée
            Scene scene = new Scene(root);

            // Accéder à la scène actuelle à partir du bouton (ou d'un autre nœud)
            Stage stage = (Stage) maintenance.getScene().getWindow();

            // Définir la nouvelle scène sur la fenêtre principale
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void afficherStatistiquessss() {
        try {
            // Charger le fichier FXML de la vue "statics.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("statics.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène et y ajouter la vue chargée
            Scene scene = new Scene(root);

            // Accéder à la scène actuelle à partir du bouton (ou d'un autre nœud)
            Stage stage = (Stage) rawef.getScene().getWindow();

            // Définir la nouvelle scène sur la fenêtre principale
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void selectutilisateur(){

        int num = table_view.getSelectionModel().getSelectedIndex();

        utilisateur utilisateur1 = table_view.getSelectionModel().getSelectedItem();

        if(num-1 < -1)
            return;

        id_back.setText(String.valueOf(utilisateur1.getId()));
        username_back.setText(utilisateur1.getUsername());
        password_back.setText(utilisateur1.getPassword());
        email_back.setText(utilisateur1.getEmail());
        gender_back.getSelectionModel().clearSelection();
        role_back.getSelectionModel().clearSelection();
        file_path.setText(utilisateur1.getImage());
        image = new Image("file:" + utilisateur1.getImage(), 110, 110, false, true);

        imageview_back.setImage(image);

    }
    public void exit() {

        System.exit(0);

    }
    public void update(){

        cnx = DatabaseConnection.getInstance().getConnection();

        String replace = file_path.getText().replace("\\","\\\\");

        String sql = "UPDATE utilisateur SET `username` = '" + username_back.getText()
                + "', `password` = '" + password_back.getText()
                + "', `email` = '" + email_back.getText()
                + "', `image` = '" + replace
                + "', `gender` = '"
                + gender_back.getSelectionModel().getSelectedItem()
                + "', `date` = '"
                +date_back.getValue().toString()
                + "', `role` = '"
                + role_back.getSelectionModel().getSelectedItem()

                + "' WHERE `idUser` ='" + id_back.getText() + "'";

        try{
            if(id_back.getText().isEmpty() | username_back.getText().isEmpty()
                    | email_back.getText().isEmpty()
                    | password_back.getText().isEmpty()

                    | gender_back.getSelectionModel().isEmpty()
                    | role_back.getSelectionModel().isEmpty())
                    {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something wrong :3");
                alert.showAndWait();

            }else{

                statement = cnx.createStatement();
                statement.executeUpdate(sql);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("rawef Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                showData();
                clear();

            }
        }catch(Exception e){}

    }
    public void delete(){

        cnx = DatabaseConnection.getInstance().getConnection();

        String sql = "DELETE FROM utilisateur WHERE `idUser` ='" + id_back.getText() + "'";

        try{

            if(id_back.getText().isEmpty()){

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Enter your Student ID");
                alert.showAndWait();

            }else{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");

                Optional<ButtonType> option = alert.showAndWait();

                if(option.get() != ButtonType.OK)
                    return;
                else{

                    statement = cnx.createStatement();
                    statement.executeUpdate(sql);

                }

                showData();
                clear();

            }

        }catch(Exception e){}

    }

    public ObservableList<utilisateur> listutilisateur(){
        ObservableList<utilisateur> utilisateurList = FXCollections.observableArrayList();
        cnx = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM utilisateur";

        try{
            statement = cnx.createStatement();
            result = statement.executeQuery(sql);
            utilisateur utilisateur1;

            while(result.next()){
                utilisateur1 = new utilisateur(
                        result.getInt("idUser"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("role"),
                        result.getString("gender"),
                        result.getString("image"),
                        result.getString("date")
                );

                utilisateurList.add(utilisateur1);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return utilisateurList;
    }

    //    INSERT IMAGE


    public void showData(){

        ObservableList<utilisateur> show = listutilisateur();

        username_col.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_col.setCellValueFactory(new PropertyValueFactory<>("password"));
        password_col.setCellFactory(getPasswordTableCellFactory());
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        image_col.setCellValueFactory(new PropertyValueFactory<>("image"));
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        role_col.setCellValueFactory(new PropertyValueFactory<>("role"));

        table_view.setItems(show);

    }
    public static <S> Callback<TableColumn<S, String>, TableCell<S, String>> getPasswordTableCellFactory() {
        return column -> {
            TableCell<S, String> cell = new TableCell<S, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        // Affichez une valeur masquée (par exemple, des astérisques) au lieu du mot de passe
                        StringBuilder maskedPassword = new StringBuilder();
                        for (int i = 0; i < item.length(); i++) {
                            maskedPassword.append("*");
                        }
                        setText(maskedPassword.toString());
                    }
                }
            };
            return cell;
        };
    }

    public void genererPDF() {
        ObservableList<utilisateur> show = table_view.getItems();

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\rawef\\OneDrive\\Desktop\\projects"));
            document.open();

            // Créer une table avec 7 colonnes
            PdfPTable table = new PdfPTable(7);

            // Définir la largeur des colonnes (vous pouvez ajuster cela selon vos besoins)
            float[] columnWidths = {2, 2, 2, 2, 2, 2, 2};
            table.setWidths(columnWidths);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

            for (utilisateur user : show) {
                PdfPCell cell;
                cell = new PdfPCell(new Phrase("Nom d'utilisateur : " + user.getUsername(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Mot de passe : " + user.getPassword(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("E-mail : " + user.getEmail(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Image : " + user.getImage(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("ID : " + user.getId(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Genre : " + user.getGender(), font));
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Date : " + user.getDate(), font));
                table.addCell(cell);
            }

            document.add(table);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changePage(){

        if(home_back.isFocused()) {

            backoffice1.setVisible(true);
            admin_page.setVisible(false);

        }
        if(edit_back.isFocused()) {
            backoffice1.setVisible(false);
            admin_page.setVisible(true);

        }}
    public void account() {

        hello.setText(userr.username);

    }
    public void displayImage() {

//        MAKE SURE THAT YOU DIDNT FORGET THE "file:"
        String uri = "file:" + userr.path;

        image = new Image(uri, 150, 150, false, true);

        circle_back.setFill(new ImagePattern(image));



    }

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
        comboBox();
        comboBox1();
        account();
        displayImage();

    }
}