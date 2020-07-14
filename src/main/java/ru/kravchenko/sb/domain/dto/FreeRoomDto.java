package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Date;

@Getter
@Setter
public class FreeRoomDto extends AbstractEntityDto {

    private String surName = "";

    private String roomNumber;

    private Date departureDate;

    private String arrivalRoom = "Комната свободная";

    public static final Comparator<FreeRoomDto> COMPARE_BY_ROOM_NUMBER = new Comparator<FreeRoomDto>() {
        @Override
        public int compare(FreeRoomDto lhs, FreeRoomDto rhs) {
            return Integer.valueOf(lhs.getRoomNumber()) .compareTo(Integer.valueOf(rhs.getRoomNumber()));
        }
    };

}
