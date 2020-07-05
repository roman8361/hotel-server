package ru.kravchenko.sb.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kravchenko.sb.domain.dto.RoomDto;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class Room extends AbstractEntity {

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "is_busy")
    private Boolean isBusy = false;

    //    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guest> guests;

    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private BluetoothCode bluetoothCode;

    public RoomDto getDto() {
        final RoomDto dto = new RoomDto(roomNumber, isBusy, bluetoothCode.getId());
        dto.setId(id);
        return dto;
    }

}
