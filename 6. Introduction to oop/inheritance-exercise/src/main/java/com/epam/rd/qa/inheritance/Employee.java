package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class Employee {
    private final String name;
    private final BigDecimal salary;
        private BigDecimal bonus;
    public String getName(String name)throws IllegalArgumentException
    {
//        if(name == null || name.isEmpty() || name.equals(" ")) throw new IllegalArgumentException();
//        this.name = name;
//        int i,c=0;
//        for(i=0;i<name.length();i++)
//        {
//            if(name.charAt(i)==' ')
//            {
//                c=i;
//            }
//        }
//        return name.substring(c+1);
        return name;
    }
    public String getFullName()
    {
        return this.name;
    }

    public BigDecimal getSalary(){

        return salary;
    }
    public Employee(String name, BigDecimal salary)throws IllegalArgumentException
    {
        if(name == null ||salary == null|| name.trim().isEmpty() || name.isEmpty() ||salary.compareTo(BigDecimal.ZERO) < 0 ||salary.compareTo(BigDecimal.ZERO) == 0||
                name.equals(" ")) throw new IllegalArgumentException();
        this.name=name;
        this.salary=salary;
    }
    public void setBonus(BigDecimal bonus)throws IllegalArgumentException
    {
        if(bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0 ||bonus.compareTo(BigDecimal.ZERO) == 0)throw new IllegalArgumentException();
        this.bonus=bonus;
    }

    public BigDecimal toPay()
    {
        return getSalary().add(bonus);
    }
}
