package com.pervishkond.shawarmamenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Ordering extends HttpServlet {

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
            String sql = "Select COUNT(shawarma_id) FROM shawarma_menu";
            Statement amountOfShawarma = connection.createStatement();
            int amount = 0;
            ResultSet getAmount = amountOfShawarma.executeQuery(sql);
            while (getAmount.next()) {
                amount = getAmount.getInt(1);
            }
            if (amount != 0) {
                int id = (int) (Math.random() * amount);
                if (id == 0) {
                    id++;
                }
                orderIncrement(id, connection);
            }
            getAmount.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }


    private void orderIncrement(int id, Connection connection) {
        try {
            String sqlOrder = "SELECT amount_of_order FROM profits WHERE shawarma_id = ?";
            PreparedStatement orderGetter = connection.prepareStatement(sqlOrder);
            orderGetter.setInt(1, id);
            ResultSet getOrder = orderGetter.executeQuery();
            int orders = 0;
            while (getOrder.next()) {
                orders = getOrder.getInt(1);
                orders++;
            }
            String sql = "UPDATE profits SET amount_of_order = ? WHERE shawarma_id = ?";
            PreparedStatement orderChanger = connection.prepareStatement(sql);
            orderChanger.setInt(1, orders);
            orderChanger.setInt(2, id);
            orderChanger.executeUpdate();
            countProfit(id, connection);
            getOrder.close();
            orderGetter.close();
            orderChanger.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void countProfit(int id, Connection connection) {
        try {
            String sqlProfit = "SELECT profit FROM profits WHERE shawarma_id = ?";
            PreparedStatement profitGetter = connection.prepareStatement(sqlProfit);
            profitGetter.setInt(1, id);
            ResultSet getProfit = profitGetter.executeQuery();
            int profit = Integer.MIN_VALUE;
            while (getProfit.next()) {
                profit = getProfit.getInt(1);
            }
            String sqlCost = "SELECT price FROM shawarma_menu WHERE (shawarma_id = ?)";
            PreparedStatement priceGetter = connection.prepareStatement(sqlCost);
            priceGetter.setInt(1, id);
            ResultSet getPrice = priceGetter.executeQuery();
            int price = Integer.MIN_VALUE;
            while (getPrice.next()) {
                price = getPrice.getInt(1);
            }
            if (profit != Integer.MIN_VALUE && price != Integer.MIN_VALUE) {
                String sql = "UPDATE profits SET profit = ?  WHERE shawarma_id = ?";
                PreparedStatement profitChanger = connection.prepareStatement(sql);
                profitChanger.setInt(1, profit + price);
                profitChanger.setInt(2, id);
                profitChanger.executeUpdate();
                System.out.println("Updated");
                profitChanger.close();
            } else {
                System.out.println("No element");
            }
            profitGetter.close();
            priceGetter.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
