package ru.kravchenko.sb.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kravchenko.sb.domain.dto.GuestDto;
import ru.kravchenko.sb.domain.dto.RequestMobileDto;
import ru.kravchenko.sb.domain.dto.ResponseMobileDto;

import java.io.IOException;
import java.util.Date;

@RestController
public class DataResources {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/simple")
    public String getSimple(){
        return "SIMPLE";
    }

    @GetMapping(value = "/date")
    public Date getDate() {
        return new Date();
    }

    @GetMapping(value = "/guest", produces = "application/json")
    public String getGuest() throws JsonProcessingException {
        return objectMapper.writeValueAsString(new GuestDto());
    }

    @PostMapping(path = "/hello", consumes = "application/json", produces = "application/json")
    public String hello(@RequestBody String json) throws IOException {
        final RequestMobileDto mobileDto = objectMapper.readValue(json, RequestMobileDto.class);
        final ResponseMobileDto responseMobileDto = new ResponseMobileDto();
        if (mobileDto.getToken().equals("1111")) {
            responseMobileDto.setGuestName("Ivan");
            responseMobileDto.setRoomNumber("3");
            responseMobileDto.setDepartureDate(new Date());
            responseMobileDto.setMetaMessage("OK");
            return objectMapper.writeValueAsString(responseMobileDto);
        }
        responseMobileDto.setMetaMessage("Code activate not valid");
        return objectMapper.writeValueAsString(responseMobileDto);
    }

}