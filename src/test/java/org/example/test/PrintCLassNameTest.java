package org.example.test;


import org.junit.Test;


class PrintCLassNameTest {

    @Test
    void printClassName() {
        PrintCLassName printCLassName = new PrintCLassName();
        printCLassName.printClassName();

        PrintCLassName2 printCLassName2 = new PrintCLassName2();
        printCLassName2.printClassName();
    }
}