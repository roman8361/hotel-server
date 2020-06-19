package ru.kravchenko.sb.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
@URLMapping(
        id = "index",
        pattern = "/",
        viewId = "/WEB-INF/view/index.xhtml")
public class IndexController {


}
