package com.cronnoss.services;

import com.cronnoss.api.v1.mapper.CustomerMapper;
import com.cronnoss.api.v1.model.CustomerDTO;
import com.cronnoss.domain.Customer;
import com.cronnoss.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    public static final Long ID = 2L;
    public static final String FIRST_NAME = "Jimmy";
    public static final String LAST_NAME = "Jarmusch";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        Assertions.assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerById() {
        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        Assertions.assertEquals(FIRST_NAME, customerDTO.getFirstName());
        Assertions.assertEquals(LAST_NAME, customerDTO.getLastName());
    }

    /*@Test
    public void getCustomerByLastName() {
        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        when(customerRepository.findByLastName(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByLastName(LAST_NAME);

        //then
        Assertions.assertEquals(ID, customerDTO.getId());
        Assertions.assertEquals(FIRST_NAME, customerDTO.getFirstName());
        Assertions.assertEquals(LAST_NAME, customerDTO.getLastName());
    }*/
}