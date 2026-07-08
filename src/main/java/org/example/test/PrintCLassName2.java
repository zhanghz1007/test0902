package org.example.test;

public class PrintCLassName2 {
    public void printClassName() {
        PrintMsg printMsg = new PrintMsg() {
            @Override
            public void print() {
                System.out.println(this.getClass().getName());
            }
        };
        printMsg.print();
    }
}
