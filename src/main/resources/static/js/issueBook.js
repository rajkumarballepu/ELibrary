let books = document.querySelector("#books");
		console.log(books.value);
		let form = document.querySelector("#std-form");
		books.addEventListener("change", (event)=> {
			console.log(event.target.value);
			if(books.value != 0) {
				form.classList.remove("d-none");
			} else {
				form.classList.add("d-none");
			}
		})