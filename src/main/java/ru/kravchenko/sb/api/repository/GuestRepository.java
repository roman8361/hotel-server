package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.domain.entity.Guest;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {

    Guest findBySurName(String surName);

    String queryAllByRoomId = "select * from guests g where g.room_id =?1";

    @Query(value = queryAllByRoomId, nativeQuery = true)
    List<Guest> getAllGuestFromRoomId(String roomId);

    String queryAllByRoomAndActivateCodeMobile = "select * from guests inner join rooms r on guests.room_id = r.id " +
            "inner join activate_cods_mobile acm on guests.id = acm.guest_id";

    @Query(value = queryAllByRoomAndActivateCodeMobile, nativeQuery = true)
    List<Guest> getAllGuestWithRoomAndCodeActivate();

    String queryAllByRoom = "select * from guests inner join rooms r on guests.room_id = r.id";

    @Query(value = queryAllByRoom, nativeQuery = true)
    List<Guest> getAllGuestWithRoom();

}
