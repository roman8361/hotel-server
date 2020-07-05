package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    Room findByRoomNumber(String roomNumber);

    void deleteByRoomNumber(String roomNumber);

    @Query(value = "select * from rooms inner join guests on rooms.id = guests.room_id", nativeQuery = true)
    List<Room> findRoomWhitGuest();

}
