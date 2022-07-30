package codility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DayOfTheWeek {
    public static void main(String[] args) {

        String ans = solution("Sun", 2100);
        System.out.println(ans);

    }

    public static String solution(String S, int K) {
        // write your code in Java SE 11
        if(!getWeekDaysMap().containsValue(S)) return null;
        AtomicInteger dayAfterMonday = new AtomicInteger();

        getWeekDaysMap().forEach((key, value) -> {
            if (value.equalsIgnoreCase(S)) {
                dayAfterMonday.set(key);
            }
        });
        System.out.println("log day after monday:"+dayAfterMonday);
        System.out.println("log day:" +getWeekDaysMap().get(K % 7 + dayAfterMonday.get()));
        return getWeekDaysMap().get(K % 7 + dayAfterMonday.get());
    }

    private static Map<Integer, String> getWeekDaysMap() {
        Map<Integer, String> weekDaysMap = new HashMap<>();
        weekDaysMap.put(1, "Mon");
        weekDaysMap.put(2, "Tue");
        weekDaysMap.put(3, "Wed");
        weekDaysMap.put(4, "Thu");
        weekDaysMap.put(5, "Fri");
        weekDaysMap.put(6, "Sat");
        weekDaysMap.put(7, "Sun");

        return weekDaysMap;
    }
}
