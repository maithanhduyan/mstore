package com.mstore.domain.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.sales.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, String>{

}
