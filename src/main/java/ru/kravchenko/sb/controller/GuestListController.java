package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.repository.GuestRepository;
import ru.kravchenko.sb.model.entity.Guest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
@URLMapping(
        id = "guestList",
        pattern = "/guestList",
        viewId = "/WEB-INF/view/guestList.xhtml")
public class GuestListController {

    @Autowired
    private GuestRepository guestRepository;

    private List<Guest> guestList = new ArrayList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    private void reload() {
        guestList.clear();
        guestList.addAll(guestRepository.findAll());
    }

    public List<Guest> getGuestList() {
        reload();
        return guestList;
    }

    public void removeGuestById(final String guestId) {
        guestRepository.deleteById(guestId);
        reload();
    }

}
