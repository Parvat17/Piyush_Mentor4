package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class Client {
    private Deposit[] deposits;
    int depositIndex;
    BigDecimal totalIncome,maxIncome;

    public Client() {
        deposits=new Deposit[10];
        totalIncome = BigDecimal.ZERO;
        maxIncome = BigDecimal.ZERO;
    }

    public boolean addDeposit(Deposit deposit) throws IllegalArgumentException{
        if(deposit == null) throw new IllegalArgumentException();
        if(depositIndex >= 10) return false;
        deposits[depositIndex] = deposit;
        depositIndex++;
        return true;
    }

    public BigDecimal getmaxIncome()
    {
        for(Deposit deposit : deposits)
        {
            if(deposit != null)
            {
                if(maxIncome.compareTo(deposit.income()) < 1)
                {
                    maxIncome = deposit.income();
                }
            }
        }
        return maxIncome;
    }

    public BigDecimal totalIncome() {

        for(Deposit deposit  : deposits)
        {
            if(deposit != null )
            {
                totalIncome = totalIncome.add(deposit.income());
            }
        }
        return totalIncome;
    }

    public BigDecimal maxIncome() {
        return getmaxIncome();
    }

    public BigDecimal getIncomeByNumber(int number) {
        if(number > 9 || !(number >= 0 && number < depositIndex)) return new BigDecimal("0.00");
        return deposits[number].income();
    }
}
