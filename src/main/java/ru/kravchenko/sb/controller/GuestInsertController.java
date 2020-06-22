package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.entity.Guest;
import ru.kravchenko.sb.util.GenerateRandomNumberUtils;

import java.util.UUID;

@Controller
@RequestScope
@URLMapping(
        id = "newGuest",
        pattern = "/newGuest",
        viewId = "/WEB-INF/view/newGuest.xhtml")
public class GuestInsertController {

    @Autowired
    private GuestRepository guestRepository;

    private String id = UUID.randomUUID().toString();

    private Guest guest = new Guest();

    {
        guest.setCodeActivateMobileApp(GenerateRandomNumberUtils.getStringRandomValue());
    }

    public String save() {
        guestRepository.save(guest);
        return "guestList";
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(final Guest project) {
        this.guest = project;
    }

}
