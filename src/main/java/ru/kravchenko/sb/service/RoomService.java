package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.BluetoothCodeRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IRoomService;
import ru.kravchenko.sb.domain.dto.RoomDto;
import ru.kravchenko.sb.domain.entity.BluetoothCode;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private BluetoothCodeRepository bluetoothCodeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Guest> getGuestFromRoom(String roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        return room.getGuests();
    }

    @Override
    public Room findByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    ///////

   private Room convertDtoTRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setBluetoothCode(getBluetoothCode(roomDto.getBluetoothCodeId()));
        room.setIsBusy(roomDto.getIsBusy());

        return room;
   }

   private BluetoothCode getBluetoothCode(String codeId) {
        return bluetoothCodeRepository.findById(codeId).orElse(null);
   }

}
