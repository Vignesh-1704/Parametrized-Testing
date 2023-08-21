package com.m2p.JunitParametrizedTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"madam","radar","dad"})
    @DisplayName("Check whether String Is A Palindrome")
    void isPalindromeTest(String inputText){
        assertTrue(MyUtils.isPalindrome(inputText));
    }

}
