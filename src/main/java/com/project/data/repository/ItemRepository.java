package com.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.data.model.ItemInfo;

public interface ItemRepository extends JpaRepository<ItemInfo, Long> {

}
