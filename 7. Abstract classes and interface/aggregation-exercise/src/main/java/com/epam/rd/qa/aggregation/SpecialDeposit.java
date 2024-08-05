package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

//import static com.epam.rd.qa.aggregation.BaseDeposit.getRoundNum;
//import static com.epam.rd.qa.aggregation.BaseDeposit.getRoundedIncome;

public class SpecialDeposit extends Deposit {
    // TODO Place your code here
    public SpecialDeposit(BigDecimal amount, int period) throws IllegalArgumentException{
        super(amount,period);
    }
    @Override
    public BigDecimal income() {
        BigDecimal totalAmountWithInterest = new BigDecimal("0");
        totalAmountWithInterest = totalAmountWithInterest.add(amount);
        double increment = 0.00;
        for(int i=0;i<period;i++)
        {
            increment = increment + 0.01;
            totalAmountWithInterest = totalAmountWithInterest.add(totalAmountWithInterest.multiply(new BigDecimal(String.valueOf(increment))));
            System.out.println(totalAmountWithInterest.doubleValue());
        }
        totalAmountWithInterest = totalAmountWithInterest.setScale(2, RoundingMode.DOWN);
        return totalAmountWithInterest.subtract(amount);
    }
//        public static void main(String[] args) {
//        Deposit dep = new SpecialDeposit(new BigDecimal("1000"),2);
//        System.out.println(dep.income().doubleValue());
//    }
}
