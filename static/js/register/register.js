const ID_REGEX = /^[a-z]+[a-z0-9]{4,19}$/g;
const PASSWORD_REGEX =
  /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)-_=+]).{5,16}$/;
const NAME_REGEX = /^[가-힣]{2,10}$/;
const NICKNAME_REGEX = /^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/;
const EMAIL_REGEX =
  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
const PHONE_NUM_REGEX = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;
const jsonObject = {
  id: "",
  password: "",
  passwordConfirm: "",
  name: "",
  nickname: "",
  email: "",
  phoneNum: "",
  zip: "",
  address: "",
  detailAddress: "",
};

function onSubmit(event) {
  event.preventDefault();
  const inputs = document.getElementsByClassName("register-input");
  // 입력하지 않은 input이 있는지 확인
  for (input of inputs) {
    if (input.value === "") {
      //값이 입력되지 않은 input이 있는 경우
      alert(`${input.placeholder}(을)를 입력하지 않았습니다.`);
      break;
    }
  }
  console.log(jsonObject);
  //TODO Stringify and send jsonObject to server using HTTP POST.
}

function printValid(resultElement, validMessage) {
  resultElement.innerText = "✔ " + validMessage;
  resultElement.style.color = "green";
}

function printInvalid(resultElement, invalidMessage) {
  resultElement.innerText = "❌ " + invalidMessage;
  resultElement.style.color = "red";
}

// 사용자가 입력한 값의 유효성을 검사
function validate(
  inputElement,
  regex,
  resultElement,
  validMessage,
  invalidMessage
) {
  let currentValue = "";
  currentValue += inputElement.value;
  if (currentValue.match(regex)) {
    printValid(resultElement, validMessage);
  } else {
    printInvalid(resultElement, invalidMessage);
  }
}

document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("main .container form");
  const idInput = document.querySelector(
    "main .container form input[name='id']"
  );
  const passwordInput = document.querySelector(
    "main .container form input[name='password']"
  );
  const passwordConfirmInput = document.querySelector(
    "main .container form input[name='password_confirm']"
  );
  const nameInput = document.querySelector(
    "main .container form input[name='name']"
  );
  const nicknameInput = document.querySelector(
    "main .container form input[name='nickname']"
  );
  const emailInput = document.querySelector(
    "main .container form input[name='email']"
  );
  const phoneNumInput = document.querySelector(
    "main .container form input[name='phone_num']"
  );

  const idResult = document.getElementsByClassName("idResult")[0];
  const passwordResult = document.getElementsByClassName("passwordResult")[0];
  const pwConfirmResult = document.getElementsByClassName(
    "passwordConfirmResult"
  )[0];
  const nameResult = document.getElementsByClassName("nameResult")[0];
  const nicknameResult = document.getElementsByClassName("nicknameResult")[0];
  const emailResult = document.getElementsByClassName("emailResult")[0];
  const phoneNumResult = document.getElementsByClassName("phoneNumResult")[0];

  //Add eventListener to the input elements for checking formats
  idInput.addEventListener("keyup", () => {
    validate(
      idInput,
      ID_REGEX,
      idResult,
      "사용가능한 아이디입니다.",
      "사용불가능한 아이디 입니다."
    );
  });

  idInput.addEventListener("focusout", (event) => {
    jsonObject.id = event.target.value;
  });

  passwordInput.addEventListener("keyup", () => {
    validate(
      passwordInput,
      PASSWORD_REGEX,
      passwordResult,
      "사용가능한 비밀번호 입니다.",
      "사용불가능한 비밀번호 입니다."
    );
  });

  passwordInput.addEventListener("focusout", (event) => {
    jsonObject.password = event.target.value;
  });

  passwordConfirmInput.addEventListener("keyup", () => {
    let currentValue = "";
    const password = passwordInput.value;
    currentValue += passwordConfirmInput.value;
    if (currentValue === password) {
      printValid(pwConfirmResult, "비밀번호가 일치합니다.");
    } else {
      printInvalid(pwConfirmResult, "비밀번호가 일치하지 않습니다..");
    }
  });

  passwordConfirmInput.addEventListener("focusout", (event) => {
    jsonObject.passwordConfirm = event.target.value;
  });

  nameInput.addEventListener("keyup", () => {
    validate(
      nameInput,
      NAME_REGEX,
      nameResult,
      "유효한 이름입니다.",
      "유효하지 않은 이름입니다."
    );
  });

  nameInput.addEventListener("focusout", (event) => {
    jsonObject.name = event.target.value;
  });

  nicknameInput.addEventListener("keyup", () => {
    validate(
      nicknameInput,
      NICKNAME_REGEX,
      nicknameResult,
      "유효한 별명입니다.",
      "유효하지 않은 별명입니다."
    );
  });

  nicknameInput.addEventListener("focusout", (event) => {
    jsonObject.nickname = event.target.value;
  });

  emailInput.addEventListener("keyup", () => {
    validate(
      emailInput,
      EMAIL_REGEX,
      emailResult,
      "유효한 이메일입니다.",
      "유효하지 않은 이메일입니다."
    );
  });

  emailInput.addEventListener("focusout", (event) => {
    jsonObject.email = event.target.value;
  });

  phoneNumInput.addEventListener("keyup", () => {
    validate(
      phoneNumInput,
      PHONE_NUM_REGEX,
      phoneNumResult,
      "유효한 전화번호입니다.",
      "유효하지 않은 전화번호입니다"
    );
  });

  emailInput.addEventListener("focusout", (event) => {
    jsonObject.email = event.target.value;
  });

  //TODO 1. Use Zip-finding API, to get zip, address, detail address information
  //     2. Put those information into proper input html tags
  //     3. Save them into jsonObject after execution of the API.
  form.addEventListener("submit", (event) => {
    onSubmit(event);
  });
});
