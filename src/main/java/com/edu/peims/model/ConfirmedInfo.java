package com.edu.peims.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 18716
 */
@Getter
@Setter
public class ConfirmedInfo {
    int id;
    String name;
    int seniority;
    int postId;
    float postWage;
    int absence;
    float tax;
    String date;
}
