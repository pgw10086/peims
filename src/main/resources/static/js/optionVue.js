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
