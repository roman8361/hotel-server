package ru.kravchenko.sb.repository;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.service.ActivateCodeMobileService;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;
import ru.kravchenko.sb.domain.entity.Guest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivateCodeMobileRepositoryTest {

    @Autowired
    private ActivateCodeMobileRepository activateCodeMobileRepository;

    @Autowired
    private ActivateCodeMobileService activateCodeMobileService;

    @Autowired
    private GuestRepository guestRepository;

    @Test
    @Ignore
    public void insertActivateCodeToTable(){
        Guest guest = guestRepository.findBySurName("Илларионов");
        ActivateCodeMobile codeMobile = new ActivateCodeMobile();
        codeMobile.setActivateCodeMobile(activateCodeMobileService.generateActivateCode());
        codeMobile.setDateCreateCode(new Date());
        codeMobile.setGuest(guest);

        activateCodeMobileRepository.save(codeMobile);
    }

    @Test
    public void showAllActivateCode(){
        List<String> allActivateCode = activateCodeMobileRepository.getAllActivateCodeMobile();
        allActivateCode.forEach(System.out::println);
    }

    @Test
    public void existCodeToActivateCodeList(){
        List<String> allActivateCode = activateCodeMobileRepository.getAllActivateCodeMobile();
        Assert.assertTrue(allActivateCode.contains("4886"));
        Assert.assertTrue(allActivateCode.contains("5313"));
    }

    @Test
    public void dellById() {
        activateCodeMobileRepository.deleteById("07687ab2-d4fd-4897-96af-ac8d7d82b7e0");
    }

    @Test
    public void getDataToActivateCode(){
        ActivateCodeMobile activateCodeMobile = activateCodeMobileRepository.findByActivateCodeMobile("4886");
        System.out.println(activateCodeMobile.getGuest().getFirstName());
        System.out.println(activateCodeMobile.getGuest().getSecondName());
        System.out.println(activateCodeMobile.getGuest().getSurName());
        System.out.println(activateCodeMobile.getGuest().getDepartureDate());
        System.out.println(activateCodeMobile.getGuest().getRoom().getRoomNumber());
    }

    @Test
    public void dellAll(){
        activateCodeMobileRepository.deleteAll();
    }

}
