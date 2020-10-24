package ru.mirea;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashTable main=new HashTable();
        main.add("key");
        main.add("yek");
        main.add("abc");
        main.add("abg");
        main.add("qwe");
        System.out.println("-----------------------");

        main.find("eyk");
        main.show();
        System.out.println("-----------------------");

        System.out.println("Удалим key и yek");
        main.remove("key");
        main.remove("yek");
        main.find("key");
        main.show();
        System.out.println("-----------------------");

        main.add("key");
        main.add("yek");
        main.show();
        main.find("yek");
        main.find("key");
        main.show();


    }


}
