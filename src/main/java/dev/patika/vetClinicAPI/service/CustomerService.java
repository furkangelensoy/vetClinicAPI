package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {
    //Methods that must be present in the CustomerService class are defined in this interface.

    ResultData<CustomerResponse> save(CustomerSaveRequest customerSaveRequest);

    ResultData<CustomerResponse> getById(Long id);

    Result delete(Long id);

    ResultData<CustomerResponse> update(Long id, CustomerUpdateRequest customerUpdateRequest);

    ResultData<List<CustomerResponse>> findAll(String customerName);
}
