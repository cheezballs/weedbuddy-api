package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
@Builder
@AllArgsConstructor
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;


	@Column(name = "dispensary", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private String dispensary;

	@Column(name = "purchase_date", columnDefinition = "date")
	@Getter
	@Setter
	private Date purchaseDate;

	@Column(name = "user_created", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private Long userCreated;

	@Column(name = "date_created", columnDefinition = "datetime", nullable = false)
	@Getter
	@Setter
	private Date dateCreated;

	public Purchase() {

	}
}