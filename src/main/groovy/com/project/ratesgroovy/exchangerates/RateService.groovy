package com.project.ratesgroovy.exchangerates

import com.project.ratesgroovy.exchangerates.domain.Currency
import groovy.xml.XmlSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class RateService {
    @Autowired
    RateRepository repository

    void gatherData() {
        String stringURL = 'https://www.bank.lv/vk/ecb_rss.xml'
        def slurper = new XmlSlurper()
        def data = slurper.parse(stringURL)
        for (day in data.channel.item) {
            String pattern = 'E, dd MMM yyyy HH:mm:ss Z'
            String stringData = day.description
            String basicDate = day.pubDate
            def date = LocalDate.parse(basicDate, pattern)
            def arr = stringData.split(" ")
            for (int i = 0; i < arr.length; i += 2) {
                repository.save(new Currency(arr[i], arr[i + 1] as BigDecimal, date, arr[i] + "" + date.getDayOfYear().toString()))
            }
        }
    }

    void clearData() {
        repository.deleteAll()
    }

    List<Currency> getSingleCurrency(String currency) {
        repository.findByName(currency)
    }

    List<Currency> findLatest() {
        repository.findLatest()
    }


}
