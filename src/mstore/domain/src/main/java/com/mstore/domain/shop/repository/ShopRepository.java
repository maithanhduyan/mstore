package com.mstore.domain.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, String>{

}
