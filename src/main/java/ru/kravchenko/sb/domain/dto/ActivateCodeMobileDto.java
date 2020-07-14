package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActivateCodeMobileDto extends AbstractEntityDto {

    private String activateCodeMobile;

    private Date dateCreateCode;

    private String guestId;

}
