package com.act.spring_boot_curd_basics.service;

import com.act.spring_boot_curd_basics.dto.RequestDto;
import com.act.spring_boot_curd_basics.dto.ResponseDto;
import com.act.spring_boot_curd_basics.entity.Customers;
import com.act.spring_boot_curd_basics.entity.FileData;
import com.act.spring_boot_curd_basics.repository.CustomerRepository;
import com.act.spring_boot_curd_basics.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FileDataRepository fileDataRepository;

    String FOLDER_PATH = "/home/abel/Desktop/Java_Project/Java_SpringBoot/uploadedImage";
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }



//    Saving da

    public ResponseDto saveCustomers(RequestDto requestDto) {
        String email = requestDto.getEmail();
        String name = requestDto.getName();
        String phone = requestDto.getPhone();

        if (name == "" && name.isEmpty() && email == "" && email.isEmpty() && phone == "" && phone.isEmpty()) {
            return new ResponseDto("All field is required", false, 400);
        } else if (name.isEmpty() || name =="") {
            return new ResponseDto("Name is required.", false, 400);
        } else if (email == "" || email.isEmpty()) {
            return new ResponseDto("Email is required.", false, 400);
        } else if (phone == "" || phone.isEmpty()) {
            return new ResponseDto("Phone number is required.", false, 400);
        } else if (customerRepository.existsByEmail(email)) {
            return new ResponseDto("Email already taken." , false,400);
        }else {
            Customers customers = new Customers();
            customers.setName(requestDto.getName());
            customers.setEmail(requestDto.getEmail());
            customers.setPhone(requestDto.getPhone());
            customerRepository.save(customers);
            return new ResponseDto("Customer registered successfully.", true, 201);
        }
    }


//    Get By ID
    public Optional<Customers> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

//    Deleting a user by id method
    public ResponseDto deleteCustomer(Long id) {
        Optional<Customers> customers = customerRepository.findById(id);
        if (customers.isPresent()){
            customerRepository.deleteById(id);
            return new ResponseDto("Deleted Successfully", true, 201);
        }else {
            return new ResponseDto("Customer with id "+ id +" not found to delete", false, 404);
        }
    }


    public ResponseDto updateCustomer(Long id, RequestDto requestDto) {

        Optional<Customers> customersExists = customerRepository.findById(id);

        if (customersExists.isPresent()){
            Customers customers = customersExists.get();
            customers.setName(requestDto.getName());
            customers.setEmail(requestDto.getEmail());
            customers.setPhone(requestDto.getPhone());
            customerRepository.save(customers);
            System.out.println("====================================" +customers);
            HttpStatusCode HttpStatus;
            return new ResponseDto("Customer updated successfully.", true, 202);

        }else {
            return new ResponseDto("Not Found to updated", false, 203);
        }

    }


//    Save multiple users once
    public ResponseDto saveAllCustomers(List<RequestDto> requestDtoList) {


        boolean anyFieldInvalid = requestDtoList.stream()
                .anyMatch(requestDto -> {
                    String email = requestDto.getEmail();
                    String name = requestDto.getName();
                    String phone = requestDto.getPhone();

                    return name == null || name.isEmpty() ||
                            email == null || email.isEmpty() ||
                            phone == null || phone.isEmpty() ||
                            customerRepository.existsByEmail(email);
                });

        if (anyFieldInvalid) {
            return new ResponseDto("Invalid request parameters", false, 400);
        }

        List<Customers> customersList = requestDtoList.stream()
                .map(requestDto -> {
                    Customers customer = new Customers();
                    customer.setName(requestDto.getName());
                    customer.setEmail(requestDto.getEmail());
                    customer.setPhone(requestDto.getPhone());
                    return customer;
                })
                .collect(Collectors.toList());
        customerRepository.saveAll(customersList);

        return new ResponseDto("Customers saved successfully", true, 200);

//        for (RequestDto requestDto : requestDtoList) {
//            String email = requestDto.getEmail();
//            String name = requestDto.getName();
//            String phone = requestDto.getPhone();
//
//            if (name == null || name.isEmpty()) {
//                return new ResponseDto("Name is required", false, 404);
//            } else if (email == null || email.isEmpty()) {
//                return new ResponseDto("Email is required", false, 404);
//            } else if (phone == null || phone.isEmpty()) {
//                return new ResponseDto("Phone number is required", false, 404);
//            } else if (customerRepository.existsByEmail(email)) {
//                return new ResponseDto("Email is already exist", false, 404);
//            }
//        }
//
//        List<Customers> customersList = requestDtoList.stream()
//                .map(requestDto -> {
//                    Customers customer = new Customers();
//                    customer.setName(requestDto.getName());
//                    customer.setEmail(requestDto.getEmail());
//                    customer.setPhone(requestDto.getPhone());
//                    return customer;
//                })
//                .collect(Collectors.toList());
//
//        customerRepository.saveAll(customersList);
//
//        return new ResponseDto("Customers saved successfully", true, 200);
    }

    public ResponseDto uplaodPhoto(MultipartFile photo) throws IOException {
        String filePath = FOLDER_PATH + photo.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(photo.getOriginalFilename())
                .type(photo.getContentType())
                .path(filePath)
                .build());
        photo.transferTo(new File(filePath));
        if (fileData != null) {
            return new ResponseDto("File uploaded successfully" + filePath, true, 201);
//            System.out.println("=================file updated============");
        }
        return null;
    }
//    UploadingImage



}
