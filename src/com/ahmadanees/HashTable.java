package com.ahmadanees;


public class HashTable {

    //size of hash table
    public int size = 10;
    //hashtable of type LinkedList
    public LinkedList[] myHashSlots;

    public boolean useMultiplicationHashFunction;


    HashTable() {
        useMultiplicationHashFunction = true;
        myHashSlots = new LinkedList[size];
        for (int i=0; i<size; i++)
            myHashSlots[i] = new LinkedList();
    }

    HashTable(boolean shouldIUseMultiplicationHashFunction) {
        this.useMultiplicationHashFunction = shouldIUseMultiplicationHashFunction;
        useMultiplicationHashFunction = true;
        myHashSlots = new LinkedList[size];
        for (int i=0; i<size; i++)
            myHashSlots[i] = new LinkedList();
    }

    //adding person in hashtable slot based on name hash.
    public void add(Person p) {
        int myHashValue = hashIt(p.name);
        myHashSlots[myHashValue].add(p);
    }


    //method for getting a person from hashtable
    public Person getPerson(String name) {
        int val = hashIt(name );
        LinkedList.PersonNode temp = myHashSlots[val].head;
        while(temp != null) {
            if (temp.p.name.equals(name)) {
                return temp.p;
            }
            temp = temp.next;
        }
        System.out.println("That person is not in the hash table!");
        return null;
    }


    private int hashIt(String name) {
        if (this.useMultiplicationHashFunction) {
            return hashMultiplicationFunction(name);
        } else {
            return hashDivisionFunction(name);
        }
    }

    private int hashDivisionFunction(String name) {
        int sum = 0;
        int key = 0;

        for (int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            int ascii = (int) c;
            sum += ascii;
        }
        sum = sum % size;
        key = sum;

        return key;

    }

    private int hashMultiplicationFunction(String name) {
        int sum = 0;
        int key = 0;

        for (int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            int ascii = (int) c;
            sum += ascii;
        }
        double A = 0.6180339887;
        double var = sum*A;

        //function h(k)
        key = (int) Math.floor(size * (var - Math.floor(var)));

        return key;
    }

    public void printHashTable() {
        for (int i=0; i<size; i++) {
            if (myHashSlots[i] != null) {
                System.out.println("\nPrinting bucket: " + i);
                myHashSlots[i].printList();
            }
        }
    }
}
