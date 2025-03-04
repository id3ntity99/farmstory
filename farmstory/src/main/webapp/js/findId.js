document.addEventListener('DOMContentLoaded', function(){
        	$(document).ready(function() {
        	    // 이메일 인증번호 요청
        	    $("#sendCodeBtn").click(function(event) {
        	        event.preventDefault();
        	        var email = $("#email").val().trim();

        	        if (email === "") {
        	            alert("이메일을 입력하세요.");
        	            return;
        	        }

        	        $.ajax({
        	            type: "POST",
        	            url: "/sendEmail",
        	            data: JSON.stringify({ email: email }),
        	            contentType: "application/json; charset=UTF-8",
        	            dataType: "json",
        	            success: function(response) {
        	                alert(response.message);
        	            },
        	            error: function() {
        	                alert("서버 오류. 다시 시도하세요.");
        	            }
        	        });
        	    });

        	    // 인증번호 확인
        	    $("#verifyCodeBtn").click(function(event) {
        	        event.preventDefault();
        	        var code = $("#authCode").val().trim();

        	        if (code === "") {
        	            alert("인증번호를 입력하세요.");
        	            return;
        	        }

        	        $.ajax({
        	            type: "POST",
        	            url: "/verifyCode",
        	            data: JSON.stringify({ code: code }),
        	            contentType: "application/json; charset=UTF-8",
        	            dataType: "json",
        	            success: function(response) {
        	                alert(response.message);
        	                if (response.status === "success") {
        	                    $("#submitBtn").prop("disabled", false); // "다음" 버튼 활성화
        	                }
        	            },
        	            error: function() {
        	                alert("서버 오류. 다시 시도하세요.");
        	            }
        	        });
        	    });
        	});
        }