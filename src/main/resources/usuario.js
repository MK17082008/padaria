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
            alert("Usuario cadastrado com sucesso!" ${response.status}`);
        }

        const data = await response.json();
        console.log("Usuário cadastrado com sucesso:", data);
        alert("Usuário cadastrado com sucesso!");

        // Limpa o formulário
        document.getElementById("formUsuario").reset();

    } catch (error) {
        console.error("Erro ao enviar requisição:", error);
        alert("Erro ao cadastrar usuário. Verifique os dados e tente novamente.");
    }
});
}