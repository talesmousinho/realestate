package com.realestate.server.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @ManyToOne
  @JoinColumn(nullable = false)
  private Client client;

  @NotNull
  @ManyToOne
  @JoinColumn(nullable = false)
  private Property property;

  @NotNull
  @Digits(integer = 6, fraction = 2)
  @Column(nullable = false, precision = 8, scale = 2)
  private BigDecimal amount;

  @NotNull
  @Column(nullable = false)
  private Boolean applyInterest = false;

  @NotNull
  @Column(nullable = false)
  private LocalDate startDate;

}
