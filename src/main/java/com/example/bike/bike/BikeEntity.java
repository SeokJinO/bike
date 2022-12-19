package com.example.bike.bike;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "bike")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class BikeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    private String location;

    @Column(name = "state")
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date update_at;

}
