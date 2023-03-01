package org.example;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static Logger l=Logger.getLogger("com.api.jar");

    public static void main(String[] args) throws SQLException {

        while (true) {
            l.info("Enter your choice\n1.Bank Account Management\n2.Basic Shape\n3.Credit Card Cloning\n4.Database Connection\n5.Point Cloning\n6.Student Management\n");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> bankAcc();
                case 2 -> basicShape();
                case 3 -> credit();
                case 4 -> data();
                case 5 -> point();
                case 6 -> student();
                default->{
                    sc.close();
                    l.info("Enter Correct Option");
                    System.exit(0);
                }
            }
        }
    }
    private static void bankAcc() {
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
                    l.info("Closing");
                    return;
                }

            }
        }
    }
    private static void basicShape() {

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
                        type="circle";
                        l.info("Enter the radius\n");
                        radius = sc.nextDouble();
                        s1 = new Shape(type, radius);
                    }
                    case 2 -> {
                        type="rectangle";
                        l.info("Enter the length\n");
                        length = sc.nextInt();
                        l.info("Enter the width\n");
                        width = sc.nextDouble();
                        s1 = new Shape(type, length, width);
                    }
                    case 3 -> {
                        type="triangle";
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
            }catch(InputMismatchException e){
                    l.log(Level.INFO, () -> " " + e);
                }
            assert s1 != null;
            l.info("Area is " + s1.getArea());
            l.info("Perimeter is" + s1.getPerimeter());
        }
    }
    private static void credit(){

        l.info("Enter the credit card name:");
        String name = sc.next();
        l.info("Enter the credit card number:");
        String number = sc.next();
        l.info("enter the expiration date");
        String date=sc.next();

        l.info("Enter the credit card name:");
        String name1 = sc.next();
        l.info("Enter the credit card number:");
        String number1 = sc.next();
        l.info("enter the expiration date");
        String date1=sc.next();

        Card c=new Card(name,number,date);
        Card c1 = null;
        try {
            c1 = (Card) c.clone();
        }catch(CloneNotSupportedException e){
            l.log(Level.INFO,()->" "+e);
        }
        Card c2=new Card(name1,number1,date1);

        assert c1 != null;
        String e=""+c1.compare(c2);
        l.info(e);
    }
    private static void data() throws SQLException {

        l.info("Enter the Database url");
        String url=sc.next();
        l.info("Enter the username");
        String user=sc.next();
        l.info("Enter the Password");
        String pass=sc.next();

        Database t1=Database.getInstance();

        while(true){
            l.info("1.Create Connection\n2.Close Connection\n");
            int ch2=sc.nextInt();
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

    private static void point(){

        int x=0;
        int y = 0;
        int x1=0;
        int y1=0;
        try {
            l.info("Enter the x value:");
            x = sc.nextInt();
            l.info("Enter the y value:");
            y = sc.nextInt();

            l.info("Enter the x value:");
            x1 = sc.nextInt();
            l.info("Enter the y value:");
            y1 = sc.nextInt();
        }catch(InputMismatchException e){
            l.log(Level.INFO,()->" "+e);
        }
        Points p = new Points(x, y);
        Points p1=null;
        try {
            p1 = (Points) p.clone();
        }catch(CloneNotSupportedException e){
            l.log(Level.INFO,()->" "+e);
        }
        assert p1 != null;
        String e=p1.equals(x1,y1);
        l.info(e);
    }

    private static void student(){
            int gPA=0;
            String studentName = null;
            char gradelevel = 0;

            try{
                l.info("Enter the Student's Name:");
                studentName = sc.next();
                l.info("Enter the Student's GPA :");
                gPA = sc.nextInt();
                l.info("Enter the GradeLevel of the student:");
                gradelevel = sc.next().charAt(0);
            }catch(InputMismatchException e){
                l.log(Level.INFO,()->" "+e);
            }

            Student s1 = new Student(studentName, gPA, gradelevel);

            while(true) {
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
                        l.info("Closing");
                        return;
                    }
                }

            }
    }
}