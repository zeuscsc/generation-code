package com.zeuschiu.types;

import java.io.Console;

public class MyFirstInput {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Please enter your name ");
        String name = console.readLine();
        UserProfile.Instant.name=name;
        System.out.println("My name is "+ name);
    }
}
