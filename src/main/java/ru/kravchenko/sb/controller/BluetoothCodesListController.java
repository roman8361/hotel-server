package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.service.BluetoothCodeService;
import ru.kravchenko.sb.domain.dto.BluetoothCodeDto;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Controller
@SessionScope
@URLMapping(
        id = "bluetoothCodesList",
        pattern = "/bluetoothCodesList",
        viewId = "/WEB-INF/view/bluetoothCodesList.xhtml")
public class BluetoothCodesListController {

    @Autowired
    private BluetoothCodeService bluetoothCodeService;

    public List<BluetoothCodeDto> getCodeList() {
        return bluetoothCodeService.findAllBluetoothCodes();
    }

}
