var judgePositionIdVue = {
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