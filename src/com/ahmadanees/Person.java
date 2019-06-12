package com.ahmadanees;


public class Person {



    public String name;
    public LinkedList listOfFriends;

    Person(String name) {
        this.name = name;
        listOfFriends = new LinkedList();
    }

    public void addFriend(HashTable myFriendTable, String name) {

        Person friend = myFriendTable.getPerson(name);
        if (friend == null) {
            System.out.println("That person doesn't exist!");
        }

        listOfFriends.add(friend);
        if (!friend.amIFriendsWith(myFriendTable, this.name))
            friend.addFriend(myFriendTable, this.name);
    }

    public void removeFriend(HashTable myFriendTable, String name) {
        Person friend = myFriendTable.getPerson(name);
        if (friend == null) {
            System.out.println("That person doesn't exist!");
        }

        listOfFriends.remove(friend);
        if (friend.amIFriendsWith(myFriendTable, this.name))
            friend.removeFriend(myFriendTable, this.name);
    }

    public boolean amIFriendsWith(HashTable myFriendTable, String name) {
        Person friend = myFriendTable.getPerson(name);
        return listOfFriends.containsPerson(friend);
    }

    public void printAllMyFriends() {

        System.out.println("\n\nMy List of friends is:");
        listOfFriends.printList();
        System.out.println("\n\n");
    }

    public boolean isMyFriend(HashTable myFriendTable, String nameOfFriend) {
        Person friend = myFriendTable.getPerson(nameOfFriend);
        return listOfFriends.containsPerson(friend);
    }

    static boolean useMultiplication = true;
}

