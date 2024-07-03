package com.account_service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "account",
        uniqueConstraints = {@UniqueConstraint(name = "UniqueBranchAndNumber", columnNames = {"branch", "number"})})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id", unique = true, updatable = false, nullable = false)
    private UUID publicId;

    @Column(name = "number", insertable = false)
    private Long number = null;

    @Column(name = "branch", nullable = false)
    private Long branch;

    public int getBankNumber() {
        return 1;
    }
}
