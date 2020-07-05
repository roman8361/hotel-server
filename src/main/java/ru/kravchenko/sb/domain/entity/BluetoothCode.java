package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "DICT_Bluetooth_Code")
public class BluetoothCode extends AbstractEntity {

    @Column(name = "bluetooth_code")
    private String bluetoothCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

}
