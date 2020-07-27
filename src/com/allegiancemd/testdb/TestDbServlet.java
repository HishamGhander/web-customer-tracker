package com.allegiancemd.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import  java.sql.*;
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = "SpringStudent";
        String password = "SpringStudent";
        String jdbbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database " + jdbbcUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbbcUrl,username,password);
            out.println("Success!...");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
