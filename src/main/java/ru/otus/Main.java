package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner in=new Scanner(System.in);
        System.out.println("Hello! Are you ready? Yes(Y/y) or No(N/n)?");
        if(in.nextLine().equalsIgnoreCase("Y")){
            System.out.println("Yes");
        }
        else {
            System.out.println("Good bye");
        }
    }
}