package com.edu.peims.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// 员工工资表
@Getter
@Setter
public class Wage {

   @NotNull
   @Id
   @Column("PK_FK_Wage_Id_nb")
   private int id;// 员工ID
   @NotNull
   @Column("Wage_Seniority_f")
   private float wageSeniority;// 工龄工资
   @NotNull
   @Column("Wage_Position_f")
   private float wagePosition;// 岗位工资
   @NotNull
   @Column("Wage_Merits_f")
   private float wageMerits;// 绩效工资
   @NotNull
   @Column("Wage_Absenteeism_f")
   private float wageAbsenteeism;// 缺勤扣除
   @NotNull
   @Min(value = 0,message = "传入的税率有误，应该在0到1之间")
   @Max(value = 1,message = "传入的税率有误，应该在0到1之间")
   @Column("Wage_Tax_f")
   private float wageTax;// 所得税
   @NotNull
   @Column("Wage_Money_f")
   private float wageMoney;// 总工资
   @NotNull
   @Column("PK_Wage_Date_s")
   private String wageDate;// 工资时间，工资按月来计算例如（2019-08）
}
