package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String year = request.getParameter("year");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,email,year) VALUES (?,?,?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, Integer.parseInt(year));

            ps.executeUpdate();
            con.close();

            out.println("<h2>Student Registered Successfully</h2>");
            out.println("<a href='index.jsp'>Back</a>");

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
