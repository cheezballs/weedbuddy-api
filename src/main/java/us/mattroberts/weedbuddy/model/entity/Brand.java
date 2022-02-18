package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Builder
@AllArgsConstructor
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;


	@Column(name = "name", columnDefinition = "varchar", length = 100, nullable = false)
	@Getter
	@Setter
	private String name;

	public Brand() {

	}
}