package it.nepsther.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film implements Serializable{

	private static final long serialVersionUID = 1L;
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false, updatable = false, columnDefinition = "smallint(5)")
    private Integer filmId;

    @Column(name = "title", nullable = false, columnDefinition = "varchar(255)")
    private String title;

    @Column(name = "length", columnDefinition = "smallint(5)")
    private Integer length;

    @Column(name = "rating", columnDefinition = "enum('G','PG','PG-13','R','NC-17')")
    private String rating;

}
