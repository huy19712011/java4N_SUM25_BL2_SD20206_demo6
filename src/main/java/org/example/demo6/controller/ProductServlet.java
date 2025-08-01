package org.example.demo6.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo6.entity.Category;
import org.example.demo6.entity.Product;
import org.example.demo6.repository.ProductRepository;
import org.example.demo6.service.CategoryService;
import org.example.demo6.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products",
        "/products/new",
        "/products/insert",
        "/products/delete",
        "/products/edit",
        "/products/update"
})
public class ProductServlet extends HttpServlet {

    private ProductService service = new ProductService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/products":
                listProducts(request, response);
                break;
            case "/products/new":
                showNewForm(request, response);
                break;
            case "/products/insert":
                insertProduct(request, response);
                break;
            case "/products/delete":
                deleteProduct(request, response);
                break;
            case "/products/edit":
                editProduct(request, response);
                break;
            case "/products/update":
                updateProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = getProductFromForm(request);

        service.updateProduct(product);

        response.sendRedirect("/products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Product product = service.getProductById(id);
        request.setAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);
        request.setAttribute("categoryId", product.getCategory().getId());

        request.getRequestDispatcher("/views/updateProductForm.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        service.deleteProduct(id);

        response.sendRedirect("/products");

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = getProductFromForm(request);

        service.addProduct(product);

        response.sendRedirect("/products");
    }

    private Product getProductFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Long categoryId = Long.parseLong(request.getParameter("category_id"));
        Category category = categoryService.getCategoryById(categoryId);

        Product product = new Product(id, name);
        product.setCategory(category);

        return product;
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.getCategories();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/addProductForm.jsp").forward(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = new ArrayList<>();
        products = service.getProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/productList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}