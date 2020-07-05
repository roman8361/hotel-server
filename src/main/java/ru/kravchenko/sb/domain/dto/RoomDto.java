package ru.kravchenko.sb.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto extends AbstractEntityDto {

    private String roomNumber;

    private Boolean isBusy = false;

    private String bluetoothCodeId;

    public RoomDto(String roomNumber, Boolean isBusy, String bluetoothCodeId) {
        this.roomNumber = roomNumber;
        this.isBusy = isBusy;
        this.bluetoothCodeId = bluetoothCodeId;
    }

}
