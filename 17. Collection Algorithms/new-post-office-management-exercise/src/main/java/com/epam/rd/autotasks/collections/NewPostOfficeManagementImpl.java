package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;

public class NewPostOfficeManagementImpl implements NewPostOfficeManagement {
    private List<Box> parcels;

    /**
     * Creates own storage and appends all parcels into it.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection of parcels.
     * @throws NullPointerException if the parameter is {@code null}
     *                              or contains {@code null} values.
     */
    public NewPostOfficeManagementImpl(Collection<Box> boxes) {
        if(boxes == null)
            throw new NullPointerException();
        for(Box box : boxes)
            if(box== null)
                throw new NullPointerException();
        parcels = new ArrayList<>(boxes);
    }

    //private class to create an object of Box with only id
    private static class BoxPlaceholder extends Box {
        private final int id;

        public BoxPlaceholder(int id) {
            super(null, null, 0, 0, null, null, 0);
            this.id = id;
        }

        @Override
        public int getId() {
            return id;
        }
    }

    @Override
    public Optional<Box> getBoxById(int id) {
        Comparator<Box> byId = new Comparator<>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Integer.compare(o1.getId(),o2.getId());
            }
        };

        parcels.sort(byId);
        int index = Collections.binarySearch(parcels, new BoxPlaceholder(id), byId);

        if (index >= 0) {
            return Optional.of(parcels.get(index));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public String getDescSortedBoxesByWeight() {
        List<Box> temp = new ArrayList<>(parcels);
        temp.sort(new Comparator<>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getWeight(), o1.getWeight());
            }
        });
        List<String> result = new ArrayList<>();
        for (Box box : temp)
            result.add(box.toString());
        return String.join("\n",result);
    }


    @Override
    public String getAscSortedBoxesByCost() {
        List<Box> temp = new ArrayList<>(parcels);
        temp.sort(new Comparator<>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getCost().compareTo(o2.getCost());
            }
        });
        List<String> result = new ArrayList<>();
        for (Box box : temp)
            result.add(box.toString());
        return String.join("\n",result);
    }



    @Override
    public List<Box> getBoxesByRecipient(String recipient) {
        if (recipient == null) {
            throw new NullPointerException();
        }

        Comparator<Box> byRecipient = new Comparator<>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getRecipient().compareTo(o2.getRecipient());
            }
        };

        parcels.sort(byRecipient);

        Box searchKey = new Box(null, recipient, 0, 0, BigDecimal.ZERO, null, 0);

        int index = Collections.binarySearch(parcels, searchKey, byRecipient);


        if (index < 0) {
            return new ArrayList<>();
        }

        // Going to first occurrence of recipient
        int i = index;
        while(i>=0 && parcels.get(i).getRecipient().equals(recipient))
            i--;
        i++;

        //Getting all recipient from first to end
        List<Box> result = new ArrayList<>();
        while( i < parcels.size() && parcels.get(i).getRecipient().equals(recipient)) {
            result.add(parcels.get(i++));
        }
        return result;
    }


}