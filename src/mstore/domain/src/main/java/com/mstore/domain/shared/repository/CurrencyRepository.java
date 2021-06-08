package com.mstore.domain.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.shared.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String>{

}
