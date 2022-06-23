package com.efinance.iamUserClient.application.etax;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efinance.iamUserClient.config.app.JwtDecoder;
import com.efinance.iamUserClient.domain.etaxprofile.dto.DueAmountDTO;
import com.efinance.iamUserClient.domain.etaxprofile.services.IRequestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/dsrequest")
public class RequestController {

	private static final String PREFERRED_USERNAME = "preferred_username";
	private static final String WORK_PLACE_ID = "workPlaceID";

	private static final String BEARER_STRING = "Bearer ";

	private static final String ACCESS_TOKEN_BODY_ERROR_MSG = "Error  Getting Access Token Body";

	private static final String INVALID_ACCESS_TOKEN_MSG = "An Error Occurred, The token is not valid";

	private static final String ERROR_COMPLETING_THE_REQUEST = "An Error Occurred, The request data has not been saved";

	private static final String ERROR_DELETING_THE_REQUEST = "An Error Occurred, The Request data has not been deleted";

	private static final String ERROR_GET_WORK_PLACE_ID = "An Error Occurred, can't get WORK PLACE ID";

	private static final String ERROR_GET_Due_Amount = "An Error Occurred, can't get Due_Amount Data";

	@Autowired
	IRequestService requestService;

	public String getAccessTokenBody(String accessTokenResponse) {

		String accessTokenBody = null;

		if (accessTokenResponse != null && accessTokenResponse.startsWith(BEARER_STRING)) {
			String accessTokenStr = accessTokenResponse.substring(7);

			try {
				accessTokenBody = JwtDecoder.getPayloadData(accessTokenStr);
			} catch (Exception ex) {
				log.error(ACCESS_TOKEN_BODY_ERROR_MSG, ex);
				return null;
			}
		} else {
			log.error(INVALID_ACCESS_TOKEN_MSG);
		}
		return accessTokenBody;
	}

	@PostMapping("/getDueAmount")
	public ResponseEntity getDueAmount(@RequestBody DueAmountDTO dueAmountDTO) {

		DueAmountDTO dueAmount = requestService.getDueAmount(dueAmountDTO.getId());
		if (dueAmount != null) {

			return ResponseEntity.ok().body(dueAmount);
		} else {
			return ResponseEntity.ok().body(ERROR_GET_Due_Amount);
		}

	}
}
