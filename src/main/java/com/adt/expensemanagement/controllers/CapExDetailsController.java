package com.adt.expensemanagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adt.expensemanagement.models.CapExDetails;
import com.adt.expensemanagement.services.interfaces.CapExDetailsService;

@RestController
@RequestMapping("/capExDetails")
public class CapExDetailsController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CapExDetailsService capExDetailsService;

	@PreAuthorize("@auth.allow('ROLE_ADMIN')")
	@PostMapping("/createCapExDetails")
	public ResponseEntity<CapExDetails> createCapExDetails(@RequestBody CapExDetails capExDetails,
			HttpServletRequest request) {
		LOGGER.info("API Call From IP: " + request.getRemoteHost());
		CapExDetails details = capExDetailsService.createCapExDetails(capExDetails);
		return new ResponseEntity<>(details, HttpStatus.OK);
	}
}
