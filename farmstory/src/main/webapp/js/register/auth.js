document.addEventListener("DOMContentLoaded", () => {
  const emailInput = document.querySelector(
    "main .container form input[name='email']"
  );
  const emailBtn = document.getElementsByClassName("emailAuthBtn")[0];
  const emailCodeInput = document.getElementById("emailCodeInput");

  async function requestCode(address) {
    fetch(`/farmstory/auth?address=${address}`)
      .then((response) => {
        console.log(response);
        if (response.status === 200) {
          emailCodeInput.style.display = "initial";
          emailInput.readonly = true;
        }
      })
      .catch((err) => {
        console.log(err);
      });
  }

  emailBtn.addEventListener("click", () => {
    const emailAddr = emailInput.value;
    requestCode(emailAddr);
    emailBtn.style.filter = "grayscale(100%)";
    emailBtn.style.cursor = "default";
  });
});
