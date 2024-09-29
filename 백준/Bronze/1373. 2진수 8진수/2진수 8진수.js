let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

let result = [];
let type = input.length % 3;

if(input === "0") {
    console.log("0");
}else {
    if(type === 0) {
        for(let i = 0; i < input.length; i += 3) {
            let subStr = input.substring(i, i + 3);
            
            if(subStr === "000") {
                result.push("0");
            }else if(subStr === "001") {
                result.push("1");
            }else if(subStr === "010") {
               result.push("2");
            }else if(subStr === "011") {
                result.push("3");
            }else if(subStr === "100") {
                result.push("4");
            }else if(subStr === "101") {
                result.push("5");
            }else if(subStr === "110") {
                result.push("6");
            }else {
                result.push("7");
            }
        }
    }else if(type === 1) {
        result.push("1");
        
        for(let i = 1; i < input.length; i += 3) {
            let subStr = input.substring(i, i + 3);
            
            if(subStr === "000") {
                result.push("0");
            }else if(subStr === "001") {
                result.push("1");
            }else if(subStr === "010") {
                result.push("2");
            }else if(subStr === "011") {
                result.push("3");
            }else if(subStr === "100") {
                result.push("4");
            }else if(subStr === "101") {
                result.push("5");
            }else if(subStr === "110") {
                result.push("6");
            }else {
                result.push("7");
            }
        }
    }else if(type === 2) {
        let token = input.substring(0, 2);
        
        if(token === "10") {
            result.push("2");
        }else {
            result.push("3");
        }
        
        for(let i = 2; i < input.length; i += 3) {
            let subStr = input.substring(i, i + 3);
            
            if(subStr === "000") {
                result.push("0");
            }else if(subStr === "001") {
                result.push("1");
            }else if(subStr === "010") {
                result.push("2");
            }else if(subStr === "011") {
                result.push("3");
            }else if(subStr === "100") {
                result.push("4");
            }else if(subStr === "101") {
                result.push("5");
            }else if(subStr === "110") {
                result.push("6");
            }else {
                result.push("7");
            }
        }
    }
    
    console.log(result.join(""));
}