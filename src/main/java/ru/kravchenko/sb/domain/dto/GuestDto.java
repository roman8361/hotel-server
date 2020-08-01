package ru.kravchenko.sb.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GuestDto extends AbstractEntityDto{

    private String firstName;

    private String secondName;

    private String surName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date arrivalDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date departureDate;

    private String roomNumber;

    private String activateCodeMobile;

    private String roomId;

    private String activateCodeMobileId;

    public GuestDto(){}

    public GuestDto(String firstName, String secondName, String surName, Date arrivalDate,
                    Date departureDate, String roomId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "GuestDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surName='" + surName + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", roomNumber='" + roomNumber + '\'' +
                ", activateCodeMobile='" + activateCodeMobile + '\'' +
                ", roomId='" + roomId + '\'' +
                ", activateCodeMobileId='" + activateCodeMobileId + '\'' +
                '}';
    }

}
