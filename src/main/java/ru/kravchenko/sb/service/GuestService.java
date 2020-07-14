package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IActivateCodeMobileService;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService implements IGuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ActivateCodeMobileRepository activateCodeMobileRepository;

    @Autowired
    private IActivateCodeMobileService activateCodeMobileService;

//    @Override
//    public void editGuest(Guest guest) {
//        Room oldRoom = roomRepository.findById(guest.getRoom().getId()).orElse(new Room());
//        Room newRoom = roomRepository.findByRoomNumber(guest.getRoom().getRoomNumber());
//
//        System.out.println("oldRoom.getId() " + oldRoom.getId());
//        System.out.println("newRoom.getId() " + newRoom.getId());
//
//        if (oldRoom.getId().equals(newRoom.getId())) {
//            guestRepository.save(guest);
//            return;
//        }
//
//        if (isAloneGuestInRoom(oldRoom.getId())) {
//            oldRoom.setIsBusy(Boolean.FALSE);
//        }
//
//        newRoom.setIsBusy(Boolean.TRUE);
//        guest.setRoom(newRoom);
//
//        roomRepository.save(oldRoom);
//        roomRepository.save(newRoom);
//        guestRepository.save(guest);
//
//        guest.setActivateCodeMobile(activateCodeMobileService.updateActivateCodeMobile(guest));
//    }

//    @Override
//    public void checkGuestItRoom(Guest guest) {
//        Room room = guest.getRoom();
//        room.setIsBusy(Boolean.TRUE);
//        guestRepository.save(guest);
//        roomRepository.save(room);
//        guest.setActivateCodeMobile(activateCodeMobileService.createActivateCodeMobile(guest));
//    }

    @Override
    public void editGuest(GuestDto guestDto) {
        Guest guest = guestRepository.findById(guestDto.getId()).get();
        guest.setFirstName(guestDto.getFirstName());
        guest.setSecondName(guestDto.getSecondName());
        guest.setSurName(guestDto.getSurName());
        guest.setArrivalDate(guestDto.getArrivalDate());
        guest.setDepartureDate(guestDto.getDepartureDate());

        Room oldRoom = roomRepository.findById(guestDto.getRoomId()).orElse(new Room());
        Room newRoom = roomRepository.findByRoomNumber(guestDto.getRoomNumber());

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

        guest.setActivateCodeMobile(activateCodeMobileService.updateActivateCodeMobile(guestDto));
    }

    @Override
    public void checkGuestItRoom(GuestDto guestDto) {
        Room room = roomRepository.findByRoomNumber(guestDto.getRoomNumber());
        room.setIsBusy(Boolean.TRUE);
        roomRepository.save(room);
        guestRepository.save(convertDtoToGuest(guestDto));
        activateCodeMobileService.createActivateCodeMobile(guestDto);
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
    public List<GuestDto> allGuestWithRoomAndCodeActivate() {
        List<Guest> guests = guestRepository.getAllGuestWithRoomAndCodeActivate();
        return guests.stream().map(Guest::getDto).collect(Collectors.toList());
    }

    @Override
    public GuestDto findGuestById(String guestId) {
        List<Guest> guestList = guestRepository.getAllGuestWithRoomAndCodeActivate();
        Guest guest = guestList.stream().filter(g -> g.getId().equals(guestId)).findFirst().get();
        return guest.getDto();
    }

//    @Override
//    public List<Guest> findAll() {
//        return guestRepository.findAll();
//    }

//    @Override
//    public Guest findById(String guestId) {
//        return guestRepository.findById(guestId).orElse(null);
//    }

    @Override
    public void removeGuestById(String guestId) {
        guestRepository.deleteById(guestId);
    }

    @Override
    public List<GuestDto> getGuestFromRoom(String roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        List<Guest> guests = guestRepository.getAllGuestFromRoomId(room.getId());
        return guests.stream().map(Guest::getDto).collect(Collectors.toList());
    }

    private Boolean isAloneGuestInRoom(String roomId) {
        List<Guest> guestList = guestRepository.getAllGuestFromRoomId(roomId);
        return guestList.size() == 1;
    }

    private Guest convertDtoToGuest(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setFirstName(guestDto.getFirstName());
        guest.setSecondName(guestDto.getSecondName());
        guest.setSurName(guestDto.getSurName());
        guest.setArrivalDate(guestDto.getArrivalDate());
        guest.setDepartureDate(guestDto.getDepartureDate());
        guest.setRoom(roomRepository.findByRoomNumber(guestDto.getRoomNumber()));
        guest.setActivateCodeMobile(guestDto.getActivateCodeMobileId() == null ? null :
                activateCodeMobileRepository.findById(guestDto.getActivateCodeMobileId()).orElse(null)
        );

        return guest;
    }

}

