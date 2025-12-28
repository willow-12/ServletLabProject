package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show_all")
public class ShowAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            out.println("<h2>All Students</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Year</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getInt("year") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<a href='index.jsp'>Back</a>");

            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
