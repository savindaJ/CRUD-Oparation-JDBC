package controller;

import DB.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class CustomerController  {


    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXTextField txtId;
    public JFXComboBox<String> cmbId;
    public TableView tblCustomer;

    public AnchorPane root;
    public JFXButton btnAddNew;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TableColumn<Object, Object> colId;
    public TableColumn<Object, Object> colName;
    public TableColumn<Object, Object> colAddress;
    public TableColumn<Object, Object> colSalary;

    @FXML
    void initialize() {
        getAllCustomer();
        btnUpdate.setDisable(false);
    }

    private void getAllCustomer() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String quary = "SELECT * FROM customer";
            PreparedStatement pstm = connection.prepareStatement(quary);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()){
                String cusId = resultSet.getString(1);
                String cusName = resultSet.getString(2);
                String cusAddress = resultSet.getString(3);
                int cusTel = resultSet.getInt(4);

                System.out.println("cus id ;"+cusId);
                System.out.println("cus name ;"+cusName);
                System.out.println("cus address ;"+cusAddress);
                System.out.println("cus tel ;"+cusTel);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void cmbIdOnAction(ActionEvent actionEvent) {

    }

    /*private void initUi() {
        txtAddress.clear();
        txtId.clear();
        txtId.clear();
        txtSalary.clear();
        txtAddress.setDisable(true);
        txtId.setDisable(true);
        txtId.setDisable(true);
        txtSalary.setDisable(true);
        btnSave.setDisable(true);
        txtName.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }
*/
    public void btnBackClicked(MouseEvent event) throws IOException {
       /* Parent root = null;
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/menu.fxml")));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();

            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();

        }*/
    }

    public void mouseEnterd(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
//            glow.setColor(Color.valueOf("#EF233C"));
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(15);
            glow.setHeight(15);
            glow.setRadius(15);
            icon.setEffect(glow);
        }

    }

    public void mouseExsits(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);
        }
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtAddress.setDisable(false);
        txtId.setDisable(false);
        txtId.setDisable(false);
        txtSalary.setDisable(false);
        btnSave.setDisable(false);
        txtName.setDisable(false);
        txtName.requestFocus();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        //ToDo: add save function !

        String address = txtAddress.getText();
        String id = txtId.getText();
        String tel = txtSalary.getText();
        String name = txtName.getText();

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String quary = "INSERT INTO customer(id,name,address,tel) VALUES (?,?,?,?)";


            PreparedStatement pstm = connection.prepareStatement(quary);

            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, address);
            pstm.setInt(4, Integer.parseInt(tel));

//            update to database;
            int executed = pstm.executeUpdate();

            if (executed > 0)
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();


            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        //ToDo: add update function !

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String quary = "UPDATE customer SET name=?,address=?,tel=? WHERE id=?";

            PreparedStatement pstm = connection.prepareStatement(quary);

            pstm.setString(1, txtName.getText());
            pstm.setString(2, txtAddress.getText());
            pstm.setInt(3, Integer.parseInt(txtSalary.getText()));
            pstm.setString(4, txtId.getText());

            int executed = pstm.executeUpdate();

            if (executed > 0)
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        //Todo: add delete function !


        try {
            Connection connection = DBConnection.getInstance().getConnection();


            String quary = "DELETE FROM customer WHERE id=?";


            PreparedStatement pstm = connection.prepareStatement(quary);

            pstm.setString(1, txtId.getText());

            int executed = pstm.executeUpdate();

            if (executed > 0)
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillTable() {
        //ToDo: add get all function !
    }

}
