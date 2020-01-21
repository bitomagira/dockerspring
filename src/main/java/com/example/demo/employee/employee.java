package com.example.demo.employee;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String surname;
	private String jobtitle;
}
