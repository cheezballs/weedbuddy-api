package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.mattroberts.weedbuddy.exception.NotFoundException;
import us.mattroberts.weedbuddy.model.entity.Dispensary;
import us.mattroberts.weedbuddy.model.input.DispensaryInput;
import us.mattroberts.weedbuddy.model.mapper.DispensaryMapper;
import us.mattroberts.weedbuddy.repository.DispensaryRepository;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("dispensary")
public class DispensaryController extends BaseController {

	@Autowired
	DispensaryRepository dispensaryRepository;

	@PostMapping("update/{id}")
	public ResponseEntity<Dispensary> updateDispensary(@PathVariable Long id, @Valid @RequestBody DispensaryInput input) {
		Dispensary dispensary = dispensaryRepository.findById(id).orElseThrow(NotFoundException::new);
		DispensaryMapper.mapFromInput(dispensary, input);
		dispensaryRepository.save(dispensary);
		return ResponseEntity.ok(dispensary);
	}

	@PostMapping("create")
	public ResponseEntity<Dispensary> createDispensary(@Valid @RequestBody DispensaryInput input) {
		Dispensary dispensary = DispensaryMapper.mapFromInput(input);
		dispensaryRepository.save(dispensary);
		return ResponseEntity.ok(dispensary);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dispensary> getDispensary(@PathVariable Long id) {
		Optional<Dispensary> dispensary = dispensaryRepository.findById(id);
		return ResponseEntity.ok(dispensary.orElseThrow(NotFoundException::new));
	}

}
