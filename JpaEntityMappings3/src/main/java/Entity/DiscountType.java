/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
/**
 *
 * @author AR
 */
@Entity
//@Inheritence
public class DiscountType implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = InheritenceType.JOINED)
    private Long id;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
               
    public double calcDiscount(double priceItem, int quantity){
        
        return priceItem * quantity;
    }
    
}