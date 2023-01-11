package com.project.ratesgroovy.exchangerates

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminRateController {
    @Autowired
    RateService service

    @PostMapping("/rates")
    void loadData() {
        service.gatherData()
    }

    @DeleteMapping("/rates")
    void deleteData() {
        service.clearData()
    }
}
