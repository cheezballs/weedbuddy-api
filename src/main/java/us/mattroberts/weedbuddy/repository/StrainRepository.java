package us.mattroberts.weedbuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.mattroberts.weedbuddy.model.entity.Strain;

@Repository
public interface StrainRepository extends CrudRepository<Strain, Long> {

}
