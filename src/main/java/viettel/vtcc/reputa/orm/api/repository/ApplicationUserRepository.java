package viettel.vtcc.reputa.orm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viettel.vtcc.reputa.orm.api.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
