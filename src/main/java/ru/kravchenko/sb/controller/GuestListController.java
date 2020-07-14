package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.domain.dto.GuestDto;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Controller
@SessionScope
@URLMapping(
        id = "guestList",
        pattern = "/guestList",
        viewId = "/WEB-INF/view/guestList.xhtml")
public class GuestListController {

    @Autowired
    private IGuestService guestService;

    private List<GuestDto> guestList = new LinkedList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    private void reload() {
        guestList.clear();
        guestList.addAll(guestService.allGuestWithRoomAndCodeActivate());
    }

    public List<GuestDto> getGuestList() {
        reload();
        return guestList;
    }

    public void evictGuest(String guestId) {
        guestService.evictGuest(guestId);
        reload();
    }

}
