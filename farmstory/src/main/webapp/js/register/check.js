const ID_REGEX = /^[a-z]+[a-z0-9]{4,19}$/g;

async function send(event) {
  const name = event.target.getAttribute;
  await fetch(`/check?type=${event.target.name}&value=${event.target.name}`)
    .then((response) => {
      console.log(response);
    })
    .then((data) => {
      console.log(data);
    })
    .catch((err) => {});
}

function checkId() {}

window.addEventListener("DOMContentLoaded", () => {
  const idBtn = document.getElementsByClassName("idCheckBtn")[0];
  const idResult = document.getElementsByClassName("idResult")[0];

  idBtn.addEventListener("click", (event) => {
    send(event);
  });
});
