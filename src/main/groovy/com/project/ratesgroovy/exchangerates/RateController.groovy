package com.project.ratesgroovy.exchangerates

import com.project.ratesgroovy.exchangerates.domain.Currency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rates")
class RateController {
    @Autowired
    RateService service

    @PostMapping("")
    void loadData() {
        service.gatherData()
    }

    @DeleteMapping("")
    void clearData() {
        service.clearData()
    }

    @GetMapping("/{name}")
    List<Currency> findCurrency(@PathVariable String name) {
        service.getSingleCurrency(name)
    }


    @GetMapping("/latest")
    List<Currency> findLatest() {
        service.findLatest()
    }
}
