const  news= document.getElementById('news');
const  foods= document.getElementById('foods');
const  sports= document.getElementById('sports');
const  weather= document.getElementById('weather');
const  navTimes= document.getElementById("navTimes");
function hide(){
    news.style.display= "none";
    foods.style.display= "none";
    sports.style.display= "none";
    weather.style.display= "none";
}

navTimes.addEventListener("click", e => {
    const ele = e.target;
    hide();
    if(ele.textContent === "News"){
        news.style.display= "block";
    }
    else if(ele.textContent === "Foods") {
        foods.style.display= "block";
    }
    else if(ele.textContent === "Sports") {
        sports.style.display= "block";
    }
    else if(ele.textContent === "Weather") {
        weather.style.display= "block";
    }
});