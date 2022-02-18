package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dispensary")
@Builder
@AllArgsConstructor
public class Dispensary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;


	@Column(name = "name", columnDefinition = "varchar", length = 100, nullable = false)
	@Getter
	@Setter
	private String name;

	@Column(name = "address", columnDefinition = "varchar", length = 250)
	@Getter
	@Setter
	private String address;

	@Column(name = "city", columnDefinition = "varchar", length = 100)
	@Getter
	@Setter
	private String city;

	@Column(name = "state", columnDefinition = "char", length = 2)
	@Getter
	@Setter
	private String state;

	@Column(name = "gps_coordinates", columnDefinition = "point")
	@Getter
	@Setter
	private String gpsCoordinates;

	public Dispensary() {

	}
}