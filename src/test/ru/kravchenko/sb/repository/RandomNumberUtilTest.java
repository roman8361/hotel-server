package ru.kravchenko.sb.repository;

import org.junit.Test;
import ru.kravchenko.sb.util.GenerateRandomNumberUtils;

public class RandomNumberUtilTest {

    @Test
    public void testRandomNumberUtils(){
        for (int i = 0; i < 100; i++) {
            System.out.println(GenerateRandomNumberUtils.getRandomInteger(1000, 10000));
        }
    }

    @Test
    public void testStringRandomValue() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(GenerateRandomNumberUtils.getStringRandomValue());
        }
    }

}
