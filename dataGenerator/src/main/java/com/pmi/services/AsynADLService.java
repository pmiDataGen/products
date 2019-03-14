package com.pmi.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.AgeVerification;
import com.pmi.pojo.Cases;
import com.pmi.pojo.Device;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Interaction;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.Segments;
import com.pmi.pojo.Vouchers;

/**
 * @author vikas.e.mishra
 *
 */
@Service
public class AsynADLService {

	private static final Logger logger = LoggerFactory.getLogger(AsynADLService.class);
	private final RestTemplate restTemplate;

	public AsynADLService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	/**
	 * Make lookup API Asynchronous call
	 * 
	 * @param uri
	 * @param entity
	 * @param readAPIObj
	 * @return
	 */
	@Async // indicating this method will run on a separate thread
	public CompletableFuture<ResponseEntity> callReadService(String uri, HttpEntity<String> entity, Object readAPIObj) {
		logger.info("Calling ID LookUp @ -> "
				+ new SimpleDateFormat("HH:mm:ss:SS aa").format(Calendar.getInstance().getTime()) + " ; URI -> " + uri);
		long startTime = System.currentTimeMillis();
		ResponseEntity responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, readAPIObj.getClass());
		long endTime = System.currentTimeMillis();
		logger.info("Time taken to make lookup API call for " + readAPIObj.getClass().getName() + " is "
				+ (endTime - startTime) + " milliseconds");
		if (responseEntity.getBody() instanceof Persona) {
			Persona persona = (Persona) responseEntity.getBody();
			persona.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Identities) {
			Identities identities = (Identities) responseEntity.getBody();
			identities.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Orders) {
			Orders orders = (Orders) responseEntity.getBody();
			orders.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Cases) {
			Cases cases = (Cases) responseEntity.getBody();
			cases.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Device) {
			Device device = (Device) responseEntity.getBody();
			device.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Segments) {
			Segments segments = (Segments) responseEntity.getBody();
			segments.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Interaction) {
			Interaction interaction = (Interaction) responseEntity.getBody();
			interaction.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Vouchers) {
			Vouchers vouchers = (Vouchers) responseEntity.getBody();
			vouchers.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof AgeVerification) {
			AgeVerification ageVerification = (AgeVerification) responseEntity.getBody();
			ageVerification.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		}
		return CompletableFuture.completedFuture(responseEntity);
	}

	/**
	 * Make Asynchronous call to Write API service
	 * 
	 * @param uri
	 * @param entity
	 * @param writeAPIRequestObj
	 * @return
	 */
	@Async // indicating this method will run on a separate thread
	public CompletableFuture<ResponseEntity> callWriteService(String uri, HttpEntity<Object> entity,
			Object writeAPIRequestObj) {
		logger.info("Calling Write API @ -> "
				+ new SimpleDateFormat("HH:mm:ss:SS aa").format(Calendar.getInstance().getTime()) + " ; URI -> " + uri);
		long startTime = System.currentTimeMillis();
		ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, entity,
				writeAPIRequestObj.getClass());
		long endTime = System.currentTimeMillis();
		logger.info("Time taken to make writeAPI call for " + writeAPIRequestObj.getClass().getName() + " object is "
				+ (endTime - startTime) + " milliseconds");
		// logger.info("Write API Response Status Code -> " +
		// responseEntity.getStatusCode());

		if (responseEntity.getBody() instanceof Persona) {
			Persona persona = (Persona) responseEntity.getBody();
			persona.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Identities) {
			Identities identities = (Identities) responseEntity.getBody();
			identities.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Orders) {
			Orders orders = (Orders) responseEntity.getBody();
			orders.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Cases) {
			Cases cases = (Cases) responseEntity.getBody();
			cases.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Device) {
			Device device = (Device) responseEntity.getBody();
			device.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		}else if (responseEntity.getBody() instanceof Segments) {
			Segments segments = (Segments) responseEntity.getBody();
			segments.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Interaction) {
			Interaction interaction = (Interaction) responseEntity.getBody();
			interaction.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof Vouchers) {
			Vouchers vouchers = (Vouchers) responseEntity.getBody();
			vouchers.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		} else if (responseEntity.getBody() instanceof AgeVerification) {
			AgeVerification ageVerification = (AgeVerification) responseEntity.getBody();
			ageVerification.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
		}
		return CompletableFuture.completedFuture(responseEntity);
	}
}
