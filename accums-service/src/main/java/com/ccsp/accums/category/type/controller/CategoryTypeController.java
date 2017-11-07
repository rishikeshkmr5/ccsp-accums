package com.ccsp.accums.category.type.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsp.accums.category.type.dto.CategoryTypeDTO;
import com.ccsp.accums.category.type.service.CategoryTypeService;
import com.ccsp.common.utils.UIConstants;
import com.sun.xml.xsom.impl.scd.ParseException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author vamehta
 *
 */
@RestController
@Api(description = UIConstants.API_CATEGORY_TYPE_DES, produces = "application/json", tags = {
		UIConstants.API_CATEGORY_TYPE_TAG }, hidden=true)
public class CategoryTypeController {

	@Autowired
	private CategoryTypeService categoryTypeService;

	/**
	 * Persist the received LedgerHeader Details from CSV file
	 * 
	 * @param multipart
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@ApiOperation(value = UIConstants.API_CATEGORY_TYPE_CREATE_CSV, tags = { UIConstants.API_CATEGORY_TYPE_TAG }, hidden=true)
	@RequestMapping(value = UIConstants.API_CATEGORY_TYPE_CREATE_CSV, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void createCategoryType(@RequestParam("file") MultipartFile multipart)
			throws ParseException, java.text.ParseException, IOException {

		BufferedReader br;

		String line = "";
		String cvsSplitBy = ","; // CSV is separated by comma

		InputStream is = multipart.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		br.readLine(); // To skip 1st line

		CategoryTypeDTO categoryTypeDTO = null;
		List<CategoryTypeDTO> categoryTypeDTOs = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			// use comma as separator
			String[] column = line.split(cvsSplitBy);
			categoryTypeDTO = new CategoryTypeDTO();
			categoryTypeDTO.setCategory(column[1]);
			categoryTypeDTO.setCode(column[2]);
			categoryTypeDTO.setDisplayName(column[3]);
			categoryTypeDTO.setActive(column[4].charAt(0));
			categoryTypeDTOs.add(categoryTypeDTO);
		}
		if(CollectionUtils.isNotEmpty(categoryTypeDTOs))
		categoryTypeService.create(categoryTypeDTOs);
	}

}