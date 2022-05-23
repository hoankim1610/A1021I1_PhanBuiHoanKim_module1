package cg.test;

import cg.test.model.Product;
import cg.test.service.ProductService;
import cg.test.util.CommonUtil;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id= request.getParameter("id");
        if(id != null){
            request.setAttribute("product", productService.findById(Integer.parseInt(id)));
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
        else{
            request.setAttribute("products", productService.findAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = CommonUtil.toInt(req.getParameter("id"));
        if(name != null){
            String action=  req.getParameter("action");
            if(action != null){
                List<Product> products = productService.findAll();
                List<Product> list = products.stream().filter(e ->e.getName().contains(name)).collect(Collectors.toList());
                req.setAttribute("products", list);
                req.getRequestDispatcher("list.jsp").forward(req, resp);
            }
            else{
                Double price = Double.valueOf(req.getParameter("price"));
                int quantity = Integer.valueOf(req.getParameter("quantity"));
                String color = req.getParameter("color");
                String description = req.getParameter("description");
                int categoryId = Integer.valueOf(req.getParameter("category"));
                Product product = new Product(id,name, price, quantity, color, description, categoryId, "");
                productService.save(product);
            }

        }
        else{
            productService.delete(id);
        }

        resp.sendRedirect("/product");
    }
}
