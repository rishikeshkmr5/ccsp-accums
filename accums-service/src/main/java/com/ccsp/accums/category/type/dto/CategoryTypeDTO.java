package com.ccsp.accums.category.type.dto;

import com.ccsp.common.dto.ICommonDTO;

/**
 * @author vamehta
 *
 */
public class CategoryTypeDTO  implements ICommonDTO {
	
	/**
	 * serialization
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String category;
	
	private String code;
	
	private String displayName;
	
	private char active;
	
	/**
	 * Default constructor.
	 */
	public CategoryTypeDTO() { }

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
