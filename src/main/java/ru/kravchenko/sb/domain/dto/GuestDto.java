package ru.kravchenko.sb.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GuestDto extends AbstractEntityDto{

    private String firstName;

    private String secondName;

    private String surName;

    private Date arrivalDate;

    private Date departureDate;

    private String roomId;

    public GuestDto(String firstName, String secondName, String surName, Date arrivalDate,
                    Date departureDate, String roomId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomId = roomId;
    }

}
