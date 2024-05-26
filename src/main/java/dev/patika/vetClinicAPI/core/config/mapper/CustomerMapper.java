package dev.patika.vetClinicAPI.core.config.mapper;

import dev.patika.vetClinicAPI.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.customer.CustomerResponse;
import dev.patika.vetClinicAPI.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer asEntity(CustomerSaveRequest customerSaveRequest);

    List<CustomerResponse> asOutPutList(List<Customer> customerList);

    CustomerResponse asOutPut(Customer customer);

    void update(@MappingTarget Customer entity, CustomerUpdateRequest customerUpdateRequest);
}
