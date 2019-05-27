package com.hci.test.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Orders implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "group_id", nullable = false)
  private Groups groups;
  @ManyToOne
  @JoinColumn(name = "module_id", nullable = false)
  private Modules modules;
  @Column(nullable = false)
  private Integer orders;
}
