package com.ccsp.accums.ledger.header.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsp.accums.ledger.entry.dto.LedgerEntryDTO;
import com.ccsp.accums.ledger.header.dto.AccumUtilization;
import com.ccsp.accums.ledger.header.dto.LedgerHeaderDTO;
import com.ccsp.accums.ledger.header.service.LedgerHeaderService;
import com.ccsp.common.utils.UIConstants;
import com.ccsp.common.validator.Validator;
import com.sun.xml.xsom.impl.scd.ParseException;

import javassist.NotFoundException;

/**
 * This controller holds the methods to perform CURD operations on ledger
 * header.
 * 
 * @author nnarayanaperumaln
 *
 */
@RestController
public class LedgerHeaderController {
	/**
	 * Logger for AccumsController
	 */
	private static Logger log = Logger.getLogger(LedgerHeaderController.class);

	@Autowired
	private LedgerHeaderService accumulationHeaderService;

	private Validator validator = new Validator();

	/**
	 * Fetches all the ledgerHeaders
	 * 
	 * @return LedgerHeaders
	 * @throws NotFoundException
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.GET, produces = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public List<LedgerHeaderDTO> getLedgerHeader() throws NotFoundException {
		log.info("Get all members accums details");
		return accumulationHeaderService.readAll();
	}

	/**
	 * Persist the received LedgerHeader Details
	 * 
	 * @param ledgerHeaderDTO
	 */
	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.POST, consumes = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public LedgerHeaderDTO createLedgerHeader(@RequestBody AccumUtilization accumUtilization) {
		log.info("Create LedgerHeader details");
		// validate the DTO - basic Java validation
		validator.validate(accumUtilization);
		return accumulationHeaderService.create(accumUtilization);
	}

	/**
	 * Persist the received LedgerHeader Details from CSV file
	 * @param multipart
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException 
	 */
	@RequestMapping(value = UIConstants.LEDGER_HEADER_CSV, headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void createLedgerHeader(@RequestParam("file") MultipartFile multipart)
			throws ParseException, java.text.ParseException, IOException {

		BufferedReader br;

		String line = "";
		String cvsSplitBy = ","; // CSV is separated by comma

		InputStream is = multipart.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		br.readLine(); // To skip 1st line

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String end_Date = "12/31/2017";
		Date endDate = df.parse(end_Date);
		String start_Date = "01/01/2017";
		Date startDate = df.parse(start_Date);

		LedgerHeaderDTO header = null;
		List<LedgerHeaderDTO> headerList = new ArrayList<>();
		List<LedgerEntryDTO> serviceLines = null;
		Map<Integer, LedgerHeaderDTO> map = new HashMap<>();

		while ((line = br.readLine()) != null) {
			// use comma as separator
			String[] column = line.split(cvsSplitBy);

			// Below conditions checks for an existing header in CSV, if not found new
			// header is created
			if (map.get(Integer.parseInt(column[0])) == null) {
				header = new LedgerHeaderDTO(); // new header is created
				header.setDcn(column[1]);
				header.setClaimLineId(Integer.parseInt(column[2]));
				header.setServiceId(Integer.parseInt(column[3]));
				header.setServiceName(column[4]);
				header.setServiceDate(df.parse(column[5]));
				header.setProcessedDate(df.parse(column[6]));
				header.setNetworkCode(column[7]);
				header.setNetworkTier(column[8]);
				header.setPlanId(Integer.parseInt(column[9]));
				header.setAllowedAmount(Double.parseDouble(column[10]));
				header.setMemberId(column[11]);
				header.setSubscriberId(column[12]);
				header.setUnitOfMeasure(column[13]);
				header.setAccumType(column[14]);
				header.setTransactionCode(column[15]);
				header.setMaxAmount(Double.parseDouble(column[16]));
				header.setMaxVisit(Integer.parseInt(column[17]));
				header.setEndDate(endDate);
				header.setEffectiveDate(startDate);

				serviceLines = new ArrayList<>();
				map.put(Integer.parseInt(column[0]), header); // Storing header to fetch for same service lines
				headerList.add(header); // creating list of header for further processing after reading CSV file
			}

			// Creation of Service lines
			LedgerEntryDTO entryDTO = new LedgerEntryDTO();
			entryDTO.setAccumType(column[18]);
			entryDTO.setRole(column[19]);
			entryDTO.setAmount(header.getAllowedAmount());
			entryDTO.setCostShareTier(header.getNetworkTier());
			entryDTO.setNetwork(header.getNetworkCode());
			entryDTO.setSnapshotSummmary(header.getAllowedAmount());
			entryDTO.setUnitOfMeasure(header.getUnitOfMeasure());
			entryDTO.setServiceDate(header.getServiceDate());
			serviceLines.add(entryDTO);
			header.setServiceLines(serviceLines);

		}

		// Actual header creation by calling create service and passing one header from
		// headerList created from CSV
		for (LedgerHeaderDTO dto : headerList) {
			accumulationHeaderService.create(dto);
		}
	}

	@RequestMapping(value = "/fileupload", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void upload(@RequestParam("file") MultipartFile inputFile) {
		LedgerHeaderDTO header = new LedgerHeaderDTO();
		if (!inputFile.isEmpty()) {
			ByteArrayInputStream stream = null;
			try {
				stream = new ByteArrayInputStream(inputFile.getBytes());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				JAXBContext context = JAXBContext.newInstance(LedgerHeaderDTO.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				header = (LedgerHeaderDTO) unmarshaller.unmarshal(stream);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		accumulationHeaderService.create(header);
	}

	@RequestMapping(path = UIConstants.LEDGER_HEADER, method = RequestMethod.PUT, consumes = {
			"application/json; charset=utf-8", "application/xml; charset=utf-8" })
	@ResponseBody
	public LedgerHeaderDTO updateLedgerHeader(@RequestBody AccumUtilization claimsForAccumulationHeaderDTO) {
		log.info("Create LedgerHeader details");
		LedgerHeaderDTO accumulationHeaderDTO = claimsForAccumulationHeaderDTO;
		return accumulationHeaderService.update(accumulationHeaderDTO);
	}
}