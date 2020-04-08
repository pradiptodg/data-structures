package com.pdg.stack.challenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pdg.stack.challenges.PalindromeChecker.checkForPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    String s1, s2, s3, s4, s5, s6, s7;

    @BeforeEach
    void setUp() {
        s1 = "abccba";
        s2 = "Was it a car or a cat I saw?";
        s3 = "I did, did I?";
        s4 = "hello";
        s5 = "Don't nod";
        s6 = "";
        s7 = " ";
    }

    @Test
    void testCheckForPalindromeForEmpty() {
        assertEquals(com.pdg.queue.challenges.PalindromeChecker.checkForPalindrome(s6), true);
    }

    @Test
    void checkForPalindromeForSingle() {
        assertEquals(com.pdg.queue.challenges.PalindromeChecker.checkForPalindrome(s7), true);
    }

    @Test
    void testCheckForPalindrome() {

        assertEquals(checkForPalindrome(s1), true);
        assertEquals(checkForPalindrome(s2), true);
        assertEquals(checkForPalindrome(s3), true);
        assertEquals(checkForPalindrome(s4), false);
        assertEquals(checkForPalindrome(s5), true);
    }
}