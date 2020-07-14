package ru.kravchenko.sb.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;


import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Test
//    @Ignore
    public void fillRoomTable() {
        for (int i = 1; i < 11; i++) {
            final Room room = new Room();
            room.setRoomNumber(String.valueOf(i));
            roomRepository.save(room);
        }
    }

    @Test
    @Ignore
    public void insertRoom() {
        final Room room = new Room();
        room.setRoomNumber("10");
        roomRepository.save(room);
    }

    @Test
//    @Ignore
    public void dellAllRooms(){
        roomRepository.deleteAll();
    }

    @Test
    public void allRoomsArrival(){
        List<Room> roomList = roomRepository.findAll();
        roomList.forEach(r -> r.setIsBusy(Boolean.FALSE));
        roomRepository.saveAll(roomList);
    }

    @Test
    public void findByRoomNumber() {
        Room room = roomRepository.findByRoomNumber("1");
        List<Guest> guestList = room.getGuests();
        System.out.println(guestList.get(0).getSurName());
    }

    @Test
    @Ignore
    public void dellRoomByNumber(){
//        Room room = roomRepository.findByRoomNumber("10");
//        roomRepository.delete(room);

        roomRepository.deleteById("2ff467a4-be99-4538-8376-242bd854f989");
    }

    //      89cd46be-a3b8-4559-a8a6-8cb166b90ab9     - 3
//          281fef8a-c441-48ae-88f1-e99c9716e00d      - 4

    @Test
    public void updateRoom() {
        Room room3 = roomRepository.findById("89cd46be-a3b8-4559-a8a6-8cb166b90ab9").orElse(new Room());
        room3.setRoomNumber("3");
        roomRepository.save(room3);

        Room room4 = roomRepository.findById("281fef8a-c441-48ae-88f1-e99c9716e00d").orElse(new Room());
        room4.setRoomNumber("4");
        roomRepository.save(room4);
    }

    @Test
    public void findAllRoomsWithGuest(){
        List<Room> rooms = roomRepository.findRoomWhitGuest();
        for (Room room : rooms){
            System.out.println("room.getIsBusy(): " + room.getIsBusy());
            System.out.println("room.getRoomNumber: " + room.getRoomNumber());
            List<Guest> guestList = room.getGuests();
            System.out.println("room.getGuests(): ");
            for (Guest guest : guestList) {
                System.out.println("guest.getFirstName(): " + guest.getFirstName());
                System.out.println("guest.getSurName(): " + guest.getSurName());
                System.out.println("guest.getDepartureDate(): " + guest.getDepartureDate());
            }

        }
    }

    @Test
    public void filterTest(){
        List<Room> allRoom = roomRepository.findAll();
        List<Room> busyRoom = allRoom.stream().filter(room -> room.getIsBusy()).collect(Collectors.toList());
        System.out.println(busyRoom.size());
    }

}
