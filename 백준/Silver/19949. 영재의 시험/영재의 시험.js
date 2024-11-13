let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();

const answer = input.split(" ").map(Number);
let moreThan5ScoreCase = 0;

function pickAnswer(pick, score) {
    if(pick.length === 10) {
        if(score >= 5) {
            moreThan5ScoreCase++;
        }
    }else if(pick.length < 10) {
        if(10 - pick.length + score < 5) {
            return;
        }
        
        for(let i = 1; i <= 5; i++) {
            if(pick.length < 2) {
                pickAnswer(pick.concat(i), (i === answer[pick.length] ? score + 1 : score));
            }else {
                if(pick[pick.length - 1] === pick[pick.length - 2]) {
                    if(i !== pick[pick.length - 1]) {
                        pickAnswer(pick.concat(i), (i === answer[pick.length] ? score + 1 : score));
                    }
                }else {
                    pickAnswer(pick.concat(i), (i === answer[pick.length] ? score + 1 : score));
                }
            }
        }
    }
}

pickAnswer([], 0);

console.log(moreThan5ScoreCase);