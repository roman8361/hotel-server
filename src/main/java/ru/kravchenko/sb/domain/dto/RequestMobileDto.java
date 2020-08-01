package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMobileDto extends AbstractEntityDto {

    private String codeActivate;

    private String token;

}
