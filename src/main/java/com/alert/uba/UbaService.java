package com.alert.uba;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UbaService {
    DataResponse fetchData() throws IOException;
}
