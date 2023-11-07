package com.pharma.retailer.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharma.retailer.entity.RetailerEntity;
import com.pharma.retailer.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, UUID> {

	@Query("SELECT r FROM StoreEntity r WHERE r.storeCode = :storeCode")
	Optional<StoreEntity> findByStoreCode(@Param("storeCode") long storeCode);

	@Query("SELECT r FROM RetailerEntity r WHERE " + "LOWER(r.retailerCompany) LIKE LOWER(CONCAT('%', :query, '%')) OR "
			+ "LOWER(r.ownerName) LIKE LOWER(CONCAT('%', :query, '%'))")
	List<RetailerEntity> retailerAheadSearch(@Param("query") String query);

}
