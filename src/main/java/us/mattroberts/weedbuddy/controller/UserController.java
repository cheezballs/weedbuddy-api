package us.mattroberts.weedbuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.weedbuddy.model.entity.WBUser;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@GetMapping("/{id}")
	public WBUser getUserDetails(@PathVariable Long id) {
		Optional<WBUser> user = userRepository.findById(id);
		return user.orElse(null);
	}

}
