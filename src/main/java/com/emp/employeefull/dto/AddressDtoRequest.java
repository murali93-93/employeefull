package com.emp.employeefull.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoRequest {

    private String street;

    private String city;

    private String state;

    private String country;

    private String pincodeString;

    private String addressType;

}
