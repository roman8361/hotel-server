package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.api.service.IActivateCodeMobileService;
import ru.kravchenko.sb.domain.dto.ActivateCodeMobileDto;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;
import ru.kravchenko.sb.util.GenerateRandomNumberUtils;

import java.util.Date;
import java.util.List;

@Service
public class ActivateCodeMobileService implements IActivateCodeMobileService {

    @Autowired
    private ActivateCodeMobileRepository activateMobileRepository;

    @Autowired
    private GuestRepository guestRepository;

//    @Override
//    public ActivateCodeMobile createActivateCodeMobile(Guest guest) {
//        ActivateCodeMobile result = new ActivateCodeMobile();
//        result.setDateCreateCode(new Date());
//        result.setActivateCodeMobile(generateActivateCode());
//        result.setGuest(guest);
//
//        activateMobileRepository.save(result);
//        return result;
//    }

    @Override
    public void createActivateCodeMobile(GuestDto guestDto) {
        ActivateCodeMobileDto activateCodeMobileDto = new ActivateCodeMobileDto();
        activateCodeMobileDto.setDateCreateCode(new Date());
        activateCodeMobileDto.setGuestId(guestDto.getId());
        activateCodeMobileDto.setActivateCodeMobile(generateActivateCode());
        activateMobileRepository.save(convertDtoToActivateCodeMobile(activateCodeMobileDto));

    }

    @Override
    public String generateActivateCode() {
        List<String> getAllCodesFromDb = activateMobileRepository.getAllActivateCodeMobile();
        String resultCode = getRandomCode();
        if (getAllCodesFromDb.contains(resultCode)) {
            generateActivateCode();
        }
        return resultCode;
    }

    @Override
    public ActivateCodeMobile updateActivateCodeMobile(GuestDto guestDto) {
        ActivateCodeMobile codeMobile = activateMobileRepository.findById(guestDto.getActivateCodeMobileId()).get();
        codeMobile.setActivateCodeMobile(generateActivateCode());
        activateMobileRepository.save(codeMobile);
        return codeMobile;
    }

    @Override
    public void saveActivateCode(ActivateCodeMobileDto activateCodeMobileDto) {
        activateMobileRepository.save(convertDtoToActivateCodeMobile(activateCodeMobileDto));
    }

//    @Override
//    public ActivateCodeMobile updateActivateCodeMobile(Guest guest) {
//        System.out.println("updateActivateCodeMobile");
//        System.out.println("guest.getFirstName(): " + guest.getFirstName());
//        ActivateCodeMobile codeMobile = activateMobileRepository.findById(guest.getActivateCodeMobile().getId())
//                .orElse(new ActivateCodeMobile());
//        System.out.println("codeMobile.getActivateCodeMobile() " + codeMobile.getActivateCodeMobile());
//        codeMobile.setActivateCodeMobile(generateActivateCode());
//
//        activateMobileRepository.save(codeMobile);
//
//        return codeMobile;
//    }

    private String getRandomCode() {
        return GenerateRandomNumberUtils.getStringRandomValue();
    }

    private ru.kravchenko.sb.domain.entity.ActivateCodeMobile convertDtoToActivateCodeMobile(ActivateCodeMobileDto activateCodeMobileDto){
        ru.kravchenko.sb.domain.entity.ActivateCodeMobile activateCodeMobile = new ru.kravchenko.sb.domain.entity.ActivateCodeMobile();
        activateCodeMobile.setId(activateCodeMobileDto.getId());
        activateCodeMobile.setActivateCodeMobile(activateCodeMobileDto.getActivateCodeMobile());
        activateCodeMobile.setDateCreateCode(activateCodeMobileDto.getDateCreateCode());
        activateCodeMobile.setGuest(guestRepository.findById(activateCodeMobileDto.getGuestId()).get());

        return activateCodeMobile;
    }

}
