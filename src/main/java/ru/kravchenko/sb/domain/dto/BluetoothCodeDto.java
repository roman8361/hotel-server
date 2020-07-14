package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BluetoothCodeDto extends AbstractEntityDto {

    private String bluetoothCode;

    private String roomNumber;

}
