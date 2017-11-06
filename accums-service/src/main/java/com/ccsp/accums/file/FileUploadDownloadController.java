package com.ccsp.accums.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsp.common.report.DownloadReport;
import com.ccsp.common.report.UploadReport;



/**
 * This controller holds the methods to perform CURD operations on ledger
 * header.
 * 
 * @author rishkumar
 *
 */
@RestController
public class FileUploadDownloadController {
	/**
	 * Logger for AccumsController
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	DownloadReport downloadReport;

	@Autowired
	UploadReport uploadReport;
	
	

	/**
	 * This endpoint takes the file and saves it in database/to a location. *
	 * 
	 * @param file
	 *            The requested file object
	 * @return ResponseEntity the status of the file being uploaded
	 * @throws IOException
	 *             Exception if there is some issue while processing the uploaded
	 *             requested file
	 * @author rishkumar
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {

		if (file.isEmpty()) {
			log.info("file  is empty!");
			
			return new ResponseEntity<Object>("please select a file!", HttpStatus.OK);
		}
		log.info("Going to save file");
		ResponseEntity<Object> fileUploadResponse = uploadReport.saveUploadedFiles(file);
		return fileUploadResponse;

	}

	/**
	 * This endpoint shows the option of downloading the file upon hitting the url.
	 * 
	 * @param fileName
	 *            name of the file to be downloaded.
	 * @return ResponseEntity contains the requested file
	 * @throws IOException
	 *             Exception if there is some issue while processing the requested
	 *             file
	 */
	@RequestMapping(value = "/downloadReport", method = RequestMethod.GET)
	public ResponseEntity downloadFIle(@RequestParam("fileName") String fileName) throws IOException {

		if (fileName.isEmpty()) {
			log.info("file name is empty!");
			return new ResponseEntity<Object>("please provide a file Name!", HttpStatus.BAD_REQUEST);
		}
		log.info("Going to download the file: " + fileName);
		return downloadReport.downloadReport(fileName);

	}

}