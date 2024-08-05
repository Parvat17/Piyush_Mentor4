package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {
    public BaseDeposit(BigDecimal amount, int period) throws IllegalArgumentException{
        super(amount,period);
    }
    @Override
    public BigDecimal income(){
        BigDecimal totalAmountWithInterest = new BigDecimal("0");
        totalAmountWithInterest = totalAmountWithInterest.add(amount);
        for(int i=0;i<period;i++)
        {
            totalAmountWithInterest = totalAmountWithInterest.add(totalAmountWithInterest.multiply(new BigDecimal("0.05")));
            System.out.println(totalAmountWithInterest.doubleValue());
        }
        totalAmountWithInterest = totalAmountWithInterest.setScale(2, RoundingMode.DOWN);
        return totalAmountWithInterest.subtract(amount);
    }

//    public static void main(String[] args) {
//        Deposit dep = new BaseDeposit(new BigDecimal("1000"),3);
//        System.out.println(dep.income().doubleValue());
//    }
}
