package com.example.skill_2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

        System.out.println("Program Started");

        StandardServiceRegistry ssr =
                new StandardServiceRegistryBuilder().configure().build();

        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // INSERT PRODUCTS
        Product p1 = new Product();
        p1.setProductID(1);
        p1.setProduct_name("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setPrice(65000);
        p1.setQuantity(5);
        session.save(p1);
//
        Product p2 = new Product();
        p2.setProductID(2);
        p2.setProduct_name("Keyboard");
        p2.setDescription("Mechanical Keyboard");
        p2.setPrice(2500);
        p2.setQuantity(20);
        session.save(p2);
//
        // RETRIEVE & DISPLAY BEFORE UPDATE
        Product p = session.get(Product.class, 1);
        System.out.println("\nBefore Update:");
        System.out.println(p.getProductID() + " " +
                           p.getProduct_name() + " " +
                           p.getPrice() + " " +
                           p.getQuantity());

        // UPDATE PRICE & QUANTITY
        p.setProduct_name("Laptop Pro");
        p.setPrice(70000);
        p.setQuantity(8);
        session.update(p);

        System.out.println("\nAfter Update:");
        System.out.println(p.getProductID() + " " +
                           p.getProduct_name() + " " +
                           p.getPrice() + " " +
                           p.getQuantity());

        // DELETE DISCONTINUED PRODUCT
        Product d = session.get(Product.class, 2);
        session.delete(d);

        // 🔹 DISPLAY ALL PRODUCTS
        System.out.println("\nFinal Product List:");
        List<Product> list = session.createQuery("from Product", Product.class).list();
        for(Product x : list) {
            System.out.println(x.getProductID() + " " +
                               x.getProduct_name() + " " +
                               x.getPrice() + " " +
                               x.getQuantity());
        }

        tx.commit();
        session.close();
        sf.close();

        System.out.println("\nCRUD operations on products");
    }
}
