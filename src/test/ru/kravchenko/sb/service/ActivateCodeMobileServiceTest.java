package ru.kravchenko.sb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.service.ActivateCodeMobileService;
import ru.kravchenko.sb.domain.entity.Guest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivateCodeMobileServiceTest {

    @Autowired
    private ActivateCodeMobileService activateCodeMobileService;

//    ActivateCodeMobileDto createActivateCodeMobile(GuestDto guest);
//
//    String generateActivateCode();
//
//    ActivateCodeMobileDto updateActivateCodeMobile(GuestDto guest);

    @Test
    public void findGuestByActivateCode(){
        Guest guest = activateCodeMobileService.getGuestByActivateCode("4886");
        System.out.println(guest.getFirstName());
        System.out.println(guest.getSecondName());
        System.out.println(guest.getArrivalDate());
    }

}
