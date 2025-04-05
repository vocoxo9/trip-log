// onload = function() {
//     const productCardList = this.document.querySelectorAll(".product-list-card");
//     // console.log(productCardList);

//     productCardList.forEach((node) => {
//         node.addEventListener("click", (e) => {
//             // console.log("click");
//             console.log(e);
//             // 해당 상품 아이디 값을 받아서 전달
//             // products/{상품아이디값}
//             // const currentPathName = this.location.pathname;
//             // this.location.href = currentPathName.concat("/1");
//         })
//     });
// }
// 페이지 로드 시 실행
$(function () {
    // 첫 번째 onload 내용
    const $productCardList = $(".product-list-card");
    // console.log($productCardList);

    $productCardList.on("click", function (e) {
        // console.log("click");
        console.log(e);
        // 해당 상품 아이디 값을 받아서 전달
        // products/{상품아이디값}
        // const currentPathName = location.pathname;
        // location.href = currentPathName.concat("/1");
    });
});