package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "terpene")
@Builder
@AllArgsConstructor
public class Terpene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Column(name = "name", columnDefinition = "name", length = 50, nullable = false)
	@Getter
	@Setter
	private String name;

	@Column(name = "description", columnDefinition = "text")
	@Getter
	@Setter
	private String description;

	@ManyToMany
	private Set<Strain> strains;

	public Terpene() {

	}
}