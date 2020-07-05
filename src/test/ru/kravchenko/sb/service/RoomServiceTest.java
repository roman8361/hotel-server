package ru.kravchenko.sb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.service.IRoomService;
import ru.kravchenko.sb.domain.entity.Guest;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomServiceTest {

    @Autowired
    private IRoomService roomService;

    @Test
    public void getAllGuestFromRoom(){
        List<Guest> guestList = roomService.getGuestFromRoom("4");
        for (Guest guest : guestList) {
            System.out.println(guest.getFirstName());
        }
    }

}
