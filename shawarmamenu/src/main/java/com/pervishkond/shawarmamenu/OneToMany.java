package com.pervishkond.shawarmamenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class OneToMany extends HttpServlet {

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
            ResultSet resultSet = statement.executeQuery("SELECT shawarma_menu.shawarma_name , profits.amount_of_order FROM shawarma_menu JOIN profits ON shawarma_menu.shawarma_id = profits.shawarma_id");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(("shawarma_name")));
                System.out.println(resultSet.getInt(("amount_of_order")));
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
