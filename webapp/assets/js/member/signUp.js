// 오늘 이후 날짜 지정 불가
var now_utc = Date.now();
var timeOff = new Date().getTimezoneOffset() * 60000;
var today = new Date(now_utc - timeOff).toISOString().split("T")[0];
document.querySelector(".signup-box #birthday").setAttribute("max", today);

// 이메일 체크
function emailCheck() {
  const $email = $(".signup-box #email").val();

  $.ajax({
    url: "/trip-log/members/email-check",
    data: {
      email: $email,
    },
    success: function (result) {
      if (result == "available") {
        Swal.fire({
          title: "사용 가능한 이메일입니다!",
          icon: "success",
        });
        $(".signup-box #signupButton").removeAttr("disabled");
      } else if (result == "invalid") {
        Swal.fire({
          title: "유효하지 않은 이메일입니다.",
          icon: "error",
        });
        $(".signup-box #emailCheckButton").attr("readonly", true);
      } else {
        Swal.fire({
          title: "이미 사용 중인 이메일입니다.",
          icon: "error",
        });
        $(".signup-box #emailCheckButton").attr("readonly", true);
      }
    },
    error: function (error) {
      console.log(error);
    },
  });
}

// 비밀번호 체크
function pwdCheck() {
  const pwd = document.querySelector(".signup-box #password").value;
  const pwdCheck = document.querySelector(".signup-box #passwordCheck").value;

  if (pwd != pwdCheck) {
    Swal.fire({
      title: "비밀번호가 일치하지 않습니다.",
      text: "확인 후 다시 입력해 주세요.",
      icon: "warning",
    });
    return false;
  } else {
    return true;
  }
}
