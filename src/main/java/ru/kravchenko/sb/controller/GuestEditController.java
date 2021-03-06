package ru.kravchenko.sb.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.service.GuestService;
import ru.kravchenko.sb.domain.dto.GuestDto;

@Getter
@Setter
@Controller
@SessionScope
@URLMapping(
        id = "guestEdit",
        pattern = "/guestEdit",
        viewId = "/WEB-INF/view/guestEdit.xhtml")
public class GuestEditController {

    @Autowired
    private GuestService guestService;

    private String guestId;

    private GuestDto guestDto = new GuestDto();

    public void init() {
        guestDto = guestService.findGuestById(guestId);
    }

    public String edit() {
        guestService.editGuest(guestDto);
        return "guestList";
    }

}
