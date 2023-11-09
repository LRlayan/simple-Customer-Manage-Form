package lk.ijse.practice.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.practice.dto.CustomerDto;
import lk.ijse.practice.model.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageCustomerFormController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    CustomerModel customerModel = new CustomerModel();

    @FXML
    void CustomerSaveOnAction(ActionEvent event) throws SQLException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var dto = new CustomerDto(id,name,address,tel);

        try{
            boolean isSaved = customerModel.saveCustomer(dto);

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved Customer!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void customerSearchOnAction(ActionEvent event) {
       String id = txtId.getText();

       try {
           CustomerDto customerDto = customerModel.searchcustomer(id);

           if (customerDto != null){
               txtId.setText(customerDto.getCustomerId());
               txtName.setText(customerDto.getName());
               txtAddress.setText(customerDto.getAddress());
               txtTel.setText(customerDto.getTel());
           }else {
               new Alert(Alert.AlertType.INFORMATION,"Customer Not Found!").show();
           }
       }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
       }
    }


    @FXML
    void customerDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var customerDto = new CustomerDto(id , name , address , tel);

        try{
            boolean isDelete =  customerModel.deleteCustomer(customerDto);

            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Customer!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType. ERROR , e.getMessage()).show();
        }

    }

    @FXML
    void customerUpdateOnAction(ActionEvent event) {
       String id = txtId.getText();
       String name = txtName.getText();
       String address = txtAddress.getText();
       String tel = txtTel.getText();

       var customerDto = new CustomerDto(id,name,address,tel);

       try{
           boolean isUpdate = customerModel.updateCustomer(customerDto);
           if (isUpdate) {
               new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();
           }
       }catch (SQLException e){
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
       }

    }
}
