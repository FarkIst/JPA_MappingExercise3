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


/**
 *
 * @author AR
 */
@Entity
public class DiscountFixed extends DiscountType implements Serializable {

    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    double discount = 0.1;


  @Override
  public double calcDiscount(double priceItem, int quantity) {
    return priceItem * discount *quantity;
  }

    
}
