package com.hci.test.domain.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class GetAllResponse implements Serializable {
  private String groupName;
  private List<GetDetailResponse> modules;
}
