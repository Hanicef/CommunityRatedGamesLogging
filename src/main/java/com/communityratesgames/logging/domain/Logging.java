package com.communityratesgames.logging.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "logs")
public class Logging implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp recieved;
    @Lob
    @Column(name="message", columnDefinition = "text")
    private String message;

    public Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
