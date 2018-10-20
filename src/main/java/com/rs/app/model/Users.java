package com.rs.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "USERS")
@Setter
@Getter
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Users implements Serializable {
	private static final long serialVersionUID = -8975596852621025041L;
	@Id
	@SequenceGenerator(name = "USERS_ID_GEN", sequenceName = "USERS_ID_SEQ", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "USERS_ID_GEN")
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column(nullable = false, unique = true)
	private String email;

}
