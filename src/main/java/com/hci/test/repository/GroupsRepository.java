package com.hci.test.repository;

import com.hci.test.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
  Groups findByName(String name);
}
