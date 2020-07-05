package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.service.IActivateCodeMobileService;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.util.GenerateRandomNumberUtils;

import java.util.Date;
import java.util.List;

@Service
public class ActivateCodeMobileService implements IActivateCodeMobileService {

    @Autowired
    private ActivateCodeMobileRepository activateMobileRepository;

    @Override
    public ActivateCodeMobile createActivateCodeMobile(Guest guest) {
        ActivateCodeMobile result = new ActivateCodeMobile();
        result.setDateCreateCode(new Date());
        result.setActivateCodeMobile(generateActivateCode());
        result.setGuest(guest);

        activateMobileRepository.save(result);
        return result;
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
    public ActivateCodeMobile updateActivateCodeMobile(Guest guest) {
        System.out.println("updateActivateCodeMobile");
        System.out.println("guest.getFirstName(): " + guest.getFirstName());
        ActivateCodeMobile codeMobile = activateMobileRepository.findById(guest.getActivateCodeMobile().getId())
                .orElse(new ActivateCodeMobile());
        System.out.println("codeMobile.getActivateCodeMobile() " + codeMobile.getActivateCodeMobile());
        codeMobile.setActivateCodeMobile(generateActivateCode());

        activateMobileRepository.save(codeMobile);

        return codeMobile;
    }

    private String getRandomCode() {
        return GenerateRandomNumberUtils.getStringRandomValue();
    }

}
