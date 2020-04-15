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