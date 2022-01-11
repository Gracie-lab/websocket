package com.alert.uba.service;

import com.alert.uba.dto.DataResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UbaService {
    DataResponse fetchData() throws IOException;
}
