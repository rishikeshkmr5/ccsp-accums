package com.ccsp.accums.category.type.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
import javassist.NotFoundException;

/**
 * @author vamehta
 *
 */
@RestController
@Api(description = UIConstants.API_CATEGORY_TYPE_DES, produces = "application/json", tags = {
		UIConstants.API_CATEGORY_TYPE_TAG }, hidden = false)
public class CategoryTypeController {

	@Autowired
	private CategoryTypeService categoryTypeService;

	/**
	 * Persist the received Category Details from CSV file
	 * 
	 * @param multipart
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@ApiOperation(value = UIConstants.API_CATEGORY_TYPE_CREATE_CSV, tags = { UIConstants.API_CATEGORY_TYPE_TAG }, hidden = false)
	@RequestMapping(value = UIConstants.CATEGORY_TYPE_CSV, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody String createCategoryType(@RequestParam("file") MultipartFile multipart)
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
			categoryTypeDTOs.add(categoryTypeDTO);
		}
		// create categories in category table
		if (CollectionUtils.isNotEmpty(categoryTypeDTOs))
			categoryTypeDTOs = categoryTypeService.create(categoryTypeDTOs);

		return "Categories created : " + categoryTypeDTOs.size();
	}

	/**
	 * fetch all the list of values based on category type
	 * 
	 * @param category
	 * @throws NotFoundException
	 */
	@ApiOperation(value = UIConstants.API_CATEGORY_TYPE_INQUIRE, tags = { UIConstants.API_CATEGORY_TYPE_TAG }, hidden = false)
	@RequestMapping(path = UIConstants.CATEGORY, method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public List<CategoryTypeDTO> getValuesByCategory(@PathVariable("category-Type") String category)
			throws NotFoundException {
		return categoryTypeService.getListOfValues(category);

	}

}