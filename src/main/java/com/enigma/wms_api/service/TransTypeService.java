package com.enigma.wms_api.service;

import com.enigma.wms_api.entity.TransType;

public interface TransTypeService {
    TransType saveTransType(TransType transType);
    TransType getById(String id);
}
