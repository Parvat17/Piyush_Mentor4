package com.epam.rd.qa.collections;

import java.math.BigDecimal;



public abstract class Deposit implements Comparable<Deposit>{

    protected final BigDecimal amount;
    protected final int period;

    protected Deposit(BigDecimal depositAmount, int depositPeriod) {
        if(depositAmount==null||depositAmount.doubleValue()<=0||depositPeriod<=0)
            throw new IllegalArgumentException();
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    protected abstract BigDecimal income();

    @Override
    public int compareTo(Deposit o) {
        BigDecimal thisTotal = this.amount.add(this.income());
        BigDecimal oTotal = o.amount.add(o.income());
        return thisTotal.compareTo(oTotal);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Deposit deposit = (Deposit) obj;
        return period == deposit.period &&
                amount.equals(deposit.amount);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + period;
        return result;
    }
}