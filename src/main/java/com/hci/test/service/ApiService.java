package com.hci.test.service;

import com.hci.test.domain.request.PatchRequest;
import org.springframework.http.ResponseEntity;

public interface ApiService {

  ResponseEntity getAll();

  ResponseEntity get(Long id);

  ResponseEntity patch(Long id, PatchRequest request);
}
