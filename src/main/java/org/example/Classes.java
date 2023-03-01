package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Classes {
    static Scanner sc = new Scanner(System.in);
    static Logger l = Logger.getLogger("com.api.jar");

    static void bankAcc() {
        int amount;
        String holderName = null;
        int accountNumber = 0;
        int balance = 0;

        Scanner sc = new Scanner(System.in);

        try {
            l.info("Enter the Account Holders Name:");
            holderName = sc.next();
            l.info("Enter the Account Holders Number:");
            accountNumber = sc.nextInt();
            l.info("Enter the Balance:");
            balance = sc.nextInt();
        } catch (InputMismatchException e) {
            l.log(Level.INFO, () -> " " + e);
        }

        Bank b1 = new Bank(holderName, accountNumber, balance);
        while (true) {
            l.info("choose a option\n1.Deposit \n 2.Withdraw \n 3.Balance\n");
            int ch1 = sc.nextInt();
            switch (ch1) {
                case 1 -> {
                    l.info("Enter the Amount:\n");
                    amount = sc.nextInt();
                    b1.deposit(amount);
                }
                case 2 -> {
                    l.info("Enter the Amount:\n");
                    amount = sc.nextInt();
                    b1.withdraw(amount);
                }
                case 3 -> {
                    String e = String.valueOf(b1.getBalance());
                    l.info(e);
                }
                default -> {
                    l.info("Closing the Bank Account Management");
                    return;
                }

            }
        }
    }

    static void basicShape() {

        double radius;
        double length;
        double base;
        double width;
        double height;
        double a;
        double b;
        String type;

        Shape s1 = null;

        while (true) {
            l.info("Enter the type of shape\n1.circle\n2.rectangle\n3.triangle");
            int ch4 = sc.nextInt();
            try {
                switch (ch4) {
                    case 1 -> {
                        type = "circle";
                        l.info("Enter the radius\n");
                        radius = sc.nextDouble();
                        s1 = new Shape(type, radius);
                    }
                    case 2 -> {
                        type = "rectangle";
                        l.info("Enter the length\n");
                        length = sc.nextInt();
                        l.info("Enter the width\n");
                        width = sc.nextDouble();
                        s1 = new Shape(type, length, width);
                    }
                    case 3 -> {
                        type = "triangle";
                        l.info("Enter the length of a\n");
                        a = sc.nextDouble();
                        l.info("Enter the length of b\n");
                        b = sc.nextDouble();
                        l.info("Enter the base\n");
                        base = sc.nextDouble();
                        l.info("Enter the height\n");
                        height = sc.nextDouble();
                        s1 = new Shape(type, a, b, base, height);
                    }
                    default -> {
                        l.info("Enter the correct shape");
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                l.log(Level.INFO, () -> " " + e);
            }
            assert s1 != null;
            l.info("Area is " + s1.getArea());
            l.info("Perimeter is" + s1.getPerimeter());
        }
    }

    static void credit() {

        l.info("Enter the credit card name:");
        String name = sc.next();
        l.info("Enter the credit card number:");
        String number = sc.next();
        l.info("enter the expiration date");
        String date = sc.next();

        l.info("Enter the credit card name:");
        String name1 = sc.next();
        l.info("Enter the credit card number:");
        String number1 = sc.next();
        l.info("enter the expiration date");
        String date1 = sc.next();

        Card c = new Card(name, number, date);
        Card c1 = null;
        try {
            c1 = (Card) c.clone();
        } catch (CloneNotSupportedException e) {
            l.log(Level.INFO, () -> " " + e);
        } finally{
            l.info("Cloned Successfully");
        }
        Card c2 = new Card(name1, number1, date1);

        assert c1 != null;
        String e = "" + c1.compare(c2);
        l.info(e);
    }

    static void data() throws SQLException {

        l.info("Enter the Database url");
        String url = sc.next();
        l.info("Enter the username");
        String user = sc.next();
        l.info("Enter the Password");
        String pass = sc.next();

        Database t1 = Database.getInstance();

        while (true) {
            l.info("1.Create Connection\n2.Close Connection\n");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1 -> t1.connect(url, user, pass);
                case 2 -> t1.closeconnection();
                default -> {
                    l.info("Closing\n");
                    return;
                }
            }
        }
    }

    static void point() {

        int x = 0;
        int y = 0;
        int x1 = 0;
        int y1 = 0;
        try {
            l.info("Enter the x value:");
            x = sc.nextInt();
            l.info("Enter the y value:");
            y = sc.nextInt();

            l.info("Enter the x value:");
            x1 = sc.nextInt();
            l.info("Enter the y value:");
            y1 = sc.nextInt();
        } catch (InputMismatchException e) {
            l.log(Level.INFO, () -> " " + e);
        }
        Points p = new Points(x, y);
        Points p1 = null;
        try {
            p1 = (Points) p.clone();
        } catch (CloneNotSupportedException e) {
            l.log(Level.INFO, () -> " " + e);
        } finally{
            l.info("Cloned Successfully");
        }
        assert p1 != null;
        String e = p1.equals(x1, y1);
        l.info(e);
    }

    static void student() {
        int gPA = 0;
        String studentName = null;
        char gradelevel = 0;

        try {
            l.info("Enter the Student's Name:");
            studentName = sc.next();
            l.info("Enter the Student's GPA :");
            gPA = sc.nextInt();
            l.info("Enter the GradeLevel of the student:");
            gradelevel = sc.next().charAt(0);
        } catch (InputMismatchException e) {
            l.log(Level.INFO, () -> " " + e);
        }

        Student s1 = new Student(studentName, gPA, gradelevel);

        while (true) {
            l.info("choose a option\n1.Update GPA \n 2.Details \n");
            int ch3 = sc.nextInt();
            switch (ch3) {
                case 1 -> {
                    l.info("Enter the Updated GPA:\n");
                    int update = sc.nextInt();
                    s1.updateGPA(update);
                }
                case 2 -> l.info(s1.getDetails());
                default -> {
                    l.info("Closing the Student Management");
                    return;
                }
            }

        }
    }
    static void files() throws FileNotFoundException {
        String path=""+"C:\\Users\\Tringapps-user4\\Documents\\Paragraph.txt";

        Logger l=Logger.getLogger("com.api.jar");
        HashMap<String,Integer> map = new HashMap<>();

        File file = new File(path);
        Scanner sc1 = new Scanner(file);
        String word;

        while(sc1.hasNext())
        {
            word = sc1.next();
            if(map.containsKey(word))
            {
                int count = map.get(word) + 1;
                map.put(word,count);
            }
            else
            {
                map.put(word, 1);
            }
        }

        sc1.close();
        l.log(Level.INFO,()->"The values in files are: "+ map);

        List<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

        l.log(Level.INFO,()->"After Sorting the values in the file: "+ sorted);
    }
    static void ticTacToe(){
        int x;
        int y;
        int size = 3;

        Game g = new Game(size);
        Game g1= g;

        l.info("Board");
        g.printBoard(size);
        int stop=1;
        String t=g.tie(size);

        while (stop==1) {
            l.info("Enter the position Player 1");
            x = sc.nextInt();
            y = sc.nextInt();
            if (check(x,y,size)) {
                g.set(x, y, "X");
            }

            g.printBoard(size);

            if(g.win(g.board, size).equals("X")){
                l.info("Player 1 wins");
                stop=0;
                break;
            }

            l.info("Enter the position Player 2");
            x = sc.nextInt();
            y = sc.nextInt();
            if (check(x,y,size)) {
                g1.set(x, y, "O");
            }

            g.printBoard(size);

            if(g.win(g.board, size).equals("O")){
                l.info("Player 2 wins");
                stop=0;

            }
            if(t.equals("tie")){
                l.info("Match Draw");
                stop=0;
            }
        }
    }
    static boolean check(int x, int y, int size){
        return (x >= 0 && y >= 0) || (x < size && y < size);
    }
    static void studentTest(){
        String id;
        String name;
        double gpa;
        int i;

        String format = " %2s | %-10s | %7s ";

        l.info("Enter the number of students");
        int numOfStudent = sc.nextInt();

        LinkedList<StudentDS> studentList = new LinkedList<>();

        for (i = 0; i < numOfStudent; i++) {
            l.log(Level.INFO, () -> "Enter the Student ID ");
            id = sc.next();
            l.log(Level.INFO, () -> "Enter the Student Name ");
            name = sc.next();
            l.log(Level.INFO, () -> "Enter the Student GPA ");
            gpa = sc.nextDouble();
            studentList.add(new StudentDS(id, name, gpa));
        }

        l.info("Before Sorting");

        for (i = 0; i < studentList.size(); i++) {
            String s1 = String.format(format, "ID: " + studentList.get(i).getId(), "Name: " + studentList.get(i).getName(), "GPA: " + studentList.get(i).getGPA());
            l.info(s1);
        }

        studentList.sort((o1, o2) -> Double.compare(o2.getGPA(), o1.getGPA()));

        l.info("After Sorting");

        for (i = 0; i < studentList.size(); i++) {
            String s1 = String.format(format, "ID: " + studentList.get(i).getId(), "Name: " + studentList.get(i).getName(), "GPA: " + studentList.get(i).getGPA());
            l.info(s1);
        }
    }
    static void calcTest(){

        int a;
        int b;
        int ch;

        Calculator c = null;

        String v1="Enter first number\n";
        String v2="Enter second number\n";

        while(true)
        {
            l.info("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\nEnter your choice\n");
            ch=sc.nextInt();
            switch (ch) {
                case 1 -> {
                    c = new Addition();
                    l.info(v1);
                    a = sc.nextInt();
                    l.info(v2);
                    b = sc.nextInt();
                    c.set(a, b);
                }
                case 2 -> {
                    c = new Subtraction();
                    l.info(v1);
                    a = sc.nextInt();
                    l.info(v2);
                    b = sc.nextInt();
                    c.set(a, b);
                }
                case 3 -> {
                    c = new Multiplication();
                    l.info(v1);
                    a = sc.nextInt();
                    l.info(v2);
                    b = sc.nextInt();
                    c.set(a, b);
                }
                case 4 -> {
                    c = new Division();
                    l.info(v1);
                    a = sc.nextInt();
                    l.info(v2);
                    b = sc.nextInt();
                    c.set(a, b);
                }
                default -> {
                    l.info("Invalid Input\n");
                    return;
                }
            }
            Calculator finalC = c;
            l.log(Level.INFO, () -> "Result: " + finalC.calculate(finalC.getA(), finalC.getB()));
        }
    }
    static void contactList(){
        int ch;
        Contactsops c = new Contactsops();

        while (true) {
            l.info("Enter your Choice\n1. Add contacts\n2.Remove Contact\n3.Search Contact\n4.Print Contacts");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    l.info("Enter the name");
                    String s1 = sc.next();
                    l.info("Enter the number of contact: ");
                    String s2 = sc.next();
                    l.info("Enter the email");
                    String s3 = sc.next();
                    c.addElement(s1, s2, s3);
                }
                case 2 -> {
                    l.info("Enter the number to remove: ");
                    String s2 = sc.next();
                    c.deleteElement(s2);
                }
                case 3 -> {
                    l.info("Enter the number to search: ");
                    String s2 = sc.next();
                    c.searchElement(s2);
                }
                case 4 -> c.printElements();
                default -> {
                    l.info("Closing the Contact Management");
                    return;
                }
            }
        }
    }
}
