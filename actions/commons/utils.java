package commons;

import java.util.List;
import java.util.stream.Collectors;

public class utils {
    public static List<String> orderListString(List<String> listString) {
        return listString.stream().sorted().collect(Collectors.toList());
    }
}
