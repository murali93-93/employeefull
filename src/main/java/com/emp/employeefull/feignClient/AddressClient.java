package com.emp.employeefull.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.employeefull.dto.AddressDto;

@FeignClient(name = "Address",url = "http://localhost:7773")
public interface AddressClient {

    @PostMapping("/saveAddress")
    public void SaveAddress(List<AddressDto> addressDto);
}
