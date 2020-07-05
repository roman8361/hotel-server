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
@Table(name = "activate_cods_mobile")
public class ActivateCodeMobile extends AbstractEntity{

    private String activateCodeMobile;

    private Date dateCreateCode;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

}
