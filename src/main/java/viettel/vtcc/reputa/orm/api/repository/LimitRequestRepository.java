package viettel.vtcc.reputa.orm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import viettel.vtcc.reputa.orm.api.model.LimitRequest;

@Repository
public interface LimitRequestRepository extends CrudRepository<LimitRequest, String> {
}
