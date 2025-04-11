	
	// 이메일 체크
	function emailCheck(){
		const $email = $(".signup-box #email").val();
		
		$.ajax({
			url : '/trip-log/members/email-check',
			data : {
				email : $email
				},
			success : function(result){
				
				if(result == "available"){
					console.log(result);
					Swal.fire({
						  title: "사용 가능한 이메일입니다!",
						  icon: "success"
						});		
					$(".signup-box #signupButton").removeAttr("disabled");
					
				} else {
					console.log(result);
					Swal.fire({
						  title: "이미 사용 중인 이메일입니다.",
						  icon: "error"
						});
					$(".signup-box #emailCheckButton").attr("readonly",true);
				}
			},
			error : function(error){
				console.log(error);
			}
		});
	}
	
	
	// 비밀번호 체크
	function pwdCheck(){
		const pwd = document.querySelector(".signup-box #password").value;
		const pwdCheck = document.querySelector(".signup-box #passwordCheck").value;
		
			
		if(pwd != pwdCheck){
			Swal.fire({
                title: "비밀번호가 일치하지 않습니다.",
                text: "확인 후 다시 입력해 주세요.",
                icon: "warning"
            });
			return false;
		} else{
			return true;
		}
	}