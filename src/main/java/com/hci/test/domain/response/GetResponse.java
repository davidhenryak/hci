package com.hci.test.domain.response;

import java.util.List;
import lombok.Data;

@Data
public class GetResponse {
  private List<GetDetailResponse> modules;
}
