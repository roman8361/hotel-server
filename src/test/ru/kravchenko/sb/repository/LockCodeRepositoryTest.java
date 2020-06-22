package ru.kravchenko.sb.repository;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.LockCodeRepository;
import ru.kravchenko.sb.entity.LockCode;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LockCodeRepositoryTest {

    @Autowired
    LockCodeRepository lockCodeRepository;

    @Test
    @Ignore
    public void fillDictLockCode() {
        for (int i = 1; i < 11; i++) {
            LockCode lockCode = new LockCode();
            lockCode.setLockCode(UUID.randomUUID().toString());
            lockCode.setRoomNumber(String.valueOf(i));
            lockCodeRepository.save(lockCode);
        }
    }

    @Test
    @Ignore
    public void findByRoomNumber(){
        LockCode lockCode = lockCodeRepository.findByRoomNumber("10");
        System.out.println(lockCode.getLockCode());
        Assert.assertEquals("53765abe-12af-4224-ba2a-683d0cff9779", lockCode.getLockCode());
    }

    @Test
    @Ignore
    public void dell(){
        lockCodeRepository.delete(lockCodeRepository.findByRoomNumber("10"));
    }

}
