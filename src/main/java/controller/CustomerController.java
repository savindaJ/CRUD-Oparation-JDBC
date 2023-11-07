package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class CustomerController {


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
    void initialize(){
        initUi();
        fillTable();
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {

    }

    private void initUi(){
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
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        //ToDo: add update function !
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        //Todo: add delete function !
    }

    private void fillTable() {
        //ToDo: add get all function !
    }
}
