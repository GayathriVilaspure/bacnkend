package org.wtt.solarapp.solar_app.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.wtt.solarapp.solar_app.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}