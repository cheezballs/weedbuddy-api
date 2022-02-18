package us.mattroberts.weedbuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.mattroberts.weedbuddy.model.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

}
