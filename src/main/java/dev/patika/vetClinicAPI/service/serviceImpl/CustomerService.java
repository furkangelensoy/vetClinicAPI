package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.config.mapper.CustomerMapper;
import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.customer.CustomerResponse;
import dev.patika.vetClinicAPI.entity.Customer;
import dev.patika.vetClinicAPI.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements dev.patika.vetClinicAPI.service.CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;


    @Override
    public ResultData<CustomerResponse> save(CustomerSaveRequest customerSaveRequest) {
        //This method saves a customer to the database according to the customerSaveRequest.

        Customer savedCustomer = this.customerRepository.save(this.customerMapper.asEntity(customerSaveRequest));
        CustomerResponse customerResponse = this.customerMapper.asOutPut(savedCustomer);

        return ResultHelper.CREATED(customerResponse);
    }

    @Override
    public ResultData<CustomerResponse> getById(Long id) {
        //This method gets a customer from the database according to the id.

        Customer foundCustomer = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        CustomerResponse customerResponse = this.customerMapper.asOutPut(foundCustomer);

        return ResultHelper.OK(customerResponse);
    }

    @Override
    public Result delete(Long id) {
        //This method deletes a customer from the database according to the id.

        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        this.customerRepository.delete(customer);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<CustomerResponse> update(Long id, CustomerUpdateRequest customerUpdateRequest) {
        //This method updates a customer from the database according to the id and customerUpdateRequest.

        Customer customerFromDB = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        this.customerMapper.update(customerFromDB, customerUpdateRequest);

        Customer savedCustomer = this.customerRepository.save(customerFromDB);

        CustomerResponse customerResponse = this.customerMapper.asOutPut(savedCustomer);

        return ResultHelper.OK(customerResponse);
    }

    @Override
    public ResultData<List<CustomerResponse>> findAll(String customerName) {
        //This method lists all customers from the database.
        //If parameter is entered it lists according to customerName.

        List<Customer> customerList = this.customerRepository.findByFilter(customerName);
        List<CustomerResponse> customerResponseList = this.customerMapper.asOutPutList(customerList);

        return ResultHelper.OK(customerResponseList);
    }


}
