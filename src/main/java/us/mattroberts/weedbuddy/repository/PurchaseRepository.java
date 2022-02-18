package us.mattroberts.weedbuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.mattroberts.weedbuddy.model.entity.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}
