package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.model.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {


}
