package controller;

import DB.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableController {

    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colName;

    @FXML
    void initialize(){
        ObservableList<CustomerTM> list = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from customer");
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()){
                list.add(new CustomerTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)
                ));
            }

            tblCustomer.setItems(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }
}
