package ru.kravchenko.sb.repository;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.entity.Guest;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuestRepositoryTest {

    @Autowired
    GuestRepository guestRepository;

    @Test
    @Ignore
    public void insertGuest(){
        Guest guest = createGuest();
        guestRepository.save(guest);
    }

    private Guest createGuest() {
        Guest guest = new Guest();
        guest.setFirstName("Александр");
        guest.setSecondName("Андреевич");
        guest.setSurName("Петров");
        guest.setArrivalDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());
        guest.setDepartureDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 12).getTime());
        guest.setRoomNumber("5");
        guest.setCodeActivateMobileApp("111222");
        return guest;
    }

}
