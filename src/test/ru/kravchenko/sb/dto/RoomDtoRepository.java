package ru.kravchenko.sb.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.domain.dto.RoomDto;
import ru.kravchenko.sb.domain.entity.BluetoothCode;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomDtoRepository {

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void insertRoom(){
      //  RoomDto roomDto = new RoomDto();
    }

//    private RoomDto getNewRoomDto() {
//        BluetoothCode bluetoothCode
//        RoomDto roomDto = new RoomDto("1", Boolean.TRUE, );
//
//        return roomDto;
//
//
//    }

}
