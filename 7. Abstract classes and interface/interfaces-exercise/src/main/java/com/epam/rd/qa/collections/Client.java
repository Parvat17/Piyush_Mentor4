package com.epam.rd.qa.collections;

import java.util.Arrays;
import java.util.Iterator;

public class Client implements Iterable<Deposit>{

    private final Deposit[] deposits;

    public Client(){
        deposits = new Deposit[10];
    }

    public Client(Deposit[] deposits) {
        if(deposits==null || deposits.length==0)
            throw new IllegalArgumentException();
        this.deposits = deposits;
    }

    public boolean addDeposit(Deposit deposit){
        for(int i=0;i<deposits.length;i++){
            if(deposits[i]==null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<Deposit> iterator() {
        return new DepositIterator();
    }

    private class DepositIterator implements Iterator<Deposit>{

        private int itr = 0;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            while (itr < deposits.length && deposits[itr] == null) {
                itr++;
            }
            return itr < deposits.length;
        }

        @Override
        public Deposit next() {
            return deposits[itr++];
        }
    }

    public void sortDeposits(){
        Arrays.sort(deposits, (d1,d2) ->{
            if(d1==null && d2==null) return 0;
            if(d1==null) return 1;
            if(d2==null) return -1;
            return d2.compareTo(d1);
        });
    }

    public int countPossibleToProlongDeposit(){
        int count=0;
        for(Deposit p : deposits){
            if (p instanceof Prolongable){
                Prolongable pr = (Prolongable) p;
                if (pr.canToProlong()){
                    count++;
                }
            }
        }
        return count;
    }
}