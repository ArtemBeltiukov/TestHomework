import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
    public String concatenateWords(String... words){
        return Arrays.stream(words)
                .map(x->{
                    if (x == null){
                        x="";
                    }
                    return x;
                })
                .collect(Collectors.joining(" "));
    }

    public BigInteger computeFactorial(int n){
        if(n < 2) return BigInteger.valueOf(1);
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

}
