package com.edu.peims.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// 员工工资表
@Getter
@Setter
public class Wage {

   @Id
   @Column("id")
   private int wageId;// 员工ID
   @Column("PK_FK_Wage_Id_nb")
   private int userId;
   @Column("Wage_Seniority_f")
//   @Pattern(regexp = "/^\\d{0,}(\\.{0,1}\\d{0,})?$/",message = "非整数或浮点数")
   @Min(value = 0,message = "不可小于0")
   private float wageSeniority;// 工龄工资
   @Column("Wage_Position_f")
   @Min(value = 0,message = "不可小于0")
   private float wagePosition;// 岗位工资
   @Column("Wage_Merits_f")
   @Min(value = 0,message = "不可小于0")
   private float wageMerits;// 绩效工资
   @Column("Wage_Absenteeism_f")
   @Min(value = 0,message = "不可小于0")
   private float wageAbsenteeism;// 缺勤扣除
   @Column("Wage_Tax_f")
   @Min(value = 0,message = "不可小于0")
   @Max(value = 1,message = "不可大于1")
   private float wageTax;// 所得税
   @Column("Wage_Money_f")
   @Min(value = 0,message = "不可小于0")
   private float wageMoney;// 总工资
   @Column("PK_Wage_Date_s")
   @Pattern(regexp = "\\d{4}-\\d{2}")
   private String wageDate;// 工资时间，工资按月来计算例如（2019-08）
}
