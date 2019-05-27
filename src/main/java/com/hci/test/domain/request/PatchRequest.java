package com.hci.test.domain.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class PatchRequest implements Serializable {
  List<PatchDetailRequest> modules;
}
