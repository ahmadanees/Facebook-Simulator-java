package com.ahmadanees;

public class LinkedList {

    public class PersonNode {
        Person p;
        PersonNode next;

        PersonNode(Person newP) {
            this.p = newP;
            this.next = null;
        }
    }




    PersonNode head; // head of list



    LinkedList() {
        head = null;
    }

    public void add(Person newPerson) {

        if (head == null) {
            head = new PersonNode(newPerson);
        } else {
            PersonNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new PersonNode(newPerson);
        }
    }

    public void remove(Person newPerson) {
        if (head == null) {
            return;
        } else {


            if (head.p == newPerson) {
                head = head.next;
                return;
            }

            PersonNode prev = head;
            PersonNode temp = head.next;
            while (temp != null) {
                if (temp.p == newPerson) {
                    prev = temp.next;
                }
                temp = temp.next;
            }

            return;

        }
    }

    public boolean containsPerson(Person person) {
        PersonNode temp = head;
        while(temp != null) {
            if (temp.p == person) {return true;}
            temp= temp.next;
        }
        return false;
    }

    public void printList() {
        PersonNode temp = head;
        while(temp != null) {
            System.out.print(temp.p.name + " , ");
            temp = temp.next;
        }
    }
}

