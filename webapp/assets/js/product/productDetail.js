// onload = function() {
//     reviewRegister();
// }

// // 결제 API
// const payment = () => {
//     const paymentBtn = document.getElementById("paymentBtn");

//     paymentBtn.addEventListener("click", () => {

//     })
// }

// // 리뷰 등록
// const reviewRegister = () => {
//     const rateWrap = document.querySelectorAll('.rating'),
//         label = document.querySelectorAll('.rating .rating__label'),
//         input = document.querySelectorAll('.rating .rating__input'),
//         labelLength = label.length,
//         opacityHover = '0.5';

//     let stars = document.querySelectorAll('.rating .star-icon');

//     checkedRate();

//     rateWrap.forEach(wrap => {
//         wrap.addEventListener('mouseenter', () => {
//             stars = wrap.querySelectorAll('.star-icon');

//             stars.forEach((starIcon, idx) => {
//                 starIcon.addEventListener('mouseenter', () => {
//                     initStars(); 
//                     filledRate(idx, labelLength); 

//                     for (let i = 0; i < stars.length; i++) {
//                         if (stars[i].classList.contains('filled')) {
//                             stars[i].style.opacity = opacityHover;
//                         }
//                     }
//                 });

//                 starIcon.addEventListener('mouseleave', () => {
//                     starIcon.style.opacity = '1';
//                     checkedRate(); 
//                 });

//                 wrap.addEventListener('mouseleave', () => {
//                     starIcon.style.opacity = '1';
//                 });
//             });
//         });
//     });

//     function filledRate(index, length) {
//         if (index <= length) {
//             for (let i = 0; i <= index; i++) {
//                 stars[i].classList.add('filled');
//             }
//         }
//     }

//     function checkedRate() {
//         let checkedRadio = document.querySelectorAll('.rating input[type="radio"]:checked');


//         initStars();
//         checkedRadio.forEach(radio => {
//             let previousSiblings = prevAll(radio);

//             for (let i = 0; i < previousSiblings.length; i++) {
//                 previousSiblings[i].querySelector('.star-icon').classList.add('filled');
//             }

//             radio.nextElementSibling.classList.add('filled');

//             function prevAll() {
//                 let radioSiblings = [],
//                     prevSibling = radio.parentElement.previousElementSibling;

//                 while (prevSibling) {
//                     radioSiblings.push(prevSibling);
//                     prevSibling = prevSibling.previousElementSibling;
//                 }
//                 return radioSiblings;
//             }
//         });
//     }

//     function initStars() {
//         for (let i = 0; i < stars.length; i++) {
//             stars[i].classList.remove('filled');
//         }
//     }

//     const reviewRegisterBtn = document.getElementById("reviewRegisterBtn");

//     reviewRegisterBtn.onclick = () => {
//         let starInputArr = document.querySelectorAll(".star-icon.filled");
//         console.log(starInputArr.length / 2);
//     }
// }
$(function() {
    reviewRegister();
    payment();
});
// 결제 API
const payment = () => {
    const $paymentBtn = $("#paymentBtn");

    console.log("상품 정보 : " + productInfo.productId);
    console.log("상품 정보 : " + productInfo.name);
    console.log("상품 정보 : " + productInfo.memberId);
    console.log("상품 정보 : " + productInfo.price);
    console.log("상품 정보 : " + productInfo.productId);  

    $paymentBtn.on("click", $.ajax({
        // 결제 API
    }));
};

// 리뷰 등록
const reviewRegister = () => {
    const $rateWrap = $('.rating'),
        $label = $('.rating .rating__label'),
        $input = $('.rating .rating__input'),
        labelLength = $label.length,
        opacityHover = '0.5';

    let $stars = $('.rating .star-icon');

    checkedRate();

    $rateWrap.each(function () {
        const $wrap = $(this);

        $wrap.on("mouseenter", function () {
            $stars = $wrap.find('.star-icon');

            $stars.each(function (idx) {
                const $starIcon = $(this);

                $starIcon.on("mouseenter", function () {
                    initStars();
                    filledRate(idx, labelLength);

                    $stars.each(function () {
                        const $star = $(this);
                        if ($star.hasClass('filled')) {
                            $star.css('opacity', opacityHover);
                        }
                    });
                });

                $starIcon.on("mouseleave", function () {
                    $starIcon.css('opacity', '1');
                    checkedRate();
                });

                $wrap.on("mouseleave", function () {
                    $starIcon.css('opacity', '1');
                });
            });
        });
    });

    function filledRate(index, length) {
        if (index <= length) {
            for (let i = 0; i <= index; i++) {
                $stars.eq(i).addClass('filled');
            }
        }
    }

    function checkedRate() {
        const $checkedRadio = $('.rating input[type="radio"]:checked');

        initStars();

        $checkedRadio.each(function () {
            const $radio = $(this);
            const $previousSiblings = prevAll($radio);

            $previousSiblings.each(function () {
                $(this).find('.star-icon').addClass('filled');
            });

            $radio.next().addClass('filled');

            function prevAll($el) {
                const $siblings = [];
                let $prev = $el.parent().prev();

                while ($prev.length) {
                    $siblings.push($prev[0]);
                    $prev = $prev.prev();
                }

                return $($siblings);
            }
        });
    }

    function initStars() {
        $stars.removeClass('filled');
    }

    const $reviewRegisterBtn = $("#reviewRegisterBtn");

    $reviewRegisterBtn.on("click", function () {
        const $starInputArr = $(".star-icon.filled");
        console.log($starInputArr.length / 2);
    });
};