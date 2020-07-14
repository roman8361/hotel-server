package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.dto.FreeRoomDto;

import java.util.List;

public interface IFreeRoomService {

    List<FreeRoomDto> getFreeRoom();

}
