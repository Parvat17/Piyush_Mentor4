package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private final List<Box> parcels = new LinkedList<>();

    public NewPostOfficeStorageImpl() {
        // Default constructor
    }

    public NewPostOfficeStorageImpl(Collection<Box> boxes) {
        if (boxes == null || boxes.contains(null)) {
            throw new NullPointerException();
        }
        parcels.addAll(boxes);
    }


    @Override
    public boolean acceptBox(Box box) {
        if(box==null )
            throw new NullPointerException();
        parcels.add(box);
        return true;


    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if(boxes==null || boxes.contains(null))throw new NullPointerException();
        Iterator<Box> it = boxes.iterator();
        while ((it.hasNext()))
        {
            if( it.next()==null )
                throw new NullPointerException();
        }
        parcels.addAll(boxes);
        return true;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if(boxes==null )throw new NullPointerException();
        for(Box b : boxes)
        {
            if(b==null)throw new NullPointerException();
        }
        if(parcels.removeAll(boxes))
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if(predicate==null)throw new NullPointerException();
        List<Box> b1=new LinkedList<>();
        Iterator<Box> it = parcels.iterator();
        while(it.hasNext())
        {
            Box b = it.next();
            if(predicate.test(b))
            {
                b1.add(b);
                it.remove();
            }
        }
        return b1;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if(weight<=0.0d)throw new IllegalArgumentException();
        List<Box> box1;
        box1 = searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return box.getWeight()<weight;
            }
        });
        return box1;
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if(cost.floatValue()<0.0f) throw new IllegalArgumentException();
        List<Box> box1 = searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return box.getCost().compareTo(cost) > 0;
            }
        });
        return box1;
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if(volume<0.0)throw new IllegalArgumentException();
        List<Box> box2;
        box2 = searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return (box.getVolume() >= volume);
            }
        });
        return box2;
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        List<Box> result = new LinkedList<>();

        for(Box box : parcels)
        {
            if(predicate.test(box))
            {
                result.add(box);
            }
        }
        return result;

    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        for (Box b : parcels) {
            if (predicate.test(b)) {
                b.setOfficeNumber(newOfficeNumber);
            }
        }
    }
}
