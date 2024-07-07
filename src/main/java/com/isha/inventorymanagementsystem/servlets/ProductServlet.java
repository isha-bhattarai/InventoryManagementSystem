package com.isha.inventorymanagementsystem.servlets;

import com.isha.inventorymanagementsystem.classes.DatabaseConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = statement.executeQuery();
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()) {
                JSONObject productJson = new JSONObject();
                productJson.put("id", resultSet.getInt("id"));
                productJson.put("name", resultSet.getString("name"));
                productJson.put("quantity", resultSet.getInt("quantity"));
                productJson.put("description", resultSet.getString("description"));
                jsonArray.put(productJson);
            }

            out.print(jsonArray.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){

            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("name");
        String productDescription = request.getParameter("description");
        String  productQuantity = request.getParameter("quantity");
        PrintWriter out = response.getWriter();
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products(name,quantity,description) VALUES(?,?,?)");
            statement.setString(1, productName);
            statement.setInt(2, Integer.valueOf(productQuantity));
            statement.setString(3, productDescription);

            int insertData = statement.executeUpdate();
            if (insertData == 1) {
                out.println("product_created_successfully");
            } else {
                out.println("error_while_creating_product");
            }
        }catch (SQLException e){
            e.printStackTrace();
//            out.println(e.getMessage());

        }catch (Exception e){

            e.printStackTrace();
//            out.println(e.getMessage());

        }finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

}
