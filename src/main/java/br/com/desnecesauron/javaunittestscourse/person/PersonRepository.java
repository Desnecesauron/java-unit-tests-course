package br.com.desnecesauron.javaunittestscourse.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    @Query("SELECT p FROM Person p WHERE p.firstName = ?1 AND p.lastName = ?2")
    Person findByJPQL(String firstName, String lastName);

    @Query("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName")
    Person findByJPQLNamedParameters(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(value = "SELECT * FROM person p WHERE p.first_name = :firstName AND p.last_name = :lastName", nativeQuery
            = true)
    Person findByNativeSQL(String firstName, String lastName);
}
