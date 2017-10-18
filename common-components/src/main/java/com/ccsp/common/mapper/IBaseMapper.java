/**
 * 
 */
package com.ccsp.common.mapper;

import java.io.Serializable;
import java.util.List;

import com.ccsp.common.dto.ICommonDTO;

/**
 * This interface provides the basic mapping to use for converting DTO
 * to Entity and vice-versa
 * @author rtalapaneni
 *
 */
public interface IBaseMapper<Entity extends Serializable, DTO extends ICommonDTO> {
	
	/**
	 * Converts the provided entity to a DTO.
	 * @param entity
	 * @return
	 */
	DTO convertToDTO(Entity entity);
	
	/**
	 * Converts the list of provided entities to list of DTO's
	 * @param entities
	 * @return
	 */
	List<DTO> convertToDTOList(List<Entity> entities);
	
	/**
	 * Converts the provided DTO to a entity.
	 * @param dto
	 * @return
	 */
	Entity convertToEntity(DTO dto);
	
	/**
	 * Converts the list of provided dto's to list of entities
	 * @param dto
	 * @return
	 */
	List<Entity> convertToEntityList(List<DTO> dto);
}
