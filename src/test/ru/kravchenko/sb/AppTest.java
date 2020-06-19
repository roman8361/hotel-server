package ru.kravchenko.sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Roman Kravchenko
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Test
    public void test(){
        System.out.println("Hello world!!");
    }

}
