package br.com.erudio.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public double toDouble(String number) {
        return Double.parseDouble(number);
    }
}
