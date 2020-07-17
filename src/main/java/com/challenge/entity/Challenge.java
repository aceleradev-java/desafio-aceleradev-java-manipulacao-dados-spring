package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

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
    private String name;

    @Column
    @NotNull
    @Size(max = 50)
    @Getter
    @Setter
    private String slug;

    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY)
    private List<Acceleration> accelerations;

    @OneToMany(mappedBy = "id.challenge", fetch = FetchType.LAZY)
    private List<Submission> submissions;

    @CreatedDate
    @Getter
    @Setter
    private LocalDateTime createdAt;

}
