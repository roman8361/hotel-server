package ru.kravchenko.sb.api.service;

import ru.kravchenko.sb.domain.dto.BluetoothCodeDto;

import java.util.List;

public interface IBluetoothCodeService {

    List<BluetoothCodeDto> findAllBluetoothCodes();

}
