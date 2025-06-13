package com.lsy.lsytechretrospect.common.utils;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Slf4j
public class ValidationUtil {

	public static void invokeErrors(String className, BindingResult br) throws ValidationException {

		log.error("Validation Error @Class={}", className);

		List<ObjectError> errList = br.getAllErrors();

		for(ObjectError err : errList) {
			log.error(err.toString());
		}

		throw new ValidationException("Validation Failed");

	}

}
