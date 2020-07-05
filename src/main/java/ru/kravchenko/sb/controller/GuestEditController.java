package ru.kravchenko.sb.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.entity.Guest;

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
    private IGuestService guestService;

    private String guestId;

    private Guest guest = new Guest();

    public void init() {
        guest = guestService.findById(guestId);
    }

    public String edit() {
        guestService.editGuest(guest);
        return "guestList";
    }

}
