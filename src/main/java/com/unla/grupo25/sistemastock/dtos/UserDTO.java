package com.unla.grupo25.sistemastock.dtos;

import java.util.HashSet;
import java.util.Set;
import com.unla.grupo25.sistemastock.entities.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor

public class UserDTO {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private Set <UserRole> userRoles = new HashSet<UserRole>();
}
