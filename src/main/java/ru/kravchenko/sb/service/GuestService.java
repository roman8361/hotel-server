package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IActivateCodeMobileService;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;

@Service
public class GuestService implements IGuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private IActivateCodeMobileService activateCodeMobileService;

    @Override
    public void editGuest(Guest guest) {
        Room oldRoom = roomRepository.findById(guest.getRoom().getId()).orElse(new Room());
        Room newRoom = roomRepository.findByRoomNumber(guest.getRoom().getRoomNumber());

        System.out.println("oldRoom.getId() " + oldRoom.getId());
        System.out.println("newRoom.getId() " + newRoom.getId());

        if (oldRoom.getId().equals(newRoom.getId())) {
            guestRepository.save(guest);
            return;
        }

        if (isAloneGuestInRoom(oldRoom.getId())) {
            oldRoom.setIsBusy(Boolean.FALSE);
        }

        newRoom.setIsBusy(Boolean.TRUE);
        guest.setRoom(newRoom);

        roomRepository.save(oldRoom);
        roomRepository.save(newRoom);
        guestRepository.save(guest);

        guest.setActivateCodeMobile(activateCodeMobileService.updateActivateCodeMobile(guest));
    }

    @Override
    public void checkGuestItRoom(Guest guest) {
        Room room = guest.getRoom();
        room.setIsBusy(Boolean.TRUE);
        guestRepository.save(guest);
        roomRepository.save(room);
        guest.setActivateCodeMobile(activateCodeMobileService.createActivateCodeMobile(guest));
    }

    @Override
    public void evictGuest(String guestId) {
        Guest guest = guestRepository.findById(guestId).orElse(new Guest());
        Room room = guest.getRoom();
        room.setIsBusy(Boolean.FALSE);
        roomRepository.save(room);
        guestRepository.delete(guest);
    }

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest findById(String guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }

    @Override
    public void removeGuestById(String guestId) {
        guestRepository.deleteById(guestId);
    }

    private Boolean isAloneGuestInRoom(String roomId) {
        List<Guest> guestList = guestRepository.getAllGuestFromRoomId(roomId);
        return guestList.size() == 1;
    }

}

