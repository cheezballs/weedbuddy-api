package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.mattroberts.weedbuddy.exception.NotFoundException;
import us.mattroberts.weedbuddy.model.entity.Strain;
import us.mattroberts.weedbuddy.model.input.StrainInput;
import us.mattroberts.weedbuddy.model.mapper.StrainMapper;
import us.mattroberts.weedbuddy.repository.StrainRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("strain")
public class StrainController extends BaseController {

	@Autowired
	StrainRepository strainRepository;

	@PostMapping("update/{id}")
	public ResponseEntity<Strain> updateStrain(@PathVariable Long id, @Valid @RequestBody StrainInput input) {
		Strain strain = strainRepository.findById(id).orElseThrow(NotFoundException::new);
		StrainMapper.mapFromInput(strain, input);
		strainRepository.save(strain);
		return ResponseEntity.ok(strain);
	}

	@PostMapping("create")
	public ResponseEntity<Strain> createStrain(@Valid @RequestBody StrainInput input, Principal principal) {

		Strain strain = StrainMapper.mapFromInput(input);
		strain.setDateCreated(new Date());
		strain.setUserCreated(getCurrentUserId(principal));
		strainRepository.save(strain);
		return ResponseEntity.ok(strain);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Strain> getStrain(@PathVariable Long id) {
		Optional<Strain> strain = strainRepository.findById(id);
		return ResponseEntity.ok(strain.orElseThrow(NotFoundException::new));
	}

}
