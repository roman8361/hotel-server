package ru.kravchenko.sb.utils;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

    private final long TEN_MIN = 60000; //10 min

    private final long TWO_SECOND = 200; //2 second

    @Test
    @SneakyThrows
    public void dateTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            Thread.sleep(1000);
        }
    }

    @Test
    public void addFiveMinToCurrentDate() {
        Date afterAddingTenMins = getDatePlusTenMinToCurrentDate(TEN_MIN);
        System.out.println("new Date(): " + new Date());
        System.out.println("afterAddingTenMins: " + afterAddingTenMins);
    }

    @Test
    public void compareDate() {
        Date currentDate = new Date();
        System.out.println(currentDate.before(getDatePlusTenMinToCurrentDate(TEN_MIN)));
    }

    @Test
    @SneakyThrows
    public void compareWithPauseTest(){
        Date currentDateWithTwoSecond = getDatePlusTenMinToCurrentDate(TWO_SECOND);

        System.out.println(new Date());
        System.out.println(currentDateWithTwoSecond);
        System.out.println(new Date().before(currentDateWithTwoSecond));

        Thread.sleep(3000);

        System.out.println(new Date());
        System.out.println(currentDateWithTwoSecond);
        System.out.println(new Date().before(currentDateWithTwoSecond));
    }

    private Date getDatePlusTenMinToCurrentDate(Long second) {
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        return new Date(t + (10 * second));
    }

}
