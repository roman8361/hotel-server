package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;

public interface IRoomService {

    List<Guest> getGuestFromRoom(String roomNumber);

    Room findByRoomNumber(String roomNumber);

}
