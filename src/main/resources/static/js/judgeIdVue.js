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