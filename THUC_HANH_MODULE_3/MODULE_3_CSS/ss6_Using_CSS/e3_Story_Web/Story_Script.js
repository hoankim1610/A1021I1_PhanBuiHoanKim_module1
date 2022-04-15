const intro = document.getElementById("intro");
const chap1 = document.getElementById("chap1");
const chap2 = document.getElementById("chap2");
const chap3 = document.getElementById("chap3");
const refer = document.getElementById("refer");

function hide() {
    intro.style.display = "none";
    chap1.style.display = "none";
    chap2.style.display = "none";
    chap3.style.display = "none";
}

refer.addEventListener("click", e => {
    const ele = e.target;
    hide();
    if(ele.textContent== "Introduction"){
        intro.style.display = "block";
    }
    else if(ele.textContent== "Chapter 1") {
        chap1.style.display = "block";
    }
    else if(ele.textContent== "Chapter 2") {
        chap2.style.display = "block";
    }
    else if(ele.textContent== "Chapter 3") {
        chap3.style.display = "block";
    }
});

