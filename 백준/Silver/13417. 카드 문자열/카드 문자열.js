let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const t = Number(input[0]);

for(let i = 1; i <= t * 2; i += 2) {
    let alphabets = input[i + 1].split(" ");
    let deque = [];
    
    for(let j = 0; j < alphabets.length; j++) {
        if(j === 0) {
            deque.push(alphabets[0]);
        }else {
    	    if(alphabets[j] <= deque[0]) {
    	        deque.unshift(alphabets[j]);
    	    }else {
    		    deque.push(alphabets[j]);
    	    }
        }
    }
    
    console.log(deque.join(""));
}