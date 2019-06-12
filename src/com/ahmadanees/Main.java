package com.ahmadanees;

import java.util.*;

public class Main {

    private static HashTable myFriendTable;

    public static void addNewUser(String name) {
        if (myFriendTable.getPerson(name) == null) {
            myFriendTable.add(new Person(name));
        } else {
            System.out.println("That person was already in the network. You are assigned that user!");
        }
    }

    public static void addFriendRelationship(String name1, String name2) {
        System.out.println("Connecting " + name1 + " & " + name2);
        myFriendTable.getPerson(name1).addFriend(myFriendTable, name2);
    }

    public static void removeFriendRelationship(String name1, String name2) {
        System.out.println("Removing relationship between " + name1 + " & " + name2);
        myFriendTable.getPerson(name1).removeFriend(myFriendTable, name2);
    }

    public static void listSomeoneFriend(String name) {
        Person friend = myFriendTable.getPerson(name);
        if (friend == null) {
            System.out.println("This person is not in the friend's network.");
            return;
        }
        friend.printAllMyFriends();
    }

    public static void checkRelationshipOfTwoPeople(String name1, String name2) {
        System.out.println(name1 + " & " + name2 + "are friends? " + myFriendTable.getPerson(name1).amIFriendsWith(myFriendTable, name2));
    }

    //menu template
    private static void printMenu() {
        System.out.println("\n\n(1) Create a new user.");
        System.out.println("(2) Add a friend.");
        System.out.println("(3) Remove a friend.");
        System.out.println("(4) Stalk someone.");
        System.out.println("(5) Check relationship of two people.");
        System.out.println("(6) Exit.");
        System.out.println("(7) Change hash function[default: multiplication].");
        System.out.println("Please select an option from the menu: ");
    }



    //main method
    public static void main(String[] args) {

        //static instance created in class
        //initialized in main mathod
        myFriendTable = new HashTable();



        List<String> lotsOfPeople = new ArrayList<>();

        //public void setLotsOfPeople(List<String> lotsOfPeople) {

            lotsOfPeople.add("Liam");
            lotsOfPeople.add("Noah");
            lotsOfPeople.add("William");
            lotsOfPeople.add("James");
            lotsOfPeople.add("Logan");
            lotsOfPeople.add("Benjamin");
            lotsOfPeople.add("Mason");
            lotsOfPeople.add("Elijah");
            lotsOfPeople.add("Oliver");
            lotsOfPeople.add("Jacob");
            lotsOfPeople.add("Lucas");
            lotsOfPeople.add("Michael");
            lotsOfPeople.add("Alexander");
            lotsOfPeople.add("Ethan");
            lotsOfPeople.add("Daniel");
            lotsOfPeople.add("Matthew");
            lotsOfPeople.add("Aiden");
            lotsOfPeople.add("Henry");
            lotsOfPeople.add("Joseph");
            lotsOfPeople.add("Jackson");
            lotsOfPeople.add("Samuel");
            lotsOfPeople.add("Sebastian");
            lotsOfPeople.add("David");
            lotsOfPeople.add("Carter");
            lotsOfPeople.add("Wyatt");
            lotsOfPeople.add("Emma");
            lotsOfPeople.add("Olivia");
            lotsOfPeople.add("Ava");
            lotsOfPeople.add("Isabella");
            lotsOfPeople.add("Sophia");
            lotsOfPeople.add("Mia");
            lotsOfPeople.add("Charlotte");
            lotsOfPeople.add("Amelia");
            lotsOfPeople.add("Evelyn");
            lotsOfPeople.add("Abigail");
            lotsOfPeople.add("Harper");
            lotsOfPeople.add("Emily");
            lotsOfPeople.add("Elizabeth");
            lotsOfPeople.add("Avery");
            lotsOfPeople.add("Sofia");
            lotsOfPeople.add("Ella");
            lotsOfPeople.add("Madison");
            lotsOfPeople.add("Scarlett");
            lotsOfPeople.add("Victoria");
            lotsOfPeople.add("Aria");
            lotsOfPeople.add("Grace");
            lotsOfPeople.add("Chloe");
            lotsOfPeople.add("Camila");
            lotsOfPeople.add("Penelope");
            lotsOfPeople.add("Riley");


            // populate network
            for (String personsName : lotsOfPeople) {
                System.out.println("Adding " + personsName);
                addNewUser(personsName);
            }


            // give everyone ~3 random friends
            Random randSeed = new Random();
            for (String personsName : lotsOfPeople) {
                for (int i = 0; i < 3; i++) {
                    int randVal = randSeed.nextInt(50);
                    if (!lotsOfPeople.get(randVal).equals(personsName)) {
                        addFriendRelationship(personsName, lotsOfPeople.get(randVal));
                    }
                }
            }








        int menuSelection = -1;
        String coreUser = null;

        //menu statements
        while (menuSelection != 6) {
            printMenu();

            Scanner inputScanner = new Scanner(System.in);
            String menuSelectionStr = inputScanner.nextLine();
            menuSelection = Integer.parseInt(menuSelectionStr);

            System.out.println("You selected: " + menuSelection);

            switch(menuSelection) {
                case 1:
                    System.out.println("Please enter name of new user:");
                    String nameNew = inputScanner.nextLine();
                    addNewUser(nameNew);
                    coreUser = nameNew;
                    break;
                case 2:
                    System.out.println("Please enter name of friend to add:");
                    String nameFriend = inputScanner.nextLine();
                    if (coreUser != null) {
                        addFriendRelationship(coreUser, nameFriend);
                    }
                    break;
                case 3:
                    System.out.println("Please enter name of friend to remove:");
                    String nameFriendRemove = inputScanner.nextLine();
                    if (coreUser != null) {
                        removeFriendRelationship(coreUser, nameFriendRemove);
                    }
                    break;
                case 4:
                    System.out.println("Please enter name of friend to stalk:");
                    String nameFriendStalk = inputScanner.nextLine();
                    listSomeoneFriend(nameFriendStalk);
                    break;
                case 5:
                    System.out.println("Please enter first name of two friends to stalk:");
                    String name = inputScanner.nextLine();
                    System.out.println("and the other friend ... ");
                    String name2 = inputScanner.nextLine();
                    checkRelationshipOfTwoPeople(name, name2);
                    break;
                case 7:
                    System.out.println("Welcome to the secret menu! \nPress '1' to use multiplication hash function" +
                            "or '2' to use division hash function:");
                    String valForHashFunction = inputScanner.nextLine();
                    if (valForHashFunction.equals("1")) {
                        myFriendTable.useMultiplicationHashFunction = true;
                        System.out.println("\n\nNow using Multiplication Hash Function!");
                    } else {
                        Person.useMultiplication = false;
                        System.out.println("\n\nNow using Division Hash Function!");
                    }
                    break;
                default:break;
            }
        }
        System.out.println("Thanks for using my really awesome program!");
    }
}
