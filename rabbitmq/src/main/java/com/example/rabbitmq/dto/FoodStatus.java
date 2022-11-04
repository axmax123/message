package com.example.rabbitmq.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodStatus {
    private FoodDTO foodDTO;
    private String statusFood;
    private String messageFood;

}
