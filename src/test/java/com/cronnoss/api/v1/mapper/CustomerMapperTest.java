package com.cronnoss.api.v1.mapper;

import com.cronnoss.api.v1.model.CustomerDTO;
import com.cronnoss.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerMapperTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Buck";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {

        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        Assertions.assertEquals(FIRST_NAME, customer.getFirstName());
        Assertions.assertEquals(LAST_NAME, customer.getLastName());
    }
}
