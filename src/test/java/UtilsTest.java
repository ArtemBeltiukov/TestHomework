import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    Utils utils = new Utils();
    int randomNum = 4;
    @ParameterizedTest
    @ValueSource(strings = {"Проверка кириллицы", "ツ улыбка", "\uD83C\uDF08 \uD83E\uDD84"})
    void concatenateWordsNonLatin(String value) {
        String[] words = value.split(" ");
        assertEquals(value,utils.concatenateWords(words[0],words[1]));
    }

    @Test
    void concatenateWordsNulls(){
        String actual = utils.concatenateWords(null,null);
        assertEquals(" ",actual);
    }

    @Test
    void concatenateWordsEmpty(){
        String actual = utils.concatenateWords("","");
        assertEquals(" ",actual);
    }
    @Disabled
    @Test
    void computeFactorial() {
        BigInteger actual = utils.computeFactorial(5);
        assertEquals(BigInteger.valueOf(120),actual);
    }

    @Test
    void testComputeFactorial() {
        assertEquals(BigInteger.valueOf(24),utils.computeFactorial(4));
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testComputeFactorialWithTimeout() {
        assertEquals(BigInteger.valueOf(24),utils.computeFactorial(randomNum));
    }
}