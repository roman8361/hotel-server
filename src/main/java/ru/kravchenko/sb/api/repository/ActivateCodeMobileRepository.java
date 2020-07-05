package ru.kravchenko.sb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.sb.domain.entity.ActivateCodeMobile;

import java.util.List;


@Repository
public interface ActivateCodeMobileRepository extends JpaRepository<ActivateCodeMobile, String> {

    @Query(value = "select activate_code_mobile from activate_cods_mobile", nativeQuery = true)
    List<String> getAllActivateCodeMobile();

    ActivateCodeMobile findByActivateCodeMobile(String activateCodeMobile);

}
