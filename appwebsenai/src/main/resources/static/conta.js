document.addEventListener("DOMContentLoaded", function (){
    let comboPessoa = document.getElementById("pessoa")
    function preencherPessoa(){
        fetch("/all")
            .then(response => response.getJSON())
            .then(data => {
                /*let option = document.createElement("option");
                option.value = null;
                option.textContent = pessoa.name;
                comboPessoa.appendChild(option);*/
                data.forEach(pessoa => {
                    let option =document.createElement("option");
                    option.value = pessoa.id;
                    option.textContent = pessoa.name;
                    comboPessoa.appendChild(option);

                })
            })

    }
    preencherPessoa();
});