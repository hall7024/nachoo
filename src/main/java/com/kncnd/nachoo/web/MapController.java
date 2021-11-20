package com.kncnd.nachoo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MapController {

    private HttpSession session;

    @RequestMapping("/map.do")
    public String map(Model model) {

        model.addAttribute("isMap", true);

        return "map/map";
    }

}
