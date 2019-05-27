package com.hci.test.service.Impl;

import com.hci.test.domain.request.PatchDetailRequest;
import com.hci.test.domain.request.PatchRequest;
import com.hci.test.domain.response.GetAllResponse;
import com.hci.test.domain.response.GetDetailResponse;
import com.hci.test.domain.response.GetResponse;
import com.hci.test.entity.Groups;
import com.hci.test.entity.Orders;
import com.hci.test.repository.GroupsRepository;
import com.hci.test.repository.ModulesRepository;
import com.hci.test.repository.OrdersRepository;
import com.hci.test.service.ApiService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiServiceImpl implements ApiService {

  private final GroupsRepository groupsRepository;
  private final ModulesRepository modulesRepository;
  private final OrdersRepository ordersRepository;

  @Override
  public ResponseEntity getAll() {
    List<Groups> groupsList = groupsRepository.findAll();
    List<Orders> ordersList = ordersRepository.findAll();
    List<GetAllResponse> response = new ArrayList<>();
    for (Groups groups : groupsList) {
      GetAllResponse getAllResponse = new GetAllResponse();
      getAllResponse.setGroupName(groups.getName());
      List<GetDetailResponse> getDetailResponseList = new ArrayList<>();
      for (Orders orders : ordersList) {
        GetDetailResponse getDetailResponse = new GetDetailResponse();
        if (orders.getGroups() == groups) {
          getDetailResponse.setModuleName(orders.getModules().getName());
          getDetailResponse.setModuleOrder(orders.getOrders());
          getDetailResponseList.add(getDetailResponse);
        }
      }
      getAllResponse.setModules(getDetailResponseList);
      response.add(getAllResponse);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity get(Long id) {
    List<Orders> ordersList = ordersRepository.findAllByGroups_IdOrderByOrders(id);
    GetResponse response = new GetResponse();
    List<GetDetailResponse> getDetailResponseList = new ArrayList<>();
    for (Orders orders : ordersList) {
      GetDetailResponse getDetailResponse = new GetDetailResponse();
      getDetailResponse.setModuleName(orders.getModules().getName());
      getDetailResponse.setModuleOrder(orders.getOrders());
      getDetailResponseList.add(getDetailResponse);
    }
    response.setModules(getDetailResponseList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity patch(Long id, PatchRequest request) {
    List<Orders> ordersList = ordersRepository.findAllByGroups_IdOrderByOrders(id);
    List<Orders> patchOrderList = new ArrayList<>();
    for (PatchDetailRequest x : request.getModules()) {
      for (Orders orders : ordersList) {
        if (orders.getModules().getName().equals(x.getModuleName())) {
          orders.setOrders(x.getModuleOrder());
          patchOrderList.add(orders);
        }
      }
    }
    ordersRepository.saveAll(patchOrderList);
    return new ResponseEntity<>(patchOrderList.size() + " rows affected.", HttpStatus.OK);
  }
}
