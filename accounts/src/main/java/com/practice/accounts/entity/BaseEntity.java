package com.practice.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
public class BaseEntity {
    @Column(updatable = false)
    private LocalDate createdAt;
    @Column(updatable = false)
    private String createdBy;
    @Column(insertable = false)
    private LocalDate updateAt;
    @Column(insertable = false)
    private String updatedBy;
}
