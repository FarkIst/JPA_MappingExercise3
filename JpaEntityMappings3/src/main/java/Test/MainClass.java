/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author AR
 */
public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JpaEntityMappings3_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        
        Customer c = new Customer();
        
        c.setId(Long.MIN_VALUE);
        
            try {
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
            System.out.println("Discount price: " + c.getPrice(2, 3));
    }
}
