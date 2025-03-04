function requestCode(email) {}

document.addEventListener("DOMContentLoaded", () => {
  const emailInput = document.querySelector(
    "main .container form input[name='email']"
  );
  const emailBtn = document.getElementsByClassName("emailAuthBtn")[0];

  emailBtn.addEventListener("click", () => {
    const emailAddr = emailInput.value;
    fetch(`/farmstory/auth?address=${emailAddr}`)
      .then((response) => {
        console.log(response);
        if (response.status === 200) {
          emailInput.style.display = "initial";
          emailBtn.style.filter = "grayscale(100%);";
          emailBtn.style.cursor = "none";
        }
      })
      .catch((err) => {
        console.log(err);
      });
  });
});
