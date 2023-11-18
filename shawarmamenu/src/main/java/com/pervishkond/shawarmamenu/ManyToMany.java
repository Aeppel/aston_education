package com.pervishkond.shawarmamenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ManyToMany extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/test_db", "postgres", "NikitaPDO");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT shawarma_menu.shawarma_name, ingredients.ingredients FROM shawarma_menu" +
                    " JOIN composition_of_the_product ON shawarma_menu.shawarma_id = composition_of_the_product.shawarma_id\n" +
                    "JOIN ingredients ON composition_of_the_product.shawarma_id = ingredients.ingredients_id");

            while (resultSet.next()){
                System.out.print(resultSet.getString("shawarma_name") + " : ");
                System.out.println(resultSet.getString("ingredients"));

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
