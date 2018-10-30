/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.Product;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class ProductMapper {
    public List<Product> getAllProducts() throws SQLException{
        List<Product> products = new ArrayList();
        String sql = "select id, productname, price, images from products";
        Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("productname");
                double price = rs.getDouble("price");
                String image = rs.getString("images");
                
                Product product = new Product(id, name, price, image);
                products.add(product);
            }
        return products;
    }
    public static void main(String[] args) throws SQLException {
        ProductMapper pm = new ProductMapper();
        List<Product> products = pm.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
