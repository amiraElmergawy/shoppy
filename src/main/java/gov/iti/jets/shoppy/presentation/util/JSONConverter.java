package gov.iti.jets.shoppy.presentation.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.customer.CustomerPostRequestDto;

import java.io.FileWriter;
import java.io.IOException;

public class JSONConverter {
    public static <T> String ToJSON(T object) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(object);
    }

    public static CustomerPostRequestDto JSONToCustomerDto(String jsonString) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CustomerPostRequestDto customerDto = gson.fromJson(jsonString, CustomerPostRequestDto.class);
        return customerDto;
    }

}
