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
public interface RetailerRepository extends JpaRepository<RetailerEntity, UUID> {

	@Query("SELECT r FROM RetailerEntity r WHERE r.retailerCode = :retailerCode")
	Optional<RetailerEntity> findByRetailerCode(@Param("retailerCode") long retailerCode);

	@Query("DELETE FROM RetailerEntity r WHERE r.retailerCode = :retailerCode")
	public void deleteRetailer(@Param("retailerCode") long retailerCode);

	public List<RetailerEntity> findByretailerCodeIn(List<Long> retailerCodes);

	@Query("SELECT s FROM StoreEntity s WHERE " + "LOWER(s.name) LIKE LOWER(CONCAT('%', :query, '%')) OR "
			+ "LOWER(s.area) LIKE LOWER(CONCAT('%', :query, '%'))")
	List<StoreEntity> storeAheadSearch(@Param("query") String query);
	
	
}
