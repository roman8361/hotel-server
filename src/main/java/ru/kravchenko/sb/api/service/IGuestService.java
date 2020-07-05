package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.entity.Guest;

import java.util.List;

public interface IGuestService {

   void editGuest(Guest guest);

   void checkGuestItRoom(Guest guest);

   void evictGuest(String guestId);

   List<Guest> findAll();

   Guest findById(String guestId);

   void removeGuestById(String guestId);

}
