$(document).ready(function () {
    pagingFun();
});

const pagingFun = function() {
    const $pagingArr = $("#pagingArea a");

    // 페이징
    for(let pa of $pagingArr) {
        
        let requestUrl = "productLikes?currentPage=" + pa.getAttribute("data-current");

        // console.log(requestUrl);

        pa.href = requestUrl;
    }
}