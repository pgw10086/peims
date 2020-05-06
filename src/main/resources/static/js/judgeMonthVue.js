var judgeMonthVue = {
    data: {
        month: '',
        monthFlag:false
    },
    watch: {
        month: function (newMonth) {
            this.msg = '检查month输入是否正确...值：' + newMonth;
            this.debouncedJudgeMonth();
        },
    },
    created: function () {
        this.debouncedJudgeMonth = _.debounce(this.judgeMonth, 500);
    },
    methods: {
        judgeMonth: function () {
            let numReg = /^\d\d$/;
            if (numReg.test(this.month)) {
                if (parseInt(this.month) >= parseInt('01') &&
                    parseInt(this.month) <= parseInt('12')) {
                    this.msg = '月份输入正确！！！';
                    this.monthFlag = true;
                    this.alerts = 'alert alert-success';
                    return true;
                } else {
                    this.msg = '输入不在范围内(01-12)';
                    this.monthFlag = false;
                    this.alerts = 'alert alert-warning';
                }
            } else {
                this.msg = '请输入01~12间的数';
                this.monthFlag = false;
                this.alerts = 'alert alert-warning';
            }
            return false;
        },
    }
};

