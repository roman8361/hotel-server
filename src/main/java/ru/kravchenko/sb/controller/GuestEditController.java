package ru.kravchenko.sb.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.model.entity.Guest;

import java.util.Optional;
import java.util.UUID;

@Controller
@SessionScope
@URLMapping(
        id = "guestEdit",
        pattern = "/guestEdit",
        viewId = "/WEB-INF/view/guestEdit.xhtml")
public class GuestEditController {

    @Autowired
    private GuestRepository guestRepository;

    private String id = UUID.randomUUID().toString();

    private Guest guest = new Guest();

    public void init() {
        Optional<Guest> guest = guestRepository.findById(id);
        guest.ifPresent(value -> this.guest = value);
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

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

}
