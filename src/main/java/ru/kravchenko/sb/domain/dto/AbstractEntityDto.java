package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AbstractEntityDto {

    private String id = UUID.randomUUID().toString();

}
