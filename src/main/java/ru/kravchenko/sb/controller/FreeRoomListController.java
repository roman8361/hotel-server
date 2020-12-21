package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.service.RoomService;
import ru.kravchenko.sb.domain.dto.FreeRoomDto;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Controller
@SessionScope
@URLMapping(
        id = "busyRoomList",
        pattern = "/busyRoomList",
        viewId = "/WEB-INF/view/freeRoomList.xhtml")
public class FreeRoomListController {

    @Autowired
    private RoomService roomService;

    public List<FreeRoomDto> getFreeRoomList() {
        List<FreeRoomDto> result = roomService.getFreeRoom();
        result.sort(FreeRoomDto.COMPARE_BY_ROOM_NUMBER);
        return result;
    }

}
