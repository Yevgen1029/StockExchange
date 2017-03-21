package com.gmail.yevgen.service;

import com.gmail.yevgen.service.interfaces.RandomWalletValue;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class RandomWalletValueImpl implements RandomWalletValue {
    public BigDecimal getRandomValue() {
        Random random = new Random();
        Double val = random.nextDouble()*10000 + 1000;
        return BigDecimal.valueOf(val);
    }
}
