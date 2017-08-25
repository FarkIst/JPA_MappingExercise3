/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Customer;
import Entity.ItemType;
import Entity.Order;
import Entity.OrderLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author AR
 */
public class Facade {
    
    private EntityManager em;
    
    public void createCustomer(Customer customer) 
    {
        em.persist(customer);
    }
        
    public Customer getCustomer(Long id)
    {
        return em.find(Customer.class, id);
    }
    
    public List<Customer> getAllCustomers()
    {
        
        Query q1 = em.createQuery("SELECT c FROM Customer c");
        return q1.getResultList();
    }

    public void createOrder(Order order)
    {
        em.persist(order);
    }

    public void addOrderToCustomer(Order order, Long customerId)
    {
        Customer customer = em.find(Customer.class, customerId);
        order.setCustomer(customer);
        addOrder(order);
    }
    
    public void addOrder(Order order){
        em.persist(order);
    }
    
        public Order getOrder(Long id) {
        return em.find(Order.class, id);
    }

    public void addOrderLine(OrderLine orderLine) {
        em.persist(orderLine);
    }

    public void addItemType(ItemType itemType) {
        em.persist(itemType);
    }

    public double getTotalPrice(Order order) {
        double totalPrice = 0;
        for (OrderLine orderLine : order.getOrderLines()) {
            totalPrice += orderLine.getQuantity() * orderLine.getItemType().getPrice();
        }
        return totalPrice;
    }
}
