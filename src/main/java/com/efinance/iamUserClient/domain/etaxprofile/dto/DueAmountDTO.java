package com.efinance.iamUserClient.domain.etaxprofile.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DueAmountDTO {

	private int id;

	private String name;


}
