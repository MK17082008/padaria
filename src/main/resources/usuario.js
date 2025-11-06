document.getElementById("formUsuario").addEventListener("submit", async function (e) {
    e.preventDefault(); // Impede o recarregamento da página

    const usuario = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        dataNascimento: document.getElementById("dataNascimento").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value
    };

    try {
        const response = await fetch("http://localhost:8080/usuario", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(usuario)
        });

        if (response.status === 201) {
            alert("Usuario cadastrado com sucesso!");
            document.getElementById("formUsuario").reset();
        }else{
        alert("Erro ao cadastrar usuario");
        }
    } catch (error) {
        alert("Erro de conexão com o servidor.");
        console.error(error);
    }
});
async function buscarUsuario(){
    const cpf = document.getElementById("buscarCpf").value;


    try{
        const response = await  fetch('http://localhost:8080/usuario?cpf=${cpf}');


        if (response.ok) {
            const usuario = await response.json();
            document.getElementById("resultado").textContent = JSON.stringify(usuario, null, 2);
        }else{
            document.getElementById("resultado").textContent = "Usuario não encontrado.";
        }
    }catch (error){
        document.getElementById("resultado").textContent = "Erro ao buscar usuario.";
        console.error(error);
    }



}