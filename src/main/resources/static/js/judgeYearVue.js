var date = new Date();
var judgeYearVue = {
    data: {
        year: date.getFullYear() - 1,
        yearFlag:false
    },
    watch: {
        year: function (newYear) {
            this.msg = '检查year输入是否正确...值：' + newYear;
            this.debouncedJudgeYear();
        },
    },
    created: function () {
        this.debouncedJudgeYear = _.debounce(this.judgeYear, 500);
    },
    methods: {
        judgeYear: function () {
            let numReg = /^\d+$/;
            if (numReg.test(this.year)) {
                if (parseInt(this.year) >= parseInt('1949') && parseInt(this.year) <= parseInt(date.getFullYear())) {
                    this.msg = '年份输入正确！！！';
                    this.yearFlag = true;
                    this.alerts = 'alert alert-success';
                    return true;
                } else {
                    this.msg = '输入不在年限范围内(1949-当前年)';
                    this.yearFlag = false;
                    this.alerts = 'alert alert-warning';
                }
            } else {
                this.msg = '包含非数字字符';
                this.yearFlag = false;
                this.alerts = 'alert alert-warning';
            }
            return false;
        },
    }
};
