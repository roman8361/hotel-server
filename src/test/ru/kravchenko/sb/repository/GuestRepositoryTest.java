package ru.kravchenko.sb.repository;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IActivateCodeMobileService;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuestRepositoryTest {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ActivateCodeMobileRepository activateCodeMobileRepository;

    @Autowired
    private IActivateCodeMobileService activateCodeMobileService;

    @Test
    public void insertGuest(){
        Guest guest = createGuest();
        guestRepository.save(guest);
        ActivateCodeMobile activateCodeMobile = getActivateMobileCode(guest);

        activateCodeMobileRepository.save(activateCodeMobile);
    }

    @Test
    @Ignore
    public void dellAllGuest(){
        guestRepository.deleteAll();
    }

    @Test
    public void dellByGuest(){
        Guest guest = guestRepository.findBySurName("Тестов8");
        guestRepository.delete(guest);
    }

    @Test
    public void findBySurName(){
        Guest guest = guestRepository.findBySurName("Губанов");
        System.out.println(guest.getRoom().getRoomNumber());
        System.out.println(guest.getActivateCodeMobile().getActivateCodeMobile());
    }

    @Test
    public void getAllGuestFromRoomId(){
        List<Guest> guestList = guestRepository.getAllGuestFromRoomId("5b5a3f8f-c581-4b37-8c67-ca1b19d8f466");
        guestList.forEach(g -> System.out.println(g.getFirstName()));
    }

    private Guest createGuest() {
        Guest guest = new Guest();
        guest.setFirstName("Сергей");
        guest.setSecondName("Андреевич");
        guest.setSurName("Губанов");
        guest.setArrivalDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());
        guest.setDepartureDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 12).getTime());

        Room room = roomRepository.findByRoomNumber("3");
        room.setIsBusy(Boolean.TRUE);
        guest.setRoom(room);
        roomRepository.save(room);

        return guest;
    }

    private ActivateCodeMobile getActivateMobileCode(Guest guest) {
        ActivateCodeMobile result =  new ActivateCodeMobile();
        result.setDateCreateCode(new Date());
        result.setGuest(guest);
        result.setActivateCodeMobile(activateCodeMobileService.generateActivateCode());

        return result;
    }

}
