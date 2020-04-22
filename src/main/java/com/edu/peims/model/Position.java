package com.edu.peims.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Min;

// 岗位表
@Getter
@Setter
public class Position {

    @Id
    @Column("PK_Position_Id_nb")
    private int postId;// 岗位ID
    @Column("Position_Name_s")
    private String name;// 岗位名称
    @Column("Position_Description_s")
    private String description;// 岗位描述
    @Column("Position_Salary_f")
    @Min(value = 0,message = "工资不可小于0")
    private float salary;// 岗位工资
}
