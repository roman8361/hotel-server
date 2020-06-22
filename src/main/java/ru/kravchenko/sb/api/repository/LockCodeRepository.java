package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.entity.LockCode;

@Repository
public interface LockCodeRepository extends JpaRepository<LockCode, String> {

    LockCode findByRoomNumber(final String roomNumber);

}
