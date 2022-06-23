package com.efinance.iamUserClient.domain.etaxprofile.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efinance.iamUserClient.domain.etaxprofile.dto.DueAmountDTO;
import com.efinance.iamUserClient.domain.etaxprofile.entities.DueAmount;
import com.efinance.iamUserClient.domain.etaxprofile.repo.DueAmountRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestServiceImp implements IRequestService {

	@Autowired
	DueAmountRepo dueAmountRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public DueAmountDTO getDueAmount(int id) {
		DueAmount dueAmount = null;
		DueAmountDTO dueAmountDTO = null;
		try {
			dueAmount = dueAmountRepo.getById(id); 	//getDueAmount(requestTypeId, serviceTypeId);

			if (dueAmount != null)
				dueAmountDTO = modelMapper.map(dueAmount, DueAmountDTO.class);

		} catch (Exception e) {
			log.error("Error Getting request By requestId", e);
			return new DueAmountDTO();
		}

		return dueAmountDTO;
	}

}
