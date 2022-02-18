package us.mattroberts.weedbuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.mattroberts.weedbuddy.model.entity.Dispensary;

@Repository
public interface DispensaryRepository extends CrudRepository<Dispensary, Long> {

}
