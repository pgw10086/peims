package com.edu.peims.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Tax {
    @Id
    @Column("PK_Tax_Id_n")
    private int taxId;// 税率表id
    @NotNull(message = "工资开始段为空")
    @Column("Tax_MoneyStart_f")
    private float moneyStart;// 工资范围：开始
    @NotNull(message = "工资结束段为空")
    @Column("Tax_MoneyEnd_f")
    private float moneyEnd;// 工资范围：结束
    @NotNull(message = "工资税率为空")
    @Min(value = 0,message = "传入的税率有误，应该在0到1之间")
    @Max(value = 1,message = "传入的税率有误，应该在0到1之间")
    @Column("Tax_Tax_f")
    private float taxRate;// 税率



}
