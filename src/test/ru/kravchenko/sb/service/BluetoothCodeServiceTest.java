package ru.kravchenko.sb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.service.IBluetoothCodeService;
import ru.kravchenko.sb.domain.dto.BluetoothCodeDto;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BluetoothCodeServiceTest {

    @Autowired
    IBluetoothCodeService bluetoothCodeService;

    @Test
    public void findAllBluetoothCode(){
        List<BluetoothCodeDto> list = bluetoothCodeService.findAllBluetoothCodes();
        list.forEach(p-> System.out.println(p.getBluetoothCode() + " " + p.getRoomNumber()));
    }

}
