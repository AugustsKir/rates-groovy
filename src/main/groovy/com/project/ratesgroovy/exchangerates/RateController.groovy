package com.project.ratesgroovy.exchangerates

import com.project.ratesgroovy.exchangerates.domain.Currency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class RateController {
    @Autowired
    RateService service

    @PostMapping("/load")
    void loadData() {
        service.gatherData()
    }

    @GetMapping("/{id}")
    List<Currency> findCurrency(@PathVariable String id) {
        service.getSingleCurrency(id)
    }

    @DeleteMapping("/clear")
    void clearData() {
        service.clearData()
    }

    @GetMapping("/latest")
    List<Currency> findLatest() {
        service.findLatest()
    }
}
