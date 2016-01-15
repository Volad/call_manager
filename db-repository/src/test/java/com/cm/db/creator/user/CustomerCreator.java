
/**
 * 
 */
package com.cm.db.creator.user;

import com.cm.entity.Customer;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class CustomerCreator {

    public static Customer create() {
        return CustomerCreator.create("Test customer", "+375293679953");
    }

    public static Customer create(String name, String phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        return customer;
    }

}
