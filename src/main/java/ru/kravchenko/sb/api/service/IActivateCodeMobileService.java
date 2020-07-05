package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;
import ru.kravchenko.sb.domain.entity.Guest;

public interface IActivateCodeMobileService {

    ActivateCodeMobile createActivateCodeMobile(Guest guest);

    String generateActivateCode();

    ActivateCodeMobile updateActivateCodeMobile(Guest guest);

}
