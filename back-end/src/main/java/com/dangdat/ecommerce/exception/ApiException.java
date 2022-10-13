package com.dangdat.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException {
    private int statusCode;
    private String message;
}
