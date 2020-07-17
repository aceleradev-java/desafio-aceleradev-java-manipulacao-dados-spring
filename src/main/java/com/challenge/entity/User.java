package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    @Getter
    @Setter
    private String fullName;

    @Column
    @Email
    @Size(max = 100)
    @NotNull
    @Getter
    @Setter
    private String email;

    @Column
    @NotNull
    @Size(max = 50)
    @Getter
    @Setter
    private String nickname;

    @Column
    @NotNull
    @Size(max = 255)
    @Getter
    @Setter
    private String password;

    @Column
    @CreationTimestamp
    @Getter
    @Setter
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user", fetch = FetchType.LAZY)
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user", fetch = FetchType.LAZY)
    private List<Submission> submissions;
}
