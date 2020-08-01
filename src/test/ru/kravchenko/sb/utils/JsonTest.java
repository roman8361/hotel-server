package ru.kravchenko.sb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import ru.kravchenko.sb.domain.dto.GuestDto;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JsonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void ObjectToJson() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(getGuestDto()));
    }

    @Test
    public void JsonToObject() throws IOException {
        final String json = "{\"id\":\"7d4acb71-5a8d-4db9-8ca9-535e63c1c811\",\"firstName\":\"Андрей\",\"secondName\":\"Васильевич\",\"surName\":\"Чернец\",\"arrivalDate\":\"2020-07-10T21:00:00.000Z\",\"departureDate\":\"2020-07-14T21:00:00.000Z\",\"roomNumber\":\"1\",\"activateCodeMobile\":null,\"roomId\":null,\"activateCodeMobileId\":null}\n";
        GuestDto guestDto = objectMapper.readValue(json, GuestDto.class);
        Assert.assertNotNull(guestDto);
    }

    private GuestDto getGuestDto() {
        GuestDto result = new GuestDto();
        result.setFirstName("Андрей");
        result.setSecondName("Васильевич");
        result.setSurName("Чернец");
        result.setArrivalDate(new GregorianCalendar(2020, Calendar.JULY, 11).getTime());
        result.setDepartureDate(new GregorianCalendar(2020, Calendar.JULY, 15).getTime());
        result.setRoomNumber("1");
        return result;
    }

}
