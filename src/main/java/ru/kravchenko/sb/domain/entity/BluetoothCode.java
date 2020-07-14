package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kravchenko.sb.domain.dto.BluetoothCodeDto;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DICT_Bluetooth_Code")
public class BluetoothCode extends AbstractEntity {

    @Column(name = "bluetooth_code")
    private String bluetoothCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    public BluetoothCodeDto getDto(){
        BluetoothCodeDto bluetoothCodeDto = new BluetoothCodeDto();
        bluetoothCodeDto.setId(id);
        bluetoothCodeDto.setBluetoothCode(bluetoothCode);
        bluetoothCodeDto.setRoomNumber(room.getRoomNumber());

        return bluetoothCodeDto;
    }

}
