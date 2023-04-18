package com.my.graphql.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "created_time")
	private Date createdTime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<Vegetable> vegetables;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<Fruit> fruits;

	public Order(User user, Date createdTime) {
		this.user = user;
		this.createdTime = createdTime;
	}
}
