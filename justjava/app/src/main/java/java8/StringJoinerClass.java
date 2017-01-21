package java8;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by codebased on 24/09/16.
 */
public class StringJoinerClass {

    @TargetApi(Build.VERSION_CODES.N)
    public void play() {

        // separator , prefix and postfix.
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();

        System.out.println(desiredString);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers = numbers.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));

        System.out.println(commaSeparatedNumbers);

        for (int i = 0; i <10 ; ++i) {
            System.out.println(i);
        }
    }
}
