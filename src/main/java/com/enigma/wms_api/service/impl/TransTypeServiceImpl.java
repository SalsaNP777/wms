package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.entity.TransType;
import com.enigma.wms_api.repository.TransTypeRepository;
import com.enigma.wms_api.service.TransTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransTypeServiceImpl implements TransTypeService {
    private final TransTypeRepository transTypeRepository;

    @Override
    public TransType saveTransType (TransType transType) {
        return transTypeRepository.save(transType);
    }

    @Override
    public TransType getById(String id) {
        Optional<TransType> optionalTransType = transTypeRepository.findById(id);
        if (optionalTransType.isPresent()) return optionalTransType.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "transactional type not found");
    }
}
