package ru.kravchenko.sb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.repository.RoomRepository;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuestServiceTest {

//    void editGuest(GuestDto guest);
//
//    void checkGuestItRoom(GuestDto guest);
//
//    void evictGuest(String guestId);
//
//    List<GuestDto> findAll();
//
//    GuestDto findById(String guestId);
//
//    void removeGuestById(String guestId);

    @Autowired
    private ActivateCodeMobileRepository activateCodeMobileRepository;

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
    public void evictGuest() {
        guestService.evictGuest("4b27119d-21cc-4b07-a040-fb8f18e54c44");
    }

    @Test
    public void getAllGuestFromRoom() {
        List<GuestDto> tempList = guestService.getGuestFromRoom("6");
        Assert.assertEquals(2, tempList.size());
        tempList = guestService.getGuestFromRoom("2");
        Assert.assertEquals(1, tempList.size());
    }

    @Test
    public void allGuestWithRoomAndCodeActivate() {
        List<GuestDto> tempList = guestService.allGuestWithRoomAndCodeActivate();
        for (GuestDto guestDto : tempList) {
            System.out.println(guestDto.getFirstName());
            System.out.println(guestDto.getRoomNumber());
            System.out.println(guestDto.getActivateCodeMobile());
        }
    }

    @Test
    public void findGuestById(){
        GuestDto guestDto = guestService.findGuestById("b828d3d5-b624-4d5c-a917-1aa5707e28b2");
        System.out.println(guestDto.getFirstName());
        System.out.println(guestDto.getRoomNumber());
        System.out.println(guestDto.getActivateCodeMobile());
    }

    @Test
    public void updateGuest(){
//        GuestDto guestDto = guestService.findGuestById("b828d3d5-b624-4d5c-a917-1aa5707e28b2");
//        guestDto.setSurName("Иванов");
//        guestRepository.save(convertDtoToGuest(guestDto));

        Guest guest = guestRepository.findById("b828d3d5-b624-4d5c-a917-1aa5707e28b2").get();
        guest.setFirstName("DIMANA");
        guestRepository.save(guest);
    }

//    @Test
//    public void editGuest() {
//        guestService.editGuest();
//    }

    private GuestDto createNewGuest() {
        GuestDto result = new GuestDto();
        result.setFirstName("Андрей");
        result.setSecondName("Васильевич");
        result.setSurName("Чернец");
        result.setArrivalDate( new GregorianCalendar(2020, Calendar.JULY, 11).getTime());
        result.setDepartureDate( new GregorianCalendar(2020, Calendar.JULY, 15).getTime());
        result.setRoomNumber("1");
        return result;
    }

    private Room getRoom(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    private Guest convertDtoToGuest (GuestDto guestDto) {
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
