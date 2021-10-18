package it.nepsther.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity

@Getter @Setter
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Double salary;
	
	@Getter @Setter
	@Column(columnDefinition = "enum('DTI','DF','DSI','DSO')")
	private String dept;

}
