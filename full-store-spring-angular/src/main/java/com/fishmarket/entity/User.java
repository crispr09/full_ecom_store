package com.fishmarket.entity;

import com.fishmarket.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String role;

    private String password;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
}
