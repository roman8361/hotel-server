package ru.kravchenko.sb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuestServiceTest {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private IGuestService guestService;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void checkGuestItRoom() {
        guestService.checkGuestItRoom(createNewGuest());
    }

    @Test
    public void evictGuest(){
        guestService.evictGuest("e0a1cdd5-12d7-4107-86e5-4590ec82c7a4");
    }

    @Test
    public void editGuest() {
//        guestService.editGuest();
    }

    private Guest createNewGuest(){
        Guest result = new Guest();
        result.setFirstName("Андрей");
        result.setSecondName("Васильевич");
        result.setSurName("Кимков");
        result.setArrivalDate(new GregorianCalendar(2020, Calendar.APRIL, 11).getTime());
        result.setDepartureDate(new GregorianCalendar(2020, Calendar.APRIL, 15).getTime());
        result.setRoom(getRoom("1"));

        return result;
    }

    private Room getRoom (String roomNumber){
        return roomRepository.findByRoomNumber(roomNumber);
    }

}
