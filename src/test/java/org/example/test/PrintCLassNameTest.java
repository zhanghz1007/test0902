package org.example.test;

import org.junit.jupiter.api.Test;  // JUnit 5的Test注解

public class PrintCLassNameTest {

    @Test  // JUnit 5的@Test注解，不需要public
    void printClassName() {  // JUnit 5的方法可以是package-private，不需要public
        PrintCLassName printCLassName = new PrintCLassName();
        printCLassName.printClassName();

        PrintCLassName2 printCLassName2 = new PrintCLassName2();
        printCLassName2.printClassName();
    }
}