package com.my.graphql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vegetable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JoinColumn(name = "order_id")

	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	@Column(name = "vegetable_name")
	private String vegetableName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "unit")
	private String unit;

}
