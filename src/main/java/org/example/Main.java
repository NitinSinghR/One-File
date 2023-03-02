package org.example;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        Logger l = Logger.getLogger("com.api.jar");

        while (true) {
            l.info("Enter your choice\n1.Bank Account Management\n2.Basic Shape\n3.Credit Card Cloning\n4.Database Connection\n5.Point Cloning\n6.Student Management\n7.Frequency of words in File\n8.Tic-Tac-Toe\n9.Student Management using DS\n10.Calculator\n11.Contacts Management\n12.HashSet\n13.TreeMap\n14.HashMap\nAny other number to exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> Classes.bankAcc();
                case 2 -> Classes.basicShape();
                case 3 -> Classes.credit();
                case 4 -> Classes.data();
                case 5 -> Classes.point();
                case 6 -> Classes.student();
                case 7 -> Classes.files();
                case 8 -> Classes.ticTacToe();
                case 9 -> Classes.studentTest();
                case 10 -> Classes.calcTest();
                case 11 -> Classes.contactList();
                case 12 -> Classes.hashSet();
                case 13 -> Classes.treeSet();
                case 14 -> Classes.hashMap();
                default -> {
                    sc.close();
                    l.info("Enter Correct Option");
                    System.exit(0);
                }
            }
        }
    }

}