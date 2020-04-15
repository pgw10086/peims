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

var judgeMonthVue = {
    data: {
        month: '12',
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
                    this.yearFlag = true;
                    this.alerts = 'alert alert-success';
                    return true;
                } else {
                    this.msg = '输入不在范围内(01-12)';
                    this.yearFlag = false;
                    this.alerts = 'alert alert-warning';
                }
            } else {
                this.msg = '请输入01~12间的数';
                this.yearFlag = false;
                this.alerts = 'alert alert-warning';
            }
            return false;
        },
    }
};

var judgeIdVue = {
    data: {
        id:'',
        idFlag:false
    },
    watch: {
        id: function (newId) {
            this.msg = '检查id输入是否正确...值：' + newId;
            this.debouncedJudgeId();
        }
    },
    created: function () {
        this.debouncedJudgeId = _.debounce(this.judgeId, 500);
    },
    methods: {
        judgeId: function () {
            let numReg = /^\d{7}$/;
            if (numReg.test(this.id)) {
                this.msg = 'id输入正确！！！';
                this.alerts = 'alert alert-success';
                this.idFlag = true;
                return true;
            } else {
                this.msg = '输入包含非数字或位数不为7';
                this.alerts = 'alert alert-warning';
                this.idFlag = this.id.length === 0;
            }
            return false;
        },
    }
};

var judgepositionIdVue = {
    data: {
        positionId:'',
        positionIdFlag:false
    },
    watch: {
        positionId: function (newId) {
            this.msg = '检查id输入是否正确...值：' + newId;
            this.debouncedJudgeId();
        }
    },
    created: function () {
        this.debouncedJudgeId = _.debounce(this.judgepositionId, 500);
    },
    methods: {
        judgepositionId: function () {
            if (this.positionId === ''){
                this.msg = 'id为空';
                this.alerts = 'alert alert-success';
                this.positionIdFlag = true;
                return false;
            }
            let numReg = /^\d{1}$/;
            if (numReg.test(this.positionId)) {
                this.msg = 'id输入正确！！！';
                this.alerts = 'alert alert-success';
                this.positionIdFlag = true;
                return true;
            } else {
                this.msg = '输入包含非数字或位数不为1';
                this.alerts = 'alert alert-warning';
                this.positionIdFlag = (this.positionId.length === 0);
            }
            return false;
        },
    }
};

var judgeNumber = {
    methods: {
        judgeInt: function (number) {
            let numReg = /^\d{,32}$/;
            return numReg.test(number);
        },
        judgeFloat: function (number) {
            let numReg = /^0.\d{,2}$/;
            return numReg.test(number);
        },
    }
};

var optionVue = {
    methods:{
        delRows: function () {
            if (this.checkedRows.length <= 0) {//是否选中判断
                alert("您未选择需要删除的数据");
                return false;
            }
            if (!confirm("您确定要删除选择的数据吗？")) {//删除确认
                return false;
            }

            for (var i = 0; i < this.checkedRows.length; i++) {//循环获取选中的行标
                var checkedRowIndex = this.checkedRows[i];
                /**根据下标移除数组元素*/
                this.facilities = $.grep(this.facilities, function (facility, j) {
                    return j != checkedRowIndex;
                });
            }
            this.checkedRows = [];//清空选中行数据
        },
        updateRow: function(){
            if (this.checkedRows.length <= 0) {//是否选中判断
                alert("您未选择需要删除的数据");
                return false;
            }
        },
        addRow: function () {
            this.facilities.push(this.newRow);
            this.newRow = {};
        },
        saveRows: function () {//保存表格数据

        },
    }
};
