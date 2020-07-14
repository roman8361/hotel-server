package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.dto.FreeRoomDto;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.dto.RoomDto;

import java.util.List;

public interface IRoomService {

    List<GuestDto> getGuestFromRoom(String roomNumber);

    RoomDto findByRoomNumber(String roomNumber);

    List<FreeRoomDto> getFreeRoom();

}
