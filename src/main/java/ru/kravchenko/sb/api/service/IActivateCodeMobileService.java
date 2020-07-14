package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.dto.ActivateCodeMobileDto;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;

public interface IActivateCodeMobileService {

    void createActivateCodeMobile(GuestDto guest);

    String generateActivateCode();

    ActivateCodeMobile updateActivateCodeMobile(GuestDto guest);

    void saveActivateCode(ActivateCodeMobileDto activateCodeMobileDto);

}
