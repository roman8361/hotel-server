package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kravchenko.sb.domain.dto.ActivateCodeMobileDto;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "activate_cods_mobile")
public class ActivateCodeMobile extends AbstractEntity{

    private String activateCodeMobile;

    private Date dateCreateCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

    public ActivateCodeMobileDto getDto() {
        ActivateCodeMobileDto activateCodeMobileDto = new ActivateCodeMobileDto();
        activateCodeMobileDto.setActivateCodeMobile(activateCodeMobile);
        activateCodeMobileDto.setDateCreateCode(dateCreateCode);
        activateCodeMobileDto.setGuestId(guest.getId());

        return activateCodeMobileDto;
    }

}
