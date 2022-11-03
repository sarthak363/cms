package com.sarthak.cls.Service;


import com.sarthak.cls.dao.CustomerDAO;
import com.sarthak.cls.exception.CustomerNotFoundException;
import com.sarthak.cls.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    private List<Customer> customerList=new CopyOnWriteArrayList<>();
    private int customerIdCount=1;
    public Customer addCustomer(Customer customer){
//        customer.setCostumerID(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;

        return customerDAO.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerDAO.findAll();
//        return customerList;
    }

    public Customer getCustomer(int customerId) {
//        return customerList
//                .stream()
//                .filter(c-> c.getCostumerID()==customerId)
//                .findFirst()
//                .get();
        Optional<Customer> optionalCustomer=customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
                throw new CustomerNotFoundException("Customer is not present");
          return optionalCustomer.get();


    }
    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCostumerID(customerId);
//        customerList
//                .stream()
//                .forEach(c-> {
//                    if(c.getCostumerID()==customerId){
//                        c.setCostumerFirstName(customer.getCostumerFirstName());
//                        c.setCostumerLastName(customer.getCostumerLastName());
//                        c.setEmail(customer.getEmail());
//                    }
//                });
//        return customerList
//                .stream()
//                .filter(c-> c.getCostumerID()==customerId)
//                .findFirst()
//                .get();
        return customerDAO.save(customer);
    }
    public void deleteCustomer(int customerId){
//        customerList
//                .stream()
//                .forEach(c-> {
//                    if(c.getCostumerID()==customerId){
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }
}
