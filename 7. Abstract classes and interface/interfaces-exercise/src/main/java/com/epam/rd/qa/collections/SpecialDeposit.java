package com.epam.rd.qa.collections;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount,depositPeriod);
    }

    @Override
    protected BigDecimal income() {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal amt = getAmount();
        for(int i=1;i<=getPeriod();i++){
            BigDecimal temp = amt.multiply(BigDecimal.valueOf(0.01*i));
            sum = sum.add(temp);
            amt = amt.add(temp);
        }
        return sum.setScale(2, RoundingMode.DOWN);
    }


    @Override
    public boolean canToProlong() {
        return getAmount().doubleValue() > 1000;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return obj instanceof SpecialDeposit;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}