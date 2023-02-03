package anstar.StepTrello.repository;

import anstar.StepTrello.Entity.Role;
import anstar.StepTrello.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, CrudRepository<Role,Long> {
    Role findByName(String name);
}
