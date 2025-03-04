document.addEventListener("DOMContentLoaded", function () {
    const sendCodeBtn = document.getElementById("sendCodeBtn");
    const verifyCodeBtn = document.getElementById("verifyCodeBtn");
    const authCodeInput = document.getElementById("authCode");

    let authCode = null; // 서버에서 받은 인증번호 저장
    let isVerified = false; // 인증 성공 여부

    // 인증번호 요청 함수
    async function requestAuthCode(name, email) {
        try {
            const response = await fetch("/farmstory/find/emailauth.do", {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: `name=${encodeURIComponent(name)}&email=${encodeURIComponent(email)}`
            });

            const data = await response.json();
            console.log("서버 응답 데이터:", data);

            return data;
        } catch (error) {
            console.error("인증번호 요청 오류:", error);
            alert("인증번호 발송 중 오류가 발생했습니다.");
            return { success: false };
        }
    }

    // "인증번호 받기" 버튼 클릭 이벤트
    sendCodeBtn.addEventListener("click", async function (event) {
        event.preventDefault();

        const name = document.querySelector('input[name="name"]').value.trim();
        const email = document.getElementById("email").value.trim();

        if (!name || !email) {
            alert("이름과 이메일을 모두 입력해주세요.");
            return;
        }

        const response = await requestAuthCode(name, email);
        if (response.status) {
            alert("인증번호가 이메일로 발송되었습니다.");
            authCode = response.authCode || response.data?.authCode || null;
            console.log("저장된 인증번호:", authCode);
        } else {
            alert("입력한 이름과 이메일이 일치하지 않습니다.");
        }
    });

    // "확인" 버튼 클릭 이벤트
    verifyCodeBtn.addEventListener("click", function (event) {
        event.preventDefault();

        const inputCode = authCodeInput.value.trim();
        if (!inputCode) {
            alert("인증번호를 입력해주세요.");
            return;
        }

        console.log("입력된 인증번호:", inputCode);
        console.log("저장된 인증번호:", authCode);

        if (authCode && inputCode === authCode) {
            alert("인증번호가 확인되었습니다.");
            isVerified = true;
        } else {
            alert("인증번호가 일치하지 않습니다. 다시 확인해주세요.");
            isVerified = false;
        }
    });
});
