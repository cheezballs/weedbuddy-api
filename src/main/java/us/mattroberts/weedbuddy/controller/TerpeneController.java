package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.mattroberts.weedbuddy.exception.NotFoundException;
import us.mattroberts.weedbuddy.model.entity.Terpene;
import us.mattroberts.weedbuddy.model.input.TerpeneInput;
import us.mattroberts.weedbuddy.model.mapper.TerpeneMapper;
import us.mattroberts.weedbuddy.repository.TerpeneRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("terpene")
public class TerpeneController extends BaseController {

	@Autowired
	TerpeneRepository terpeneRepository;

	@PostMapping("update/{id}")
	public ResponseEntity<Terpene> updateTerpene(@PathVariable Long id, @Valid @RequestBody TerpeneInput input) {
		Terpene terpene = terpeneRepository.findById(id).orElseThrow(NotFoundException::new);
		TerpeneMapper.mapFromInput(terpene, input);
		terpeneRepository.save(terpene);
		return ResponseEntity.ok(terpene);
	}

	@PostMapping("create")
	public ResponseEntity<Terpene> createTerpene(@Valid @RequestBody TerpeneInput input, Principal principal) {
		Terpene terpene = TerpeneMapper.mapFromInput(input);
		terpeneRepository.save(terpene);
		return ResponseEntity.ok(terpene);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Terpene> getTerpene(@PathVariable Long id) {
		Optional<Terpene> terpene = terpeneRepository.findById(id);
		return ResponseEntity.ok(terpene.orElseThrow(NotFoundException::new));
	}

}
