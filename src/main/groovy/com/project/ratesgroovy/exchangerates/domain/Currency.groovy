package com.project.ratesgroovy.exchangerates.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "currency_rates")
class Currency {
    @Id
    String currency

    @Column
    BigDecimal rate
    @Column
    Date date

    Currency(String currency, BigDecimal rate, Date date) {
        this.currency = currency
        this.rate = rate
        this.date = date
    }

    Currency() {

    }
}
