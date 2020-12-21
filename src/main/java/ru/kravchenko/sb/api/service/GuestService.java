package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.dto.GuestDto;

import java.util.List;

public interface GuestService {

   void editGuest(GuestDto guest);

   void checkGuestItRoom(GuestDto guest);

   void evictGuest(String guestId);

   List<GuestDto> allGuestWithRoomAndCodeActivate();

   GuestDto findGuestById(String guestId);

   void removeGuestById(String guestId);

   List<GuestDto> getGuestFromRoom(String roomNumber);

}
