package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {
    public LongDeposit(BigDecimal amt, int per) throws IllegalArgumentException{
        super(amt,per);

    }
    @Override
    public BigDecimal income() {
        BigDecimal totalAmountWithInterest = new BigDecimal("0");
        totalAmountWithInterest = totalAmountWithInterest.add(amount);

        if(period <= 6)
        {
            return new BigDecimal("0.00");
        }

        for(int i=6;i<period;i++)
        {
            totalAmountWithInterest = totalAmountWithInterest.add(totalAmountWithInterest.multiply(new BigDecimal("0.15")));
            System.out.println(totalAmountWithInterest.doubleValue());
        }
        totalAmountWithInterest = totalAmountWithInterest.setScale(2, RoundingMode.DOWN);
        return totalAmountWithInterest.subtract(amount);
    }
//        public static void main(String[] args) {
//        Deposit dep = new LongDeposit(new BigDecimal("1000"),8);
//        System.out.println(dep.income().doubleValue());
//    }
}
