package ru.kravchenko.sb.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.BluetoothCodeRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.domain.entity.BluetoothCode;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BluetoothCodeRepositoryTest {

    @Autowired
    private BluetoothCodeRepository bluetoothCodeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Test
//    @Ignore
    public void insertBluetoothCodeToDict(){
        BluetoothCode bluetoothCode = new BluetoothCode();
        bluetoothCode.setBluetoothCode(UUID.randomUUID().toString());
        Room room = roomRepository.findByRoomNumber("10");
        bluetoothCode.setRoom(room);
        bluetoothCodeRepository.save(bluetoothCode);
    }

    @Test
    @Ignore
    public void dellAllBluetoothCode(){
        bluetoothCodeRepository.deleteAll();
    }

    @Test
//    @Ignore
    public void fillDictBluetoothCode() {
        for (int i = 1; i < 11; i++) {
            BluetoothCode bluetoothCode = new BluetoothCode();
            bluetoothCode.setBluetoothCode(UUID.randomUUID().toString());
            bluetoothCode.setRoom(roomRepository.findByRoomNumber(String.valueOf(i)));
            bluetoothCodeRepository.save(bluetoothCode);
        }
    }

    @Test
    @Ignore
    public void showAllBluetoothCodes(){
        List<BluetoothCode> bluetoothCodes = bluetoothCodeRepository.findAll();
        for (BluetoothCode bluetoothCode : bluetoothCodes) {
            System.out.println(bluetoothCode.getBluetoothCode());
            System.out.println(bluetoothCode.getRoom().getRoomNumber());
        }
    }

    @Test
    public void findByRoomId() {
        BluetoothCode bluetoothCode = bluetoothCodeRepository.findByRoomId("1f6f2162-8e8b-4963-9ce5-6aca3ae911ca");
        System.out.println(bluetoothCode.getBluetoothCode());
    }

}
