function aggregate(args) {

    function sumArgs(args) {
        let sumArgs = 0;
        for (let index = 0; index < args.length; index++) {
            sumArgs += Number(args[index]); 
        }
        return sumArgs;
    }

    function inverseArgs(args) {
        let invArgs = 0;
        for (let index = 0; index < args.length; index++) {
            invArgs += (1 / Number(args[index])); 
        }
        return invArgs;
    }

    function concatArgs(args) {
        let result = ''
        for (let index = 0; index < args.length; index++) {
            result += args[index];
        }
        return result;
    }


    console.log(sumArgs(args));
    console.log(inverseArgs(args).toFixed(4));
    console.log(concatArgs(args));
}

aggregate([1, 2, 3]);
aggregate([2, 4, 8, 16]);