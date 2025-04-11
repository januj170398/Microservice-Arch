package com.anuj.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class Accounts extends BaseEntity{

    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "account_number")
    @Id
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
}
