package org.example.ex02;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationPresentation {
    private static int count = 0;
    private int value;

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("setUpBeforeAll()");
    }

    @BeforeEach
    void setUpBeforeEach() {
        value = ++count;
        System.out.println("setUpBeforeEach() - value: " + value);
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("tearDownAfterEach() - value: " + value);
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("tearDownAfterAll()");
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        System.out.println("test2() - value: " + value);
        assertEquals(2, value);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        System.out.println("test1() - value: " + value);
        assertEquals(1, value);
    }


    @Test
    @Disabled
    @DisplayName("Disabled Test")
    void disabledTest() {
        System.out.println("disabledTest()");
    }

}
