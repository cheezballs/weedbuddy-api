package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.weedbuddy.model.entity.WBUser;
import us.mattroberts.weedbuddy.repository.UserRepository;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/whoami")
	public WBUser whoami(Principal principal) {
		return userRepository.findByIdpIdentifier(principal.getName());
	}

	@GetMapping("/{id}")
	public WBUser getUserDetails(@PathVariable Long id) {
		Optional<WBUser> user = userRepository.findById(id);
		return user.orElse(null);
	}

}
