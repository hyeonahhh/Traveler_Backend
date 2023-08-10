package com.example.traveler.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class RecommendTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rtId;

    private String destination;

    private double latitude;

    private double longitude;

    /***

     code1 - countryId, what, hard, with, period 순으로 조합
     code2 - countryId, what, hard 순으로 조합

     what - 1. 경치관람, 2. 먹방, 3. 액티비티, 4. 체험, 5. 카페
     hard - 1. 빡빡하게, 2. 보통, 3. 느긋하게
     with - 1. 친구와, 2. 가족과, 3. 연인과, 4. 혼자서
     period - 1박 2일이면 2 저장

     ***/

    private int code1;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "sId")
    private List<Spot> spots = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "recommendTravel")
    private List<DayCourse> dayCourses = new ArrayList<>();

}