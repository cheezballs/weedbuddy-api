package us.mattroberts.weedbuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.mattroberts.weedbuddy.exception.NotFoundException;
import us.mattroberts.weedbuddy.model.entity.Brand;
import us.mattroberts.weedbuddy.model.input.BrandInput;
import us.mattroberts.weedbuddy.model.mapper.BrandMapper;
import us.mattroberts.weedbuddy.repository.BrandRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController {

	@Autowired
	BrandRepository brandRepository;

	@PostMapping("update/{id}")
	public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @Valid @RequestBody BrandInput input) {
		Brand brand = brandRepository.findById(id).orElseThrow(NotFoundException::new);
		BrandMapper.mapFromInput(brand, input);
		brandRepository.save(brand);
		return ResponseEntity.ok(brand);
	}

	@PostMapping("create")
	public ResponseEntity<Brand> createBrand(@Valid @RequestBody BrandInput input, Principal principal) {
		Brand brand = BrandMapper.mapFromInput(input);
		brandRepository.save(brand);
		return ResponseEntity.ok(brand);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Brand> getBrand(@PathVariable Long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		return ResponseEntity.ok(brand.orElseThrow(NotFoundException::new));
	}

}
