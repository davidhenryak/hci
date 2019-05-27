package com.hci.test.controller;

import com.hci.test.domain.request.PatchRequest;
import com.hci.test.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiController {

  private final ApiService apiService;

  @GetMapping()
  public ResponseEntity getAll() {
    return apiService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable Long id) {
    return apiService.get(id);
  }

  @PatchMapping("/{id}")
  public ResponseEntity patch(@PathVariable Long id, @RequestBody PatchRequest request) {
    return apiService.patch(id, request);
  }
}
