package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.BluetoothCodeRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.RoomService;
import ru.kravchenko.sb.domain.dto.FreeRoomDto;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.dto.RoomDto;
import ru.kravchenko.sb.domain.entity.BluetoothCode;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private BluetoothCodeRepository bluetoothCodeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

//    @Override
//    public List<Guest> getGuestFromRoom(String roomNumber) {
//        Room room = roomRepository.findByRoomNumber(roomNumber);
//        return room.getGuests();
//    }
//
//    @Override
//    public Room findByRoomNumber(String roomNumber) {
//        return roomRepository.findByRoomNumber(roomNumber);
//    }

    ///////

    private Room convertDtoToRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setBluetoothCode(getBluetoothCode(roomDto.getBluetoothCodeId()));
        room.setIsBusy(roomDto.getIsBusy());

        return room;
    }

    private BluetoothCode getBluetoothCode(String codeId) {
        return bluetoothCodeRepository.findById(codeId).orElse(null);
    }

    @Override
    public List<GuestDto> getGuestFromRoom(String roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        List<Guest> guests = guestRepository.getAllGuestFromRoomId(room.getId());
        return guests.stream().map(Guest::getDto).collect(Collectors.toList());
    }

    @Override
    public RoomDto findByRoomNumber(String roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        return room.getDto();
    }

    @Override
    public List<FreeRoomDto> getFreeRoom() {
        List<Room> roomList = roomRepository.findAll();
        List<FreeRoomDto> result = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getIsBusy()) {
                result.add(convertBusyRoomToFreeRoomDto(room));
                continue;
            }
            result.add(convertRoomToFreeRoomDto(room));
        }

        return result;
    }

    private FreeRoomDto convertRoomToFreeRoomDto(Room room) {
        FreeRoomDto freeRoomDto = new FreeRoomDto();
        freeRoomDto.setRoomNumber(room.getRoomNumber());

        return freeRoomDto;
    }

    private FreeRoomDto convertBusyRoomToFreeRoomDto(Room room) {
        FreeRoomDto freeRoomDto = new FreeRoomDto();
        Guest guest = guestRepository.getAllGuestFromRoomId(room.getId()).get(0);
        freeRoomDto.setRoomNumber(room.getRoomNumber());
        freeRoomDto.setArrivalRoom("КОМНАТА ЗАНЯТА");
        freeRoomDto.setSurName(guest.getSurName());
        freeRoomDto.setDepartureDate(guest.getDepartureDate());

        return freeRoomDto;
    }

}
