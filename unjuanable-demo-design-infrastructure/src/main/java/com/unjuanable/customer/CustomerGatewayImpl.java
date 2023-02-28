package com.unjuanable.customer;

import com.unjuanable.domain.customer.Customer;
import com.unjuanable.domain.customer.gateway.CustomerGateway;
import org.springframework.stereotype.Component;

@Component
public class CustomerGatewayImpl implements CustomerGateway {
//    @Autowired
//    private CustomerMapper customerMapper;

    public Customer getByById(String customerId) {
//      CustomerDO customerDO = customerMapper.getById(customerId);
        //Convert to Customer
        return null;
    }
}
