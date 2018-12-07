package com.communityratesgames.logging.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long id;
    private Timestamp recieved;
    @Lob
    @Column(name="message", columnDefinition = "text")
    private String message;

    @NotNull
    @Column(name="recieved")
    public Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getRecieved() {
        return this.recieved;
    }

    public void setRecieved(Timestamp recieved) {
        this.recieved = recieved;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
