package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class SalesPerson extends Employee {
    private final int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name,salary);
        if(percent<0) throw new IllegalArgumentException();
        this.percent=percent;
    }

@Override
    public void setBonus(BigDecimal bonus) {
    if(bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0 ||bonus.compareTo(BigDecimal.ZERO) == 0) throw new IllegalArgumentException();
    if(percent>200)
    {
        super.setBonus(bonus.multiply(BigDecimal.valueOf(3)));
    }
   else if(percent>100)
        {
            super.setBonus(bonus.multiply(BigDecimal.valueOf(2)));
        }

        else {
            super.setBonus(bonus);
        }
    }
}
