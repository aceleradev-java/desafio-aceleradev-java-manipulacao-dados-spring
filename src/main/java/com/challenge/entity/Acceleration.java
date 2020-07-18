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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

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

    @ManyToOne
    @Getter
    @Setter
    private Challenge challenge;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

    @CreatedDate
    @Getter
    @Setter
    private LocalDateTime createdAt;

}
