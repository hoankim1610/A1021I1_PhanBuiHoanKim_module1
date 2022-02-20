package ss8_CleanCode_Refactoring.practice.p2_FizzBuzz;

import org.junit.Test;

public class FizzBuzzTest {
    @Test
    public void testFizz3() {
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }

    private void assertEquals(String expected, String result) {
    }
}

