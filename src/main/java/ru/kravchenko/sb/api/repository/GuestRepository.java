package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.domain.entity.Guest;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {

    Guest findBySurName(String surName);

    @Query(value = "select * from guests g where g.room_id =?1", nativeQuery = true)
    List<Guest> getAllGuestFromRoomId(String roomId);


//    @Query(
////            value = "SELECT * FROM Users u WHERE u.status = ?1",
////            nativeQuery = true)
////    User findUserByStatusNative(Integer status);

//    select * from guests where room_id = '2f15792c-0edb-48cd-bb17-3f82739d3459';

}
