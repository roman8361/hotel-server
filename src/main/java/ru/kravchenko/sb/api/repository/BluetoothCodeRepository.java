package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.domain.entity.BluetoothCode;

@Repository
public interface BluetoothCodeRepository extends JpaRepository<BluetoothCode, String> {

    BluetoothCode findByRoomId(final String roomNumber);

}
