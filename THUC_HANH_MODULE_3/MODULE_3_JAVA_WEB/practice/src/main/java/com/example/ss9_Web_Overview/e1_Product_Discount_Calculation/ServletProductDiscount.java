package com.example.ss9_Web_Overview.e1_Product_Discount_Calculation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProductDiscount", value = "/product")
public class ServletProductDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("product.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Product_Description = request.getParameter("Description");
        float List_Price = Float.parseFloat(request.getParameter("Price"));
        int Discount_Percent = Integer.parseInt(request.getParameter("Percent"));

        double Discount_Amount = List_Price * Discount_Percent * 0.01;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description : " + Product_Description + "</h1>");
        writer.println("<h1>Price : " + List_Price + "</h1>");
        writer.println("<h1>Percent : " + Discount_Percent + "</h1>");
        writer.println("<h1>Amount : " + Discount_Amount + "</h1>");
        writer.println("</html>");
    }
}
