package us.mattroberts.weedbuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.mattroberts.weedbuddy.model.entity.WBUser;

@Repository
public interface UserRepository extends CrudRepository<WBUser, Long> {

	WBUser findByIdpIdentifier(String idpIdentifier);

}
