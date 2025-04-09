		// 탈퇴 모달 비밀번호 체크
		function delPwdCheck(){
			const pwd = document.querySelector(".mypage-delete #password").value;
			const pwdCheck = document.querySelector(".mypage-delete #passwordCheck").value;
			
				
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
		
		// 정보수정 모달 비밀번호 체크
		function updatePwdCheck(){
			const pwd = document.querySelector(".mypage-update #password").value;
			const pwdCheck = document.querySelector(".mypage-update #passwordCheck").value;
			
				
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