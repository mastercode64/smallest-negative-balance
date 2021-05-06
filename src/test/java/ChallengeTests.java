import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ChallengeTests {

    @Test
    public void multipleNamesWithNegativeValueUnorderedNamesTest() {
        List<List<String>> balance = Arrays.asList(
                Arrays.asList("bob", "alberto", "3"),
                Arrays.asList("alberto", "carlos", "6")
        );

        List<String> result = Challenge.getSmallestNegativeBalance(balance);
        Assertions.assertEquals(Arrays.asList("alberto", "bob"), result);
    }

    @Test
    public void multipleNamesWithSameNegativeValueOrderedNamesTest() {
        List<List<String>> balance = Arrays.asList(
                Arrays.asList("alberto", "bob", "3"),
                Arrays.asList("bob", "carlos", "6")
        );

        List<String> result = Challenge.getSmallestNegativeBalance(balance);
        Assertions.assertEquals(Arrays.asList("alberto", "bob"), result);
    }

    @Test
    public void multipleNamesWithDifferentNegativeValuesTest() {
        List<List<String>> balance = Arrays.asList(
                Arrays.asList("alberto", "bob", "3"),
                Arrays.asList("bob", "carlos", "5"),
                Arrays.asList("carlos", "maria", "6")
        );

        List<String> result = Challenge.getSmallestNegativeBalance(balance);
        Assertions.assertEquals(Arrays.asList("alberto"), result);
    }

    @Test
    public void noNegativeBalance() {
        List<List<String>> balance = Arrays.asList(
                Arrays.asList("alberto", "bob", "3"),
                Arrays.asList("bob", "carlos", "3"),
                Arrays.asList("carlos", "alberto", "3")
        );

        List<String> result = Challenge.getSmallestNegativeBalance(balance);
        Assertions.assertEquals(Arrays.asList("Nobody has a negative balance"), result);
    }
}
