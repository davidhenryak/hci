package com.hci.test.domain.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class GetDetailResponse implements Serializable {
  private String moduleName;
  private Integer moduleOrder;
}
