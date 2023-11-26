package com.realestate.server.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Property {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(nullable = false)
  private String title;

  @NotNull
  @Column(nullable = false)
  private String address;

  @NotNull
  @Digits(integer = 8, fraction = 2)
  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  private String description;
}
