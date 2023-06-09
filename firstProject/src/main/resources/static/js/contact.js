const navBtn = document.querySelectorAll(".list p");
const mainBox = document.querySelectorAll(".title-box");
const navBox = document.querySelector(".navinner ");
const footer = document.querySelector(".footer");
for (let i = 0; i < navBtn.length; i++) {
    navBtn[i].addEventListener("click", () => {
        window.scrollTo({
            top: mainBox[i].getBoundingClientRect().top,
            behavior: "smooth",
        });
    });
}

// 지금바로등록하기
const safetyBox = document.querySelector(".safety");
const safetyYesBtn = document.querySelector(".safety-yes-Btn");
const safetyNoBtn = document.querySelector(".safety-no-Btn");
const nowBtn = document.querySelector(".now-btn");
const safetyForm = document.getElementById("safety-form");
const modalBack = document.querySelector(".modal-back");
console.log(safetyBox);
console.log(safetyYesBtn);
console.log(safetyNoBtn);
console.log(nowBtn);
nowBtn.addEventListener("click", () => {
    safetyBox.style.display = "block";
    modalBack.style.display = "block";
});
console.log(safetyForm);
safetyNoBtn.addEventListener("click", safetyBoxClear);
function safetyBoxClear() {
    console.log("clearBtnOK");
    // safetyForm.reset();
    safetyBox.style.display = "none";
    modalBack.style.display = "none";
}
safetyYesBtn.addEventListener("click", () => {
    alert("登録完了しました");
    safetyBox.style.display = "none";
    modalBack.style.display = "none";
    // safetyYesBtn.addEventListener("click", hideDivForDay);
    hideDivForDay();
});

const logoutButton = document.querySelector('.logout-button');
logoutButton.addEventListener('click', () => {
    const confirmed = confirm('ログアウトをしますか？');
    if (confirmed) {
        alert('ログアウトしました！')
        // ログアウトの要請をサーバーに送るコード
        // controllerからこのURLで処理を行う
        window.location.href = '/logout';
    }
});

