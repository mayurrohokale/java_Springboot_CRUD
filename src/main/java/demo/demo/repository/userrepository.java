package demo.demo.repository;

import demo.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepository extends JpaRepository<user,Long> {


}
