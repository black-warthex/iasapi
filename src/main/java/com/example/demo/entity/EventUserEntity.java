package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_x_user")
@Data
@NoArgsConstructor
public class EventUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evetxuser_id")
    private int eventUserId;

    @Column(name = "evetxuser_event_id")
    private int eventId;

    @Column(name = "evetxuser_user_id")
    private String userId;

}
