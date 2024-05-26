package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerSaveRequest;
import dev.patika.vetClinicAPI.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.customer.CustomerResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResultData<CustomerResponse> getById(@PathVariable Long id) {
        return this.customerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        return this.customerService.save(customerSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<CustomerResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest) {

        return this.customerService.update(id, customerUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        return this.customerService.delete(id);
    }

    @GetMapping
    public ResultData<List<CustomerResponse>> findAll(
            @RequestParam(required = false) String customerName) {

        return this.customerService.findAll(customerName);
    }
}
