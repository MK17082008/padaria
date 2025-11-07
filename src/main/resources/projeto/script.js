document.getElementById("formCadastro").addEventListener("submit", function(event) {
    event.preventDefault();

    // Pega os dados do formulário
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const nascimento = document.getElementById("nascimento").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;

    // Verifica se os campos estão preenchidos
    if (!nome || !cpf || !nascimento || !email || !telefone) {
        alert("Por favor, preencha todos os campos!");
        return;
    }

    const dados = { nome, cpf, nascimento, email, telefone };

    // Salva no localStorage
    localStorage.setItem("cadastroCliente", JSON.stringify(dados));

    // Mensagem de sucesso
    document.getElementById("mensagem").innerText = "Cadastro realizado com sucesso!";

    // Limpa o formulário
    document.getElementById("formCadastro").reset();

    // Redireciona para a página da padaria após 2 segundos
    setTimeout(() => {
        window.location.href = "padaria.html";
    }, 2000);
});
document.getElementById("loginForm").addEventListener("submit", function(e) {
    e.preventDefault(); // evita recarregar a página

    // Simulação de login/cadastro (poderia usar backend depois)
    const nome = document.getElementById("nome").value;
    localStorage.setItem("usuario", nome);

    // Redireciona para a padaria, NÃO para o menu
    window.location.href = "padaria.html";
});