package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    // implements student
    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if(weight<0.5 || weight>20.0)throw new IllegalArgumentException();
        if(addresser == null || recipient == null || addresser.isBlank() || recipient.isBlank() )
            throw new IllegalArgumentException();
        if(addresser.isEmpty() || addresser.isEmpty())throw new IllegalArgumentException();
        if(volume<=0 || volume>0.25) throw new IllegalArgumentException();
        if(value<=0) throw new IllegalArgumentException();
        Box box = new Box(addresser, recipient, weight, volume);
        BigDecimal cost = calculateCostOfBox(weight, volume, value);
        box.setCost(cost);
        listBox.add(box);
        return true;
    }

    // implements student
    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> l1 = new ArrayList<>();

        Iterator<Box> iterator = listBox.iterator();
        while(iterator.hasNext()) {
            Box box1 = iterator.next();
            if(box1.getRecipient().equals(recipient)){
                l1.add(box1);
                iterator.remove();
            }
        }
        return l1;
    }

    public void declineCostOfBox(double percent) {
        for(Box b2 : listBox)
        {
            BigDecimal oldCost = b2.getCost();
            BigDecimal per= BigDecimal.valueOf(percent);
            BigDecimal valueToBeReduced = per.divide(BigDecimal.valueOf(100),MathContext.DECIMAL64);
            valueToBeReduced = valueToBeReduced.multiply(oldCost,MathContext.DECIMAL64);
            BigDecimal finalCost= oldCost.subtract(valueToBeReduced,MathContext.DECIMAL64);
            b2.setCost(finalCost);


        }
    }


}
