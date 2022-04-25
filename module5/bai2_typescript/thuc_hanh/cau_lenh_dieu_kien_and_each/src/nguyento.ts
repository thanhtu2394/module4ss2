let sum: number = 0;
let count: number = 0;
for (let i:number = 2; count < 30; i++) {
    let isPrime: boolean = true;
    if (i == 2) {
        sum += i;
        count++;
        console.log(`so nguyen to = ${i}`)
        continue;
    }else {
        for (let j:number = 2; j <i; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
    }

    if(isPrime){
        console.log(`so nguyen to = ${i}`)
        sum += i;
        count++;
    }

}
console.log(`Total 30 number firts:${sum}` );