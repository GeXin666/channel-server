package com.framework.code.controller;

import com.framework.core.bean.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class AppController {

    @GetMapping("/")
    @ResponseBody
    public Object health() {
        return JsonResult.SUCCESS;
    }

}
