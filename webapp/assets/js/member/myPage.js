		// 탈퇴 모달 비밀번호 체크
		function delPwdCheck(){
			const pwd = $(".mypage-delete #password").val();
			const pwdCheck = $(".mypage-delete #passwordCheck").val();
			const memberId = $(".mypage-delete #memberId").val();
				
			if(pwd != pwdCheck){
				Swal.fire({
	                title: "비밀번호가 일치하지 않습니다.",
	                text: "확인 후 다시 입력해 주세요.",
	                icon: "warning"
	            });
				return false;
			} else{
				$.ajax({
					url : '/trip-log/members/delete',
					data : {
						password : pwd,
						memberId : memberId
					},
					type : 'post',
					success : function(result){
						if(result == "deleted"){
							Swal.fire({
								title: "회원탈퇴 성공",
								text: "이용해주셔서 감사합니다.",
								icon: "success"
							}).then(() => location.href = '/trip-log')
						} else {
							Swal.fire({
								title: "회원탈퇴 실패",
								text: "다시 시도해주세요.",
								icon: "warning"
							});
						}
					},
					error : function(){
						Swal.fire('오류', '서버와의 통신 중 문제가 발생하였습니다.', 'error');	
					}
				});
			}
		}
		
		// 정보수정 모달 비밀번호 체크
		function updatePwdCheck(){
			const pwd = $(".mypage-update #password").val();
			const pwdCheck = $(".mypage-update #passwordCheck").val();
			
			const memberId = $(".mypage-delete #memberId").val();
			const phone = $(".mypage-update #phone").val(); 
			const nickname = $(".mypage-update #nickname").val();
			const countryId = $(".mypage-update #countryId").val();
				
			if(pwd != pwdCheck){
				Swal.fire({
	                title: "비밀번호가 일치하지 않습니다.",
	                text: "확인 후 다시 입력해 주세요.",
	                icon: "warning"
	            });
				return false;
			} else{
				$.ajax({
					url : '/trip-log/members/update',
					data : {
						password : pwd,
						memberId : memberId,
						phone : phone,
						nickname : nickname,
						countryId : countryId
					},
					type : 'post',
					success : function(result){
						if(result == "updated"){
							Swal.fire({
				                title: "회원정보 수정 성공",
				                text : "정보가 수정되었습니다.",
				                icon: "success"
				            }).then(() => location.reload());
						} else {
							Swal.fire({
				                title: "회원정보 수정 실패",
				                icon: "warning"
				            });
						}
					},
					error : function(){
						Swal.fire('오류', '서버와의 통신 중 문제가 발생하였습니다.', 'error');
					}
				});
				//return true;
			}
		}