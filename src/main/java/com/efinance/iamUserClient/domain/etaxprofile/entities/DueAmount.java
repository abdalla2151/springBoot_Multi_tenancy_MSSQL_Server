package com.efinance.iamUserClient.domain.etaxprofile.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DUE_AMOUNTS")
public class DueAmount {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	@Column(name = "Name")
	private String name;
	


}
