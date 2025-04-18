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
$(document).ready(function () {
    let sortValue = RequestFun("sort");
    console.log("sortValue : " + sortValue);
    sortFun(sortValue);
    pagingFun(sortValue);
});

// JavaScript에서 파라미터 값 가져오는 함수
const RequestFun = function (valueName) {
    var requestNameValue;
    var nowAddress = decodeURI(location.href);
    var parameters = new Array();
    parameters = (nowAddress.slice(nowAddress.indexOf("?")+1,nowAddress.length)).split("&");
    for(var i = 0 ; i < parameters.length ; i++){
        if(parameters[i].split("=")[0] == valueName){
            requestNameValue = parameters[i].split("=")[1];
            if(requestNameValue == undefined || requestNameValue == null){
                requestNameValue = "";
            }
            return requestNameValue;
        }
    }
}

// 검색 함수
const sortFun = function(sortValue) {

    let $sortConditionList = $("#productSearchForm select[name=sort] option");

    // console.log("$sortConditionList " + $sortConditionList.val()); // jQuery로 값을 가져온 건 jQuery 메서드로 값을 추출해야함

    for(let sc of $sortConditionList) {
        console.log("sc : " + sc.value);
        if(sortValue === sc.value) {
            sc.setAttribute("selected", true);
            // console.log(sc.getAttribute("selected"));
            break;
        }
    }
}

// 페이징 바 함수
const pagingFun = function(sortValue) {
    const $pagingArr = $("#pagingArea a");

    // 페이징
    for(let pa of $pagingArr) {
        // console.log(p);
        let keyword = document.querySelector("input[name=keyword]").value;
        
        let requestUrl = "products?currentPage=" + pa.getAttribute("data-current") + "&sort=" + sortValue;
        
        if(keyword !== "") {
            requestUrl += "&keyword=" + keyword;
        }

        // console.log(requestUrl);

        pa.href = requestUrl;
    }
}