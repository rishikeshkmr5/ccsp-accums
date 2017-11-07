package com.ccsp.accums.category.type.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author vamehta
 *
 */
@Entity
@Table(name = "CATEGORY_TYPE")
public class CategoryTypeEntity  implements java.io.Serializable {
	
	/**
	 * Default serialization id
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORY_TYPE")
	@SequenceGenerator(name = "SEQ_CATEGORY_TYPE", sequenceName = "SEQ_CATEGORY_TYPE", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "CODE",nullable = false)
	private String code;
	
	@Column(name = "DISPLAY_NAME", nullable = true)
	private String displayName;
	
	@Column(name = "ACTIVE", nullable = true, length=1)
	private char active;
	
	/**
	 * Default constructor.
	 */
	public CategoryTypeEntity() { }

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return
	 */
	public char getActive() {
		return active;
	}

	/**
	 * @param active
	 */
	public void setActive(char active) {
		
		this.active = active;
	}
	
}
