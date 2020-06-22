package ru.kravchenko.sb.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "APP_GUEST")
public class Guest extends AbstractEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "CUR_NAME")
    private String surName;

    @Column(name = "ARRIVAL_DATE")
    private Date arrivalDate;

    @Column(name = "DEPARTURE_DATE")
    private Date departureDate;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "CODE_ACTIVATE_MOBILE_APP")
    private String codeActivateMobileApp;

    public Guest(String firstName, String secondName, String surName, Date arrivalDate,
                 Date departureDate, String roomNumber, String codeActivateMobileApp) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomNumber = roomNumber;
        this.codeActivateMobileApp = codeActivateMobileApp;
    }

}
