package com.edu.peims.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class User {

   @Id
   @Column("PK_User_Id_nb")
   private int userId;// 员工ID
   @Column("User_Name_s")
   private String name;// 员工名
   @Column("User_Password_nb")
   private int password;// 员工密码
   @Column("User_Seniority_n")
   private int seniority;// 员工工龄
   @Column("FK_User_PostionId_nb")
   private int postionId;// 岗位（说明1为普通员工，2为经理）
   @Column("FK_User_DepartmentId_nb")
   private int departmentId;// 部门ID
   @Column("User_Sex_s")
   private String sex;// 员工性别
   @Column("User_PhotoURL_s")
   private String photoUrl;// 员工照片URL


}
