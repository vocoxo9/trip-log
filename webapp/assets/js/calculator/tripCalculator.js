// 모든 탭과 비용 입력 리스트 가져오기
const tabs = document.querySelectorAll(".tab");
const costLists = document.querySelectorAll(".cost-list");

tabs.forEach(tab => {
    tab.addEventListener("click", () => {
        // 모든 탭에서 active 클래스 제거
        tabs.forEach(t => t.classList.remove("active"));
        tab.classList.add("active");

        // 모든 비용 리스트 숨기기
        costLists.forEach(list => list.classList.remove("active"));

        // 클릭한 탭에 해당하는 리스트 보이기
        const targetId = tab.getAttribute("data-target");
        document.getElementById(targetId).classList.add("active");
        console.log(targetId);
    });
});

// 추가 버튼을 누르면 비용 입력 리스트 추가하기
document.querySelectorAll(".add-btn").forEach(button => {
    // 횟수제한을 두기 위한 변수
    let count = 0;
    button.addEventListener("click", (event) => {
        if (count < 6) {

            // 현재 클릭된 버튼이 속한 cost-list 찾기
            const parentCostList = event.target.closest(".cost-list");

            // 줄바꿈 추가
            // const newline = document.createElement("br");
            // parentCostList.appendChild(newline);

            // 새로운 비용 입력 항목 생성
            const newCostItem = document.createElement("div");
            newCostItem.classList.add("cost-item");
            const costItems = document.querySelector(".cost-items");

            // 새 input 요소들 추가
            const newContentInput = document.createElement("input");
            newContentInput.type = "text";
            newContentInput.classList.add("content");
            newContentInput.placeholder = "메모를 입력하세요.";

            const newPriceInput = document.createElement("input");
            newPriceInput.type = "number";
            newPriceInput.classList.add("price");
            newPriceInput.placeholder = "금액";

            // 삭제 버튼 추가
            const deleteBtn = document.createElement("i");
            deleteBtn.classList.add("fa-solid");
            deleteBtn.classList.add("fa-trash");
            deleteBtn.classList.add("delete-icon");
            deleteBtn.addEventListener("click", () => {
                newCostItem.remove();
                // 삭제버튼을 눌렀을 경우 count 줄이기
                count--;
                console.log(count);
                calculateTotal(); // 총액 다시 계산
            });


            // 새 img 태그 추가

            // 요소들을 cost-item에 추가
            newCostItem.appendChild(newContentInput);
            newCostItem.appendChild(newPriceInput);
            newCostItem.appendChild(deleteBtn);
            // deleteBtn.src="image/delete-btn.png";

            // cost-list에 추가
            parentCostList.appendChild(newCostItem);
            // 추가버튼을 눌렀을 경우 count 늘리기
            count++;
            console.log(count);
        };
    });
});




// 인원수 조절 기능
const downBtn = document.getElementById("downBtn");
const upBtn = document.getElementById("upBtn");
const count = document.getElementById("count");

let peopleCount = 0;    // 기본값 0

downBtn.addEventListener("click", () => {
    if (peopleCount > 1) {
        peopleCount--;
        count.textContent = peopleCount;
    }
});

upBtn.addEventListener("click", () => {
    peopleCount++;
    count.textContent = peopleCount;
});

// 계산기 기능

function calculateTotal() {
    let total = 0;
    document.querySelectorAll('.price').forEach(input => {
        const value = parseInt(input.value) || 0;
        total += value;
    });

    document.querySelector('#totalPrice span').innerText = total.toLocaleString();

    const peopleCount = parseInt(document.querySelector('#count').innerText) || 1;
    const duchPrice = Math.round(total / peopleCount);
    document.querySelector('#duchPrice span').innerText = duchPrice.toLocaleString();


}


// 값이 입력되었을 때에 총합에 반영
document.addEventListener('input', (e) => {
    if (e.target.classList.contains('price')) {
        calculateTotal();
    }
});

document.addEventListener("click", (e) => {
    if (e.target.classList.contains('fa-solid')) {
        calculateTotal();
    }
});


// 각 카테고리 별 총 금액 계산
function getCategoryTotals() {
    const totals = [];
    const costLists = document.querySelectorAll(".cost-list");

    costLists.forEach(list => {
        let categoryTotal = 0;
        const prices = list.querySelectorAll(".price");

        prices.forEach(priceInput => {
            const value = parseInt(priceInput.value) || 0;
            categoryTotal += value;
        });

        totals.push(categoryTotal);
    });

    console.log("totals : " + totals);
    return totals;
}
// 각 금액을 비율로 바꾸기
// const totals = getCategoryTotals();
// const overallTotal = totals.reduce((a, b) => a + b, 0);
// const percentages = totals.map(t => Math.round((t / overallTotal) * 100));

const submitBtn = document.querySelector(".submit");
submitBtn.addEventListener("click", () => {
    const totals = getCategoryTotals();
    const overallTotal = totals.reduce((a, b) => a + b, 0);


    // 0~3번까지는 round해서 미리 저장
    let percentages = totals.map(t => Math.round((t / overallTotal) * 100));
    let sum = percentages.slice(0, 4).reduce((a, b) => a + b, 0);
    percentages[4] = 100 - sum;  // 마지막 요소는 보정해서 100% 맞추기
    console.log("ㅠㅓ센테이지 : " + percentages);
    console.log("ㅠㅓ센테이지 : " + percentages[0], typeof (percentages[0]));

    // console.log("totals : " + totals);
    // console.log("overallTotal : " + overallTotal);
    document.querySelector('.donut text').textContent = overallTotal.toLocaleString() + "원";

    const secondCircle = document.getElementById("food");
    secondCircle.setAttribute('stroke-dasharray', `${percentages[1]} ${100 - percentages[1]}`);

    const fiveCircle = document.getElementById("etc");
    fiveCircle.setAttribute('stroke-dasharray', `${percentages[4]} ${100 - percentages[4]}`);
    fiveCircle.setAttribute('stroke-dashoffset', `${-percentages[1]}`);

    const fourCircle = document.getElementById("ticket");
    fourCircle.setAttribute('stroke-dasharray', `${percentages[3]} ${100 - percentages[3]}`);
    fourCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1])}`);

    const thirdCircle = document.getElementById("bus");
    thirdCircle.setAttribute('stroke-dasharray', `${percentages[2]} ${100 - percentages[2]}`);
    thirdCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1] + percentages[3])}`);
    console.log(-(percentages[0] + percentages[1]));

    console.log(typeof (-(percentages[0] + percentages[1])));
    const firstCircle = document.getElementById("lodging");
    firstCircle.setAttribute('stroke-dasharray', `${percentages[0]} ${100 - percentages[0]}`);
    firstCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1] + percentages[2] + percentages[3])}`);
    console.log(typeof (percentages[0]));

    // 색깔 설명 라벨의 비율을 표시
    const categoryIds = [
        "lodging-label",
        "food-label",
        "bus-label",
        "ticket-label",
        "etc-label"
    ];

    percentages.forEach((percent, idx) => {
        const span = document.querySelector("#" + categoryIds[idx] + " span");
        // EL로 인식되는거 같아서 다시 구현 ㄱㄱ
        span.textContent = percent + "%";
    });

    // 그래프 설명에 카테고리별 금액을 표시
    // totals => [숙박비, 식비, 교통비, 입장료, 기타]

    document.querySelector('.fa-tents span').textContent = totals[0].toLocaleString();
    document.querySelector('.fa-utensils span').textContent = totals[1].toLocaleString();
    document.querySelector('.fa-van-shuttle span').textContent = totals[2].toLocaleString();
    document.querySelector('.fa-ticket span').textContent = totals[3].toLocaleString();
    document.querySelector('.fa-suitcase-rolling span').textContent = totals[4].toLocaleString();

});