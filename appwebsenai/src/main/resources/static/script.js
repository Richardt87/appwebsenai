const formPessoa = document.getElementById("cadastroPessoa");
const tabelaPessoa = document.getElementById("tabelaPessoas").getElementsByClassName('tbody')[0];
const  btnAll = document.getElementById("ListarPessoas");

btnAll.addEventListener("click", function (){
    fetch("/all")
        .then(response => response.json())
        .then(data => {

            tabelaPessoa.innerHTML = "";
            data.forEach(pessoa => {
                let row = tabelaPessoa.insertRow();
                row.insertCell(0).textContent = pessoa.id;
                row.insertCell(1).textContent = pessoa.name;
                row.insertCell(2).textContent = pessoa.sexo;
            })
        })

});


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