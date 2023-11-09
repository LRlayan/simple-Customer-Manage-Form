package lk.ijse.practice.model;

import lk.ijse.practice.db.DbConnection;
import lk.ijse.practice.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerModel {

    public boolean saveCustomer(CustomerDto dtoList) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,dtoList.getCustomerId());
        preparedStatement.setString(2,dtoList.getName());
        preparedStatement.setString(3,dtoList.getAddress());
        preparedStatement.setString(4,dtoList.getTel());

        boolean isSaved =  preparedStatement.executeUpdate() > 0;

        return isSaved;
    }

    public boolean updateCustomer(CustomerDto customerDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET name = ? , address = ? , tel = ? WHERE customerId = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,customerDto.getName());
        preparedStatement.setString(2,customerDto.getAddress());
        preparedStatement.setString(3,customerDto.getTel());
        preparedStatement.setString(4,customerDto.getCustomerId());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteCustomer(CustomerDto customerDto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE customerId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,customerDto.getCustomerId());

        return preparedStatement.executeUpdate() > 0;
    }

    public CustomerDto searchcustomer(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,id);

        CustomerDto customerDto = null;

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String customerId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);

            customerDto = new CustomerDto(customerId,name,address,tel);
        }

        return customerDto;
    }
}
