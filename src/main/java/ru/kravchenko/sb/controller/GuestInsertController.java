package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import ru.kravchenko.sb.api.service.IGuestService;
import ru.kravchenko.sb.api.service.IRoomService;
import ru.kravchenko.sb.domain.entity.Guest;
import ru.kravchenko.sb.domain.entity.Room;

@Controller
@RequestScope
@URLMapping(
        id = "newGuest",
        pattern = "/newGuest",
        viewId = "/WEB-INF/view/newGuest.xhtml")
public class GuestInsertController {

    @Autowired
    private IGuestService guestService;

    @Autowired
    private IRoomService roomService;

    private Guest guest = new Guest();

    private String roomNumber = "";


    public String save() {
        Room room = roomService.findByRoomNumber(roomNumber);
        guest.setRoom(room);
        guestService.checkGuestItRoom(guest);

        return "guestList";
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(final Guest project) {
        this.guest = project;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

}
