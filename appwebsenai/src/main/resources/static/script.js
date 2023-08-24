const formPessoa = document.getElementById("cadastroPessoa")

formPessoa.addEventListener("submit", function (event){
   event.preventDefault();
   // let nome = document.getElementById("nome").value;
   // document.getElementById("sexo").value = nome;

    let formDados = new FormData(formPessoa);
    let parametros = new URLSearchParams(formDados);


   fetch("/person?"+parametros.toString(), {
      method: "POST"
   }).then(response => response.json())
       .then(data => {
          document.getElementById("id").value = data.id;
       })


});