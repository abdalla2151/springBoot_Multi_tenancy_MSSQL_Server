package com.efinance.iamUserClient.domain.etaxprofile.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.efinance.iamUserClient.domain.etaxprofile.entities.DueAmount;

public interface DueAmountRepo extends JpaRepository<DueAmount, Integer> {

//	@Query("select da from DueAmount da where da.requestTypeId = :requestTypeId and da.serviceTypeId = :serviceTypeId and da.isActive = true")
//	DueAmount getDueAmount(@Param("requestTypeId") int requestTypeId, @Param("serviceTypeId") int serviceTypeId);

}
