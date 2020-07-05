package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
