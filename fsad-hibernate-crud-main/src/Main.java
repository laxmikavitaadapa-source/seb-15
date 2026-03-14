import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(product.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            product p = new product("Laptop", "Gaming Laptop", 75000, 5);

            session.beginTransaction();

            session.save(p);

            session.getTransaction().commit();

            System.out.println("Product inserted successfully");

        } finally {
            factory.close();
        }
    }
}