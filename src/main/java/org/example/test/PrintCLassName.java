package org.example.test;

public class PrintCLassName {
    public void printClassName() {
        PrintMsg printMsg = new PrintMsg() {
            @Override
            public void print() {
                System.out.println(this.getClass().getName());
            }
        };
    }
}
