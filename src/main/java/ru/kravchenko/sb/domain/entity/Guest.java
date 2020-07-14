package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kravchenko.sb.domain.dto.GuestDto;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "guests")
public class Guest extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @OneToOne(mappedBy="guest", cascade = CascadeType.ALL, orphanRemoval = true)
    private ActivateCodeMobile activateCodeMobile;

    public GuestDto getDto() {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(id);
        guestDto.setFirstName(firstName);
        guestDto.setSecondName(secondName);
        guestDto.setSurName(surName);
        guestDto.setArrivalDate(arrivalDate);
        guestDto.setDepartureDate(departureDate);
        guestDto.setRoomId(room.getId());
        guestDto.setRoomNumber(room.getRoomNumber());
        guestDto.setActivateCodeMobile(activateCodeMobile.getActivateCodeMobile());
        guestDto.setActivateCodeMobileId(activateCodeMobile.getId());

        return guestDto;
    }

}
