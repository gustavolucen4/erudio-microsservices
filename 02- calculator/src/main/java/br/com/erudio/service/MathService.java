package br.com.erudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    @Autowired
    private ConvertService convertService;

    @Autowired
    private ValidationService validationService;


    public Double sum(String numberOne ,String numberTwo) {
        validationService.validate(numberOne, numberTwo);

        return convertService.toDouble(numberOne) + convertService.toDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        validationService.validate(numberOne, numberTwo);

        return convertService.toDouble(numberOne) - convertService.toDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        validationService.validate(numberOne, numberTwo);

        return convertService.toDouble(numberOne) * convertService.toDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {

        validationService.validate(numberOne, numberTwo);
        validationService.isZero(numberTwo, convertService);

        return convertService.toDouble(numberOne) / convertService.toDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo)  {
        validationService.validate(numberOne, numberTwo);

        return (convertService.toDouble(numberOne) + convertService.toDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String numberOne) {
        validationService.validate(numberOne);

        if (convertService.toDouble(numberOne) == 0){
            return 1D;
        }

        return Math.sqrt(convertService.toDouble(numberOne));
    }

}