package com.icc.decormoi.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO implements Serializable  {

	private EventDTO event;
	
}
