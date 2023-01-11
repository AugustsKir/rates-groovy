package com.project.ratesgroovy.exchangerates

import com.project.ratesgroovy.exchangerates.domain.Currency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/")
class RateController {
    @Autowired
    RateService service

    @GetMapping("/{name}")
    List<Currency> findCurrency(@PathVariable String name) {
        service.getSingleCurrency(name)
    }


    @GetMapping("/latest")
    List<Currency> findLatest() {
        service.findLatest()
    }
}
