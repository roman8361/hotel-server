package ru.kravchenko.sb.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.sb.api.repository.ActivateCodeMobileRepository;
import ru.kravchenko.sb.api.service.ActivateCodeMobileService;
import ru.kravchenko.sb.domain.dto.RequestMobileDto;
import ru.kravchenko.sb.domain.dto.ResponseMobileDto;
import ru.kravchenko.sb.domain.entity.Guest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class ActivateCodeRestController {

    private static final Logger LOG = LoggerFactory.getLogger(DataResources.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ActivateCodeMobileRepository activateCodeMobileRepository;

    @Autowired
    private ActivateCodeMobileService activateCodeMobileService;

    @PostMapping(path = "/activateCodeUrl", consumes = "application/json", produces = "application/json")
    public String activateCodeController(@RequestBody String json) throws IOException {
        LOG.debug("RequestBody {}", json);
        List<String> allActivateCode = activateCodeMobileRepository.getAllActivateCodeMobile();

        final RequestMobileDto mobileDto = objectMapper.readValue(json, RequestMobileDto.class);
        final ResponseMobileDto responseMobileDto = new ResponseMobileDto();

        if (mobileDto.getToken().equals("1111") && (allActivateCode.contains(mobileDto.getCodeActivate()))) {
            Guest guest = activateCodeMobileService.getGuestByActivateCode(mobileDto.getCodeActivate());

            responseMobileDto.setFirstName(guest.getFirstName());
            responseMobileDto.setSecondName(guest.getSecondName());
            responseMobileDto.setRoomNumber(guest.getRoom().getRoomNumber());
            responseMobileDto.setDepartureDate(guest.getDepartureDate());
            responseMobileDto.setMetaMessage("OK");
            return objectMapper.writeValueAsString(responseMobileDto);
        }
        responseMobileDto.setMetaMessage("CODE ACTIVATE or Token not valid");
        return objectMapper.writeValueAsString(responseMobileDto);
    }

}
