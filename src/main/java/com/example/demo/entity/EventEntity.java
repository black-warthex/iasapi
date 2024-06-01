package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ias_event")
@Data
@Builder(toBuilder = true)
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "event_location")
    private String eventLocation;
}
