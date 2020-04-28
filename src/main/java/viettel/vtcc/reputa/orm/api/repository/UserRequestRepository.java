package viettel.vtcc.reputa.orm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import viettel.vtcc.reputa.orm.api.model.UserRequest;

@Repository
public interface UserRequestRepository extends CrudRepository<UserRequest, String> {
    UserRequest findByUsername(String username);
}
