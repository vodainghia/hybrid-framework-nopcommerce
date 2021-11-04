package commons;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class utils {
    public static List<String> orderListString(List<String> listString) {
        return listString.stream().sorted().collect(Collectors.toList());
    }

    public static String getCurrentDatetimeAsFormat(String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-7"));
        return simpleDateFormat.format(calendar.getTime());
    }
}