package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

public class Company{
    private Employee[] employees;
    BigDecimal total =new BigDecimal(0);

    public Company(Employee[] employees) {
        if(employees==null) throw new IllegalArgumentException();
        this.employees=employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus)
    {
        for(Employee e : employees)
        {
            e.setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay() {
        for(Employee e : employees)
        {
            if(e.toPay()!=null){
                total=total.add(e.toPay());
            }

        }
        return total;
    }

    public String nameMaxSalary()
    {
        long maxValue = 0L;
        long tempMax = 0L;
        String fullName="";
        for(Employee e : employees)
        {
            tempMax = e.toPay().longValue();
            if(maxValue < tempMax)
            {
                maxValue = tempMax;
                fullName = e.getFullName();
            }
        }
        return fullName;
    }
}
