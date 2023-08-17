var books = document.querySelector("#books")
var borrowers = document.querySelectorAll(".borrowers");
console.log(borrowers)
books.addEventListener("change", (event) => {
	console.log(event.target.value);
	borrowers.forEach((option)=> {
		if(option.value === event.target.value) {
			option.removeAttribute("disabled")
		} else {
			option.setAttribute("disabled","");
		};
	})
});