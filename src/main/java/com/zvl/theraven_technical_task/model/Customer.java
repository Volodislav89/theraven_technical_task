package com.zvl.theraven_technical_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    private Long created;

    @Column(name = "updated")
    private Long updated;

    @Column(name = "full_name", nullable = false, length = 50)
    @Min(value = 2)
    @Max(value = 50)
    private String fullName;

    @Column(name = "email", nullable = false, length = 100)
    @Email
    @Min(value = 2)
    @Max(value = 100)
    private String email;

    @Column(name = "phone", nullable = true, length = 14)
    @Min(value = 6)
    @Max(value = 14)
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$")
    private String phone;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;
}
