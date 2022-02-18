package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.weedbuddy.model.entity.WBUser;
import us.mattroberts.weedbuddy.repository.UserRepository;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController {

	@Autowired
	UserRepository userRepository;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@GetMapping("/whoami")
	public WBUser whoami(Principal principal) {
		return userRepository.findByIdpIdentifier(principal.getName());
	}

	protected Long getCurrentUserId(Principal principal) {
		return whoami(principal).getId();
	}

}
