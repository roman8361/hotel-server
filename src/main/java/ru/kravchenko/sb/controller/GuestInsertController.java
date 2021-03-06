package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import ru.kravchenko.sb.api.service.GuestService;
import ru.kravchenko.sb.api.service.RoomService;
import ru.kravchenko.sb.domain.dto.GuestDto;

@Getter
@Setter
@Controller
@RequestScope
@URLMapping(
        id = "newGuest",
        pattern = "/newGuest",
        viewId = "/WEB-INF/view/newGuest.xhtml")
public class GuestInsertController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private RoomService roomService;

    private GuestDto guestDto = new GuestDto();

    public String save() {
        guestService.checkGuestItRoom(guestDto);
        return "guestList";
    }

    public GuestDto getGuestDto() {
        return guestDto;
    }

    public void setGuestDto(final GuestDto guestDto) {
        this.guestDto = guestDto;
    }

}
