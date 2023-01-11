package com.project.ratesgroovy.exchangerates

import com.project.ratesgroovy.exchangerates.domain.Currency
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RateRepository extends JpaRepository<Currency, String> {
    @Query("SELECT r FROM Currency r where lower(r.currency) like lower(:name) ")
    List<Currency> findByName(@Param("name") String name)

    @Query("select r from Currency r where r.date = (select max(date) from Currency ) ")
    List<Currency> findLatest()
}