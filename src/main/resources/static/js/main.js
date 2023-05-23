const adminList = function(){
    const adminButtons = document.getElementsByClassName("admin-list");
    for(var i=0; i <= adminButtons.length - 1 ; i++){

        adminButtons.item(i).addEventListener('click',function(){
            console.log(this.getAttribute("for"));
            showCard(this.getAttribute("for"));
        })
    }
}
const showCard = function(adminButton){
    const adminCards = document.getElementsByClassName("adminCards");

    for(var index = 0; index <= adminCards.length - 1;index++){
        adminCards.item(index).style.display = "none";
        if(adminCards.item(index).getAttribute("for") == adminButton){
            adminCards.item(index).style.display = "block";
        }
    }
}
window.addEventListener('load',() => {adminList()})