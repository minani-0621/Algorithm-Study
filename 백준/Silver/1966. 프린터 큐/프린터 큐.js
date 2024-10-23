let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const t = Number(input[0]);

for(let i = 1; i <= 2 * t; i += 2) {
    let [n, m] = input[i].split(" ");
    let important = input[i + 1].split(" ");
    
    let map = new Map();
    let queue = [];
    for(let i = 0; i < Number(n); i++) {
        queue.push(i);
        map.set(i, Number(important[i]));
    }
    
    let count = 1;
    
    while(true) {
        let isMove = false;
        for(let j = 1; j < queue.length; j++) {
            if(map.get(queue[j]) > map.get(queue[0])) {
                queue.push(queue.shift());
                isMove = true;
                break;
            }
        }
        
        if(!isMove) {
            let printDoc = queue.shift();
            
            if(printDoc === Number(m)) {
                console.log(count);
                break;
            }else {
                count++;
            }
        }
    }
}