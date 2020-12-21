package ru.kravchenko.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sb.api.repository.BluetoothCodeRepository;
import ru.kravchenko.sb.api.service.BluetoothCodeService;
import ru.kravchenko.sb.domain.dto.BluetoothCodeDto;
import ru.kravchenko.sb.domain.entity.BluetoothCode;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BluetoothCodeServiceImpl implements BluetoothCodeService {

    @Autowired
    BluetoothCodeRepository bluetoothCodeRepository;

    @Override
    public List<BluetoothCodeDto> findAllBluetoothCodes() {
        List<BluetoothCode> list = bluetoothCodeRepository.findAll();
        return list.stream().map(BluetoothCode::getDto).collect(Collectors.toList());
    }

}
