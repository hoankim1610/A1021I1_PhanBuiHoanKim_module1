package com.codegym.practice.e2_calculation.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService{

    @Override
    public float calculation(float number1, float number2, String calculate) throws Exception {
        float result;
        switch (calculate){
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "multiplication":
                result = number1 * number2;
                break;
            case "division":
                if (number1 == 0){
                    throw new Exception("Can not divide to Zero!");
                }else {
                    result = number1 / number2;
                }
                break;
            default:
                throw new Exception("Exception");
        }
        return result;
    }
}
