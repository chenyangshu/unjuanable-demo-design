package com.unjuanable.domain.customer.gateway;

import com.unjuanable.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
