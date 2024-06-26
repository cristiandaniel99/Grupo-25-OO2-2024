package com.unla.grupo25.sistemastock.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Serializable>{
	
	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = :username")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public abstract User findByUsername(String username);
	
	
}