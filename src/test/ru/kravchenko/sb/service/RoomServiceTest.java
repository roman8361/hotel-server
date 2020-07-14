package ru.kravchenko.sb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.service.IRoomService;
import ru.kravchenko.sb.domain.dto.FreeRoomDto;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.dto.RoomDto;

import java.util.Comparator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomServiceTest {

    @Autowired
    private IRoomService roomService;

    @Test
    public void getAllGuestFromRoom() {
        List<GuestDto> tempList = roomService.getGuestFromRoom("6");
        Assert.assertEquals(2, tempList.size());
        tempList = roomService.getGuestFromRoom("2");
        Assert.assertEquals(1, tempList.size());
    }

    @Test
    public void findByRoomNumber() {
        RoomDto roomDto = roomService.findByRoomNumber("3");
        Assert.assertNotNull(roomDto);
        Assert.assertNotNull(roomDto.getBluetoothCodeId());
        Assert.assertNotNull(roomDto.getIsBusy());
        Assert.assertEquals("3", roomDto.getRoomNumber());
    }

    @Test
    public void getFreeRoom() {
        List<FreeRoomDto> list = roomService.getFreeRoom();
        list.forEach(f -> System.out.println(f.getRoomNumber() + " " +  f.getArrivalRoom() + " " + f.getSurName()));
        System.out.println("######");

        list.stream().sorted(Comparator.comparing(FreeRoomDto::getRoomNumber)).forEach(f ->
                System.out.println(f.getRoomNumber() + " " +  f.getArrivalRoom() + " " + f.getSurName()));

        list.sort(FreeRoomDto.COMPARE_BY_ROOM_NUMBER);
        System.out.println("######");
        list.forEach(f -> System.out.println(f.getRoomNumber() + " " +  f.getArrivalRoom() + " " + f.getSurName()));
    }

}
