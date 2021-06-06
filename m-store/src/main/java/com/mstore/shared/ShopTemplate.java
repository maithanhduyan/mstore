/**
 * @author Mai Thành Duy An
 */
package com.mstore.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mstore.repositories.ShopRepository;

@Component
public class ShopTemplate {
	@Autowired
	ShopRepository shopRepository;
	
	public String ShopName() {
		return "MSTORE" ;
	}
}
