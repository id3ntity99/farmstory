document.addEventListener("DOMContentLoaded", function() {
    const sendCodeBtn = document.getElementById("sendCodeBtn");
    const verifyCodeBtn = document.getElementById("verifyCodeBtn");
    const authCodeInput = document.getElementById("authCode");

    // "인증번호 받기" 버튼 클릭 이벤트
    sendCodeBtn.addEventListener("click", function(event) {
        event.preventDefault();

        const name = document.querySelector('input[name="name"]').value.trim();
        const email = document.getElementById("email").value.trim();

        if (!name || !email) {
            alert("이름과 이메일을 모두 입력해주세요.");
            return;
        }

        // 서버의 인증번호 발송 엔드포인트에 AJAX 요청 (예: /farmstory/find/sendAuthCode.do)
        fetch("/farmstory/find/emailAuth.do", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "name=" + encodeURIComponent(name) + "&email=" + encodeURIComponent(email)
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert("인증번호가 이메일로 발송되었습니다.");
                // 예제용: 서버에서 발송된 인증번호를 클라이언트 변수에 저장(실제에서는 보안상 클라이언트에 전달하지 않습니다)
                window.authCode = data.authCode;
            } else {
                alert("입력한 이름과 이메일이 일치하지 않습니다.");
            }
        })
        .catch(error => {
            console.error("인증번호 발송 중 오류:", error);
            alert("인증번호 발송 중 오류가 발생했습니다.");
        });
    });

    // "확인" 버튼 클릭 이벤트
    verifyCodeBtn.addEventListener("click", function(event) {
        event.preventDefault();

        const inputCode = authCodeInput.value.trim();
        if (!inputCode) {
            alert("인증번호를 입력해주세요.");
            return;
        }

        // 예제용 클라이언트 비교 (실제 서비스에서는 서버측에서 검증)
        if (window.authCode && inputCode === window.authCode) {
            alert("인증번호가 확인되었습니다.");
            window.isVerified = true; // 추후 폼 제출 시 검증 여부 활용 가능
        } else {
            alert("인증번호가 일치하지 않습니다. 다시 확인해주세요.");
            window.isVerified = false;
        }
    });
});