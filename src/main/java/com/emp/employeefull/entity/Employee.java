package com.emp.employeefull.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "EmployeENtity for dataPersitance",example = "Empoylee class")
//@Tag(description = "mll")
//@Mode
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emp_id")
    @Schema(description = "Employee ID", example = "101")
    @Parameter
    private Long id;

    //@Size(min = 4,max = 20)
    @NotBlank(message = "Emp_Name shold not be Blank")
    @Column(name = "emp_name")
    @Schema(description = "Employee first name", example = "Rahul Sharma")
    private String fullName;

    @NotBlank(message = "last Name shold not be Blank")
    @Schema(description = "Last name", example = "Rahul Sharma")
    @Column(name = "last_name")
    private String lastName;

    @Schema(description = "Email address", example = "rahul@gmail.com")
    @Column(name = "email")
    private String email;
    @Schema(description = "Email address", example = "rahul@gmail.com")
    @Column(name = "phone_number")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;
    @Schema(description = "Email address", example = "rahul@gmail.com")

    @Column(name = "blood_group")
    private String bloodGroup;

   // @Column(name = "address")
   @Schema(description = "Email address", example = "[rahul@gmail.com}")
    @ElementCollection
    @Size(min = 1, message = "At least one address required")
    private List<@NotBlank  String> address;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@Null(message="Should be null salary cannot set")
    @Column(name = "emp_salary")
    private double salary;
    @Schema(description = "project_id", example = "infy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "project_id")
    private String projectId;  // Only ID stored
}