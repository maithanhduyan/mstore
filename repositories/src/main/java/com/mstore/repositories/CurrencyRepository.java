/**
 * @author Mai Thành Duy An
 */
package com.mstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mstore.entities.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String> {

}
