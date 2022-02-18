package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "strain")
@Builder
@AllArgsConstructor
public class Strain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Column(name = "name", columnDefinition = "varchar", length = 250, nullable = false)
	@Getter
	@Setter
	private String name;

	@Column(name = "description", columnDefinition = "text")
	@Getter
	@Setter
	private String description;

	@Column(name = "flower_type", columnDefinition = "char", length = 2)
	@Getter
	@Setter
	private String flowerType;

	@Column(name = "user_created", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private Long userCreated;

	@Column(name = "date_created", columnDefinition = "datetime", nullable = false)
	@Getter
	@Setter
	private Date dateCreated;

	@ManyToMany
	private Set<Terpene> terpenes;

	public Strain() {

	}
}