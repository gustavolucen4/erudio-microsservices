package br.com.erudio.service;

import br.com.erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void isZero(String numberTwo, ConvertService convertService) {
        if (convertService.toDouble(numberTwo) == 0){
            throw new UnsuportedMathOperationException("Cannot divide by 0");
        }
    }

    public void validate(String numberOne) {
        if( !isNumeric(numberOne)){
            throw new UnsuportedMathOperationException("Please, set a numeric value!");
        }
    }

    public void validate(String numberOne, String numberTwo) {
        if( !isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please, set a numeric value!");
        }
    }

    private boolean isNumeric(String number) {
        if (number == null) return false;

        String auxNumber = number.replaceAll(",", ".");
        return auxNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
