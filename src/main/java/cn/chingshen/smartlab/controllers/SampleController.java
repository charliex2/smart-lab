package cn.chingshen.smartlab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/samples")
public class SampleController {

    @GetMapping("")
    public String index() {
        return "Hello world";
    }
}
