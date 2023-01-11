package com.project.ratesgroovy.exchangerates.domain

import jakarta.persistence.*

import java.time.LocalDate

@Entity
@Table(name = "currency_rates")
class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column
    String currency

    @Column
    BigDecimal rate
    @Column
    LocalDate date

    Currency(String currency, BigDecimal rate, LocalDate date) {
        this.currency = currency
        this.rate = rate
        this.date = date
    }

    Currency() {

    }
}
