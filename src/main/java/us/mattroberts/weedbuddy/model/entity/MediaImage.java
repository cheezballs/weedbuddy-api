package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "media_image")
@Builder
@AllArgsConstructor
public class MediaImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Column(name = "size", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private int size;

	@Column(name = "filename", columnDefinition = "varchar", length = 250, nullable = false)
	@Getter
	@Setter
	private String filename;

	@Column(name = "parent", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private Long parent;

	@Column(name = "parent_type", columnDefinition = "char", length = 2, nullable = false)
	@Getter
	@Setter
	private String parentType;

	@Column(name = "user_created", columnDefinition = "int", nullable = false)
	@Getter
	@Setter
	private Long userCreated;

	@Column(name = "date_created", columnDefinition = "datetime", nullable = false)
	@Getter
	@Setter
	private Date dateCreated;

	public MediaImage() {

	}
}