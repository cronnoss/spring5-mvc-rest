package com.cronnoss.api.v1.mapper;

import com.cronnoss.api.v1.model.CustomerDTO;
import com.cronnoss.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
}