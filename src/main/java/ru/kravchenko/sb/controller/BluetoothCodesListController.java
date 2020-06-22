package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import ru.kravchenko.sb.api.repository.LockCodeRepository;
import ru.kravchenko.sb.api.repository.UserRepository;
import ru.kravchenko.sb.model.entity.LockCode;
import ru.kravchenko.sb.model.entity.User;

import java.util.ArrayList;
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
    LockCodeRepository lockCodeRepository;


    public List<LockCode> getCodeList() {
        return lockCodeRepository.findAll();
    }

}
