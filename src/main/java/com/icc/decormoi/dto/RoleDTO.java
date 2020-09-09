package com.icc.decormoi.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.icc.decormoi.domaine.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO {

	private Long id;

	private String nameRole;

	private UserDTO user;
}
