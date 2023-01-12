package com.project.ratesgroovy.exchangerates.domain


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDate

@Entity
@Table(name = "currency_rates")
class Currency {
    @Id
    String id


    @Column
    String currency

    @Column
    BigDecimal rate
    @Column
    LocalDate date

    Currency(String currency, BigDecimal rate, LocalDate date, String id) {
        this.currency = currency
        this.rate = rate
        this.date = date
        this.id = id
    }

    Currency() {

    }
}
