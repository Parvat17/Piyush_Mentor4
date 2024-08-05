package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;

public abstract class Deposit {
    protected final  BigDecimal amount;
    protected final int period;

    public BigDecimal getAmount(){
        return  amount;
    }
    public int getPeriod(){
        return period;
    }

    protected Deposit(BigDecimal depositAmount , int depositPeriod)
    {
        if(depositAmount == null || depositAmount.compareTo(new BigDecimal("0")) < 1 || depositPeriod <= 0)
        {
            throw new IllegalArgumentException();
        }
        amount= depositAmount;
        period = depositPeriod;
    }
    abstract public BigDecimal income();
}

