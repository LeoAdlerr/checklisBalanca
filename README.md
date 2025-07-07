<h1 style="color: #34495e; margin-top: 1.5em; margin-bottom: 0.5em; text-align: center; font-size: 2.5em; border-bottom: 3px solid #3498db; padding-bottom: 10px;">📚 Guia de Estudos: Orientação a Objetos Essencial com Java</h1>
<p style="font-style: italic; color: #555; margin-bottom: 1em; text-align: center;">Este material é um guia de referência para os conceitos fundamentais da Programação Orientada a Objetos (OO), aplicando-os com a linguagem Java. Use-o para revisar e aprofundar seu conhecimento.</p>

<hr />

<h2 style="color: #2c3e50; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.8em; border-bottom: 2px solid #ddd; padding-bottom: 5px;">📜 A Origem da Orientação a Objetos</h2>
<p>
  Nos anos 60, as linguagens de programação misturavam dados e lógica de forma desorganizada. Para resolver isso, Ole-Johan Dahl e Kristen Nygaard, na Noruega, criaram a primeira linguagem com conceitos de <strong style="color: #c0392b;">Objetos</strong> e <strong style="color: #c0392b;">Classes</strong>, chamada Simula. A ideia era simples e poderosa: juntar <strong style="color: #c0392b;">dados (o que um objeto é)</strong> e <strong style="color: #c0392b;">comportamentos (o que um objeto faz)</strong> em uma única entidade.
</p>
<p>
  Anos depois, Alan Kay popularizou o termo "Orientação a Objetos", e linguagens como C++, Java, C# e Python adotaram esse DNA. Entender OO é dominar a forma moderna de organizar e escalar sistemas de software.
</p>

<hr />

<h2 style="color: #2c3e50; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.8em; border-bottom: 2px solid #ddd; padding-bottom: 5px;">📅 Semana 1: Os Pilares Fundamentais</h2>

<h3 style="color: #27ae60; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.4em;">✅ Módulo 1 — Classes e Objetos: A Base de Tudo</h3>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🎯 Conceitos-Chave</h4>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><strong style="color: #c0392b;">Abstração</strong>: Focar no que é essencial, definindo identidade, características (atributos) e ações (métodos).</li>
  <li><strong style="color: #c0392b;">Classe</strong>: A planta ou molde de um objeto.</li>
  <li><strong style="color: #c0392b;">Objeto</strong>: A instância concreta de uma classe, criada a partir do molde.</li>
</ul>

<div style="background-color: #9b59b61a; border-left: 4px solid #9b59b6; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">💡 Por que isso é importante?</strong> Classes e objetos resolvem o problema do <strong style="color: #c0392b;">código espalhado</strong>. Em vez de ter variáveis e funções soltas para manipular um usuário, agrupamos tudo o que pertence a um `Usuario` dentro da classe `Usuario`. Isso torna o código mais organizado, intuitivo e fácil de encontrar.</p>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">Abstraindo o Mundo Real</h4>
<p>
  O primeiro pilar da OO é a <strong style="color: #c0392b;">Abstração</strong>. Trata-se do processo de filtrar características de um elemento do mundo real para representá-lo no software, focando apenas no que é essencial para o sistema.
</p>
<div style="background-color: #ecf0f1; border-left: 4px solid #3498db; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Analogia: A Planta da Casa</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li>Uma <strong style="color: #c0392b;">Classe</strong> é como a <strong style="color: #c0392b;">planta de uma casa</strong>. Ela define a estrutura (número de quartos, banheiros) e os comportamentos possíveis (acender luzes, abrir portas). A planta é um modelo, não a casa em si.</li>
      <li>Um <strong style="color: #c0392b;">Objeto</strong> é a <strong style="color: #c0392b;">casa construída</strong> a partir da planta. Você pode construir várias casas (objetos) usando a mesma planta (classe). Cada casa é uma instância independente: pintar uma de azul não muda a cor das outras.</li>
  </ul>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🖥️ Exemplo Prático: A Classe `Usuario`</h4>
<p style="font-style: italic; color: #555; margin-bottom: 1em;">Nosso objetivo: criar um sistema para registrar usuários. Começamos abstraindo o que é um usuário em nosso contexto.</p>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><strong style="color: #c0392b;">Atributos (características):</strong> `nome`, `email`.</li>
  <li><strong style="color: #c0392b;">Métodos (ações):</strong> `exibirInfo()`.</li>
</ul>

<pre style="background-color: #eee; padding: 15px; border-radius: 5px; overflow-x: auto; margin-bottom: 1em; font-family: 'Courier New', Courier, monospace; font-size: 0.95em;"><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">// Versão 1: A classe é o "molde" para um Usuário.
public class Usuario {
// Atributos: os dados que definem um usuário.
String nome;
String email;

// Método: a ação que um objeto Usuário pode executar.
void exibirInfo() {
  System.out.println("Nome: " + nome + ", Email: " + email);
}
}

// Classe principal para executar nosso programa
public class Principal {
public static void main(String[] args) {
  // Criando o Objeto 1: uma instância real da classe Usuario.
  Usuario user1 = new Usuario();
  user1.nome = "Leonardo"; // Atribuindo dados ao objeto
  user1.email = "leo@email.com";
  user1.exibirInfo(); // Invocando o comportamento do objeto

  System.out.println("---");

  // Criando o Objeto 2: outra instância, independente da primeira.
  Usuario user2 = new Usuario();
  user2.nome = "Ana";
  user2.email = "ana@email.com";
  user2.exibirInfo();
}
}
</code></pre>

<div style="background-color: #f39c121a; border-left: 4px solid #f39c12; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Desafio:</strong> Evolua a classe <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">Usuario</code>. Adicione um novo atributo <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">senha</code> e um método <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">login()</code> que imprima na tela "Usuário [nome do usuário] logado com sucesso!".</p>
</div>

<hr />

<h3 style="color: #27ae60; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.4em;">✅ Módulo 2 — Construtores e Encapsulamento</h3>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🎯 Conceitos-Chave</h4>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><strong style="color: #c0392b;">Construtor</strong>: Um método especial para garantir que um objeto seja criado em um estado válido e completo.</li>
  <li><strong style="color: #c0392b;">Encapsulamento</strong>: Proteger os dados internos de um objeto, expondo apenas operações seguras através de métodos públicos (Getters/Setters).</li>
</ul>

<div style="background-color: #9b59b61a; border-left: 4px solid #9b59b6; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">💡 Por que isso é importante?</strong> Encapsulamento resolve o problema de <strong style="color: #c0392b;">estados inválidos e insegurança</strong>. Ele impede que qualquer parte do código altere um dado importante (como o saldo de uma conta) sem passar por uma validação. Você centraliza as regras de negócio e garante a integridade dos seus objetos.</p>
</div>

<div style="background-color: #ecf0f1; border-left: 4px solid #3498db; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Analogia: O Carro e o Motorista</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li><strong style="color: #c0392b;">Interface Pública:</strong> O volante, os pedais e o câmbio. São os controles que o motorista usa para interagir com o carro. Em OO, estes são os <strong style="color: #c0392b;">métodos públicos</strong> (como `acelerar()` ou `getVelocidade()`).</li>
      <li><strong style="color: #c0392b;">Detalhes Privados:</strong> O motor, a injeção eletrônica, a fiação. O motorista não manipula isso diretamente. Em OO, estes são os <strong style="color: #c0392b;">atributos privados</strong>. O encapsulamento esconde essa complexidade e protege o funcionamento interno do carro.</li>
  </ul>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🖥️ Exemplo Prático: Protegendo a Classe `Usuario`</h4>
<p style="font-style: italic; color: #555; margin-bottom: 1em;">Agora, vamos garantir que um usuário só possa ser criado com dados essenciais e que sua senha não possa ser alterada para um valor inválido.</p>

<pre style="background-color: #eee; padding: 15px; border-radius: 5px; overflow-x: auto; margin-bottom: 1em; font-family: 'Courier New', Courier, monospace; font-size: 0.95em;"><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">// Versão 2: Adicionando construtor e encapsulamento.
public class Usuario {
// Atributos agora são PRIVADOS. Só a própria classe pode acessá-los diretamente.
private String nome;
private String email;
private String senha;

// Construtor: é chamado no momento da criação do objeto (new Usuario(...)).
// Força a criação de um usuário com todos os dados necessários.
public Usuario(String nome, String email, String senha) {
  this.nome = nome;
  this.email = email;
  this.senha = senha;
}

// --- MÉTODOS PÚBLICOS (A INTERFACE DE CONTROLE) ---

// Getter para nome: permite que o mundo externo LEIA o nome, mas não altere.
public String getNome() {
  return this.nome;
}

// Getter para email
public String getEmail() {
  return this.email;
}

// Setter para senha: permite que o mundo externo ALTERE a senha, mas com VALIDAÇÃO.
public void setSenha(String novaSenha) {
  if (novaSenha != null && novaSenha.length() >= 6) {
      this.senha = novaSenha;
      System.out.println("Senha alterada com sucesso!");
  } else {
      System.out.println("Erro: A senha deve ter no mínimo 6 caracteres.");
  }
}

// Método de login agora valida a senha fornecida.
public boolean login(String emailInput, String senhaInput) {
  return this.email.equals(emailInput) && this.senha.equals(senhaInput);
}
}

public class Principal {
public static void main(String[] args) {
  Usuario user = new Usuario("Leonardo", "leo@email.com", "123456");

  // Tentar acessar diretamente gera ERRO DE COMPILAÇÃO. Isso é o encapsulamento!
  // user.nome = "Outro Nome"; // Proibido!

  // A forma correta de interagir é pelos métodos públicos.
  System.out.println("Nome do usuário: " + user.getNome());
  
  user.setSenha("abc"); // Inválido -> Exibe erro.
  user.setSenha("novaSenhaSegura"); // Válido -> Altera.

  // Testando o login
  if (user.login("leo@email.com", "novaSenhaSegura")) {
      System.out.println("Login bem-sucedido!");
  } else {
      System.out.println("Email ou senha inválidos.");
  }
}
}
</code></pre>

<hr />

<h3 style="color: #27ae60; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.4em;">✅ Módulo 3 — Herança e Polimorfismo</h3>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🎯 Conceitos-Chave</h4>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><strong style="color: #c0392b;">Herança</strong> (`extends`): Permite que uma classe (filha) herde atributos e métodos de outra classe (pai), promovendo o reuso de código.</li>
  <li><strong style="color: #c0392b;">Polimorfismo</strong> (`@Override`): "Muitas formas". Permite que objetos de classes diferentes respondam à mesma mensagem (chamada de método) de maneiras específicas.</li>
</ul>

<div style="background-color: #9b59b61a; border-left: 4px solid #9b59b6; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">💡 Por que isso é importante?</strong> Herança resolve o problema do <strong style="color: #c0392b;">código repetido</strong>. Se `Administrador` e `Cliente` têm nome e email, não precisamos reescrever esse código; eles simplesmente herdam de `Usuario`. Polimorfismo resolve o problema do <strong style="color: #c0392b;">código rígido</strong>. Ele nos permite tratar um `Administrador` e um `Cliente` como se fossem ambos um `Usuario` genérico, mas executando seus comportamentos específicos, o que torna o sistema flexível a novos tipos de usuário.</p>
</div>

<div style="background-color: #ecf0f1; border-left: 4px solid #3498db; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Analogia: Veículos e Sons de Animais</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li><strong style="color: #c0392b;">Herança:</strong> Um `Carro` <strong style="color: #c0392b;">É UM</strong> `Veiculo`. Uma `Moto` <strong style="color: #c0392b;">É UM</strong> `Veiculo`. Ambos herdam características comuns de `Veiculo` (ter rodas, motor, velocidade), mas adicionam suas próprias especificidades.</li>
      <li><strong style="color: #c0392b;">Polimorfismo:</strong> Imagine uma classe `Animal` com um método `fazerSom()`. Um `Cachorro` (que herda de `Animal`) implementa `fazerSom()` para latir. Um `Gato` implementa para miar. Se você tiver uma lista de `Animal`, pode chamar `fazerSom()` em cada um, e cada bicho fará seu som específico. O mesmo método, diferentes comportamentos.</li>
  </ul>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🖥️ Exemplo Prático: Especializando Usuários</h4>
<p style="font-style: italic; color: #555; margin-bottom: 1em;">Nosso sistema agora precisa de diferentes tipos de usuários: `Administrador` e `Cliente`. Eles compartilham dados básicos, mas têm ações e formas de login diferentes.</p>

<pre style="background-color: #eee; padding: 15px; border-radius: 5px; overflow-x: auto; margin-bottom: 1em; font-family: 'Courier New', Courier, monospace; font-size: 0.95em;"><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">// --- CLASSE PAI (SUPERCLASSE) ---
public class Usuario {
// Protected: visível para a própria classe e para suas classes filhas.
protected String nome;
protected String email;

public Usuario(String nome, String email) {
  this.nome = nome;
  this.email = email;
}

// Comportamento padrão de login. Será sobrescrito.
public void login() {
  System.out.println(this.nome + " logou com acesso padrão.");
}

public String getNome() { return this.nome; }
}

// --- CLASSE FILHA 1 (SUBCLASSE) ---
// Administrador herda de Usuario usando "extends".
public class Administrador extends Usuario {

public Administrador(String nome, String email) {
  // "super" chama o construtor da classe pai (Usuario).
  super(nome, email);
}

// Polimorfismo: Sobrescrevendo o método login.
// @Override é uma anotação que garante que estamos sobrescrevendo um método existente.
@Override
public void login() {
  System.out.println("Admin " + this.nome + " logou com privilégios elevados!");
}

// Método específico de Administrador.
public void acessarPainelAdmin() {
  System.out.println(this.nome + " acessou o painel de administração.");
}
}

// --- CLASSE FILHA 2 (SUBCLASSE) ---
public class Cliente extends Usuario {

public Cliente(String nome, String email) {
  super(nome, email);
}

@Override
public void login() {
  System.out.println("Cliente " + this.nome + " logou na loja online.");
}

// Método específico de Cliente.
public void realizarCompra(String produto) {
  System.out.println(this.nome + " comprou um " + produto + ".");
}
}

// --- EXECUÇÃO ---
public class Principal {
public static void main(String[] args) {
  // Podemos tratar objetos específicos (Admin, Cliente) como seu tipo genérico (Usuario).
  Usuario admin = new Administrador("Leo Admin", "leo.admin@empresa.com");
  Usuario cliente = new Cliente("Ana Cliente", "ana.cliente@email.com");

  // Polimorfismo em ação! O mesmo método login() tem resultados diferentes.
  admin.login();   // Chama o login() de Administrador
  cliente.login(); // Chama o login() de Cliente
}
}
</code></pre>

<div style="background-color: #f39c121a; border-left: 4px solid #f39c12; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Desafio:</strong> Crie uma classe base <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">Transacao</code> com um método <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">processar()</code>. Crie duas subclasses, <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">TransacaoCredito</code> e <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">TransacaoDebito</code>, que herdem de <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">Transacao</code> e sobrescrevam o método <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">processar()</code> para simular a lógica específica de cada tipo de pagamento.</p>
</div>

<hr />

<h2 style="color: #2c3e50; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.8em; border-bottom: 2px solid #ddd; padding-bottom: 5px;">📅 Semana 2: Design e Arquitetura</h2>

<h3 style="color: #27ae60; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.4em;">✅ Módulo 4 — Classes Abstratas e Interfaces</h3>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🎯 Conceitos-Chave</h4>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><strong style="color: #c0392b;">Classe Abstrata</strong> (`abstract class`): Uma classe "incompleta" que serve como modelo para outras, podendo ter métodos com e sem implementação. Não pode ser instanciada diretamente.</li>
  <li><strong style="color: #c0392b;">Interface</strong> (`interface`): Um "contrato" que define um conjunto de métodos que uma classe <strong style="color: #c0392b;">deve</strong> implementar. Define "o quê", mas nunca "o como".</li>
</ul>

<div style="background-color: #9b59b61a; border-left: 4px solid #9b59b6; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">💡 Por que isso é importante?</strong> Interfaces são a base do <strong style="color: #c0392b;">desacoplamento</strong>, um dos princípios mais importantes em software. Elas permitem que diferentes partes do sistema conversem através de "contratos", sem precisarem conhecer os detalhes umas das outras. Isso permite trocar uma peça (como o banco de dados) por outra sem quebrar o resto do sistema. É como poder trocar a marca do pneu do carro sem precisar trocar o carro inteiro.</p>
</div>

<div style="background-color: #ecf0f1; border-left: 4px solid #3498db; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Analogia: O Contrato e o Manual de Instruções</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li><strong style="color: #c0392b;">Interface (`interface`):</strong> É um <strong style="color: #c0392b;">contrato</strong>. Pense numa interface USB. Ela define um padrão de conexão (o formato do plugue, a voltagem). Qualquer dispositivo que "assina" esse contrato (um pendrive, um mouse) garante que vai funcionar na porta USB. A interface não é o dispositivo, apenas a especificação. Em Java, uma classe pode implementar (<code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">implements</code>) várias interfaces (ela pode ser `Carregavel` E `Armazenavel`).</li>
      <li><strong style="color: #c0392b;">Classe Abstrata (`abstract class`):</strong> É um <strong style="color: #c0392b;">manual de instruções com partes pré-montadas</strong>. Define um `Veiculo` abstrato que já vem com o método `buzinar()` pronto, mas deixa o método `acelerar()` para ser implementado por cada tipo de veículo (carro, moto). Você não pode construir só o "manual", precisa construir um veículo concreto a partir dele. Em Java, uma classe só pode herdar (<code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">extends</code>) de uma única classe abstrata.</li>
  </ul>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🖥️ Exemplo Prático: Um Contrato para Salvar Usuários</h4>
<p style="font-style: italic; color: #555; margin-bottom: 1em;">Queremos salvar usuários. Mas hoje pode ser em memória, amanhã em um banco de dados MySQL, e depois em outro sistema. Como fazer isso sem reescrever o código toda vez? Criamos uma <strong style="color: #c0392b;">interface</strong> (contrato) para o "repositório de dados".</p>

<pre style="background-color: #eee; padding: 15px; border-radius: 5px; overflow-x: auto; margin-bottom: 1em; font-family: 'Courier New', Courier, monospace; font-size: 0.95em;"><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">// --- O CONTRATO ---
// A interface define O QUE um repositório de usuário DEVE FAZER.
public interface UsuarioRepository {
void salvar(Usuario usuario);
Usuario buscarPorEmail(String email);
}

// (Reutilizando a classe Usuario e subclasses da aula anterior)

// --- IMPLEMENTAÇÃO 1: EM MEMÓRIA ---
// Útil para testes rápidos, não precisa de banco de dados.
public class UsuarioRepositoryMemoria implements UsuarioRepository {
private Map&lt;String, Usuario&gt; bancoDeDadosFalso = new HashMap&lt;&gt;();

@Override
public void salvar(Usuario usuario) {
  bancoDeDadosFalso.put(usuario.getEmail(), usuario);
  System.out.println("MEM: Usuário " + usuario.getNome() + " salvo em memória.");
}

@Override
public Usuario buscarPorEmail(String email) {
  return bancoDeDadosFalso.get(email);
}
}

// --- IMPLEMENTAÇÃO 2: BANCO DE DADOS (SIMULADO) ---
// Representa a lógica que se conectaria a um banco de dados real.
public class UsuarioRepositoryDB implements UsuarioRepository {
@Override
public void salvar(Usuario usuario) {
  // Aqui entraria a lógica complexa de JDBC/JPA para salvar no banco.
  System.out.println("DB: Salvando usuário " + usuario.getNome() + " no Banco de Dados...");
}

@Override
public Usuario buscarPorEmail(String email) {
  // Aqui entraria a lógica de SELECT no banco.
  System.out.println("DB: Buscando usuário com email " + email + " no Banco de Dados...");
  // Para o exemplo, retornamos um usuário mock.
  return new Cliente("Usuário do DB", email);
}
}

// --- EXECUÇÃO ---
public class Principal {
public static void main(String[] args) {
  // O código principal pode escolher qual implementação usar, SEM MUDAR A LÓGICA.
  
  System.out.println("--- Usando Repositório em Memória ---");
  UsuarioRepository repoMemoria = new UsuarioRepositoryMemoria();
  repoMemoria.salvar(new Cliente("Alice", "alice@test.com"));
  
  System.out.println("\n--- Usando Repositório de Banco de Dados ---");
  UsuarioRepository repoDB = new UsuarioRepositoryDB();
  repoDB.salvar(new Administrador("Bob", "bob@test.com"));
  
  System.out.println("\nPercebeu? A lógica de negócio não se importa se os dados estão em memória ou DB. Ela só se importa com o CONTRATO (Interface). Isso é desacoplamento!");
}
}
</code></pre>

<hr />

<h3 style="color: #27ae60; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.4em;">✅ Módulo 5 — Projeto Final: Juntando Tudo</h3>
<p>Neste módulo, conectamos todos os conceitos para construir a espinha dorsal de um mini-backend, mostrando como a OO estrutura aplicações reais.</p>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">Arquitetura em Camadas</h4>
<p>Aplicações modernas são organizadas em camadas, cada uma com uma responsabilidade clara. A OO é a base para essa organização.</p>
<div style="background-color: #ecf0f1; border-left: 4px solid #3498db; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Analogia: O Bolo de Camadas</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li><strong style="color: #c0392b;">Camada de Apresentação (Cobertura):</strong> É a parte com que o usuário interage (Controllers em uma API REST). Ela recebe as requisições e devolve as respostas.</li>
      <li><strong style="color: #c0392b;">Camada de Serviço (Recheio):</strong> Contém a lógica de negócio principal (Services). Orquestra as operações, valida as regras e toma as decisões. É o "cérebro" da aplicação.</li>
      <li><strong style="color: #c0392b;">Camada de Acesso a Dados (Massa):</strong> Responsável por se comunicar com o banco de dados (Repositories). Sua única função é salvar e buscar dados.</li>
  </ul>
  <p>A comunicação flui de cima para baixo: a Apresentação chama o Serviço, que chama o Repositório. As dependências são gerenciadas via <strong style="color: #c0392b;">interfaces</strong>, permitindo que as camadas sejam independentes.</p>
</div>

<h4 style="color: #8e44ad; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.2em;">🖥️ Exemplo Prático: `GerenciadorDeUsuarios`</h4>
<p style="font-style: italic; color: #555; margin-bottom: 1em;">Vamos criar nossa Camada de Serviço. Ela usará a interface `UsuarioRepository` sem saber qual implementação está por trás.</p>

<pre style="background-color: #eee; padding: 15px; border-radius: 5px; overflow-x: auto; margin-bottom: 1em; font-family: 'Courier New', Courier, monospace; font-size: 0.95em;"><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">// CAMADA DE SERVIÇO: Contém a lógica de negócio.
public class GerenciadorDeUsuarios {
// Depende da INTERFACE, não da implementação concreta!
private UsuarioRepository repositorio;

// A implementação é "injetada" pelo construtor. Isso é Injeção de Dependência.
public GerenciadorDeUsuarios(UsuarioRepository repositorio) {
  this.repositorio = repositorio;
}

public void cadastrarNovoUsuario(String nome, String email) {
  if (repositorio.buscarPorEmail(email) != null) {
      System.out.println("ERRO: Email já cadastrado!");
      return;
  }
  Cliente novoUsuario = new Cliente(nome, email);
  repositorio.salvar(novoUsuario);
  System.out.println("SUCESSO: Usuário " + nome + " cadastrado.");
}
}

// --- EXECUÇÃO ---
public class Principal {
public static void main(String[] args) {
  // Cenário 1: Usando o repositório em memória para testar
  UsuarioRepository repoMemoria = new UsuarioRepositoryMemoria();
  GerenciadorDeUsuarios gerenciadorTeste = new GerenciadorDeUsuarios(repoMemoria);
  gerenciadorTeste.cadastrarNovoUsuario("Carlos", "carlos@teste.com");
  gerenciadorTeste.cadastrarNovoUsuario("Carlos", "carlos@teste.com"); // Vai dar erro

  System.out.println("\n----------------\n");

  // Cenário 2: Usando o repositório de DB em "produção"
  UsuarioRepository repoDB = new UsuarioRepositoryDB();
  GerenciadorDeUsuarios gerenciadorProducao = new GerenciadorDeUsuarios(repoDB);
  gerenciadorProducao.cadastrarNovoUsuario("Daniela", "dani@empresa.com");
}
}
</code></pre>

<div style="background-color: #f39c121a; border-left: 4px solid #f39c12; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Desafio Final:</strong> Implemente a classe <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">UsuarioRepositoryMySQL</code> de verdade, usando JDBC para se conectar a um banco de dados MySQL local. Você precisará do driver JDBC do MySQL e de uma tabela <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">usuarios</code>. O objetivo é ver o <code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">GerenciadorDeUsuarios</code> funcionar com uma persistência real sem nenhuma alteração em seu código.</p>
  <div style="background-color: #e74c3c1a; border-left: 4px solid #e74c3c; padding: 10px 15px; margin: 1em 0;">
      <p><strong style="color: #c0392b;">Aviso de Segurança:</strong> Em um sistema real, <strong style="color: #c0392b;">NUNCA</strong> armazene senhas em texto puro no banco de dados. Elas devem ser sempre "hasheadas" com algoritmos como o BCrypt. O foco do exercício é a arquitetura e a conexão.</p>
  </div>
</div>

<hr />

<h2 style="color: #2c3e50; margin-top: 1.5em; margin-bottom: 0.5em; font-size: 1.8em; border-bottom: 2px solid #ddd; padding-bottom: 5px;">🚀 Epílogo — Por que a OO é Essencial?</h2>
<p>
  Desde os simuladores de navios até os complexos sistemas em nuvem de hoje, a Orientação a Objetos nasceu para gerenciar um desafio que nunca desaparece: a <strong style="color: #c0392b;">complexidade</strong>. Ao modelar o software com objetos, classes, heranças e contratos, tornamos o código mais próximo da forma como o cérebro humano organiza o mundo.
</p>
<p>
  Em um framework como o <strong style="color: #c0392b;">Spring Boot</strong>, esses princípios são a base de tudo:
</p>
<ul style="list-style-type: disc; margin-left: 20px;">
  <li><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">@Repository</code> é a nossa camada de acesso a dados, baseada em interfaces.</li>
  <li><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">@Service</code> é a nossa camada de lógica de negócio.</li>
  <li><code style="font-family: 'Courier New', Courier, monospace; background-color: #e9e9e9; padding: 2px 4px; border-radius: 3px;">@RestController</code> é a nossa camada de apresentação.</li>
</ul>
<p>
  O framework automatiza a "injeção de dependências" que fizemos manualmente no construtor, mas o princípio arquitetural é exatamente o mesmo. Dominar a OO é a chave para criar sistemas <strong style="color: #c0392b;">manuteníveis, testáveis e escaláveis</strong>.
</p>

<div style="background-color: #2ecc711a; border-left: 4px solid #2ecc71; padding: 10px 15px; margin: 1em 0;">
  <p><strong style="color: #c0392b;">Próximos Passos na sua Jornada:</strong></p>
  <ul style="list-style-type: disc; margin-left: 20px;">
      <li><strong style="color: #c0392b;">Princípios SOLID:</strong> São 5 regras de design que aprimoram o uso da OO. O que vimos aqui é a fundação para entendê-los.</li>
      <li><strong style="color: #c0392b;">Padrões de Projeto (Design Patterns):</strong> Soluções consagradas para problemas comuns (Factory, Singleton, Strategy). O padrão Repository que vimos é um deles!</li>
      <li><strong style="color: #c0392b;">Testes Unitários:</strong> Aprender a testar cada camada de forma isolada, usando "mocks" para simular as dependências.</li>
  </ul>
</div>

<p style="text-align: center; font-size: 1.2em; margin-top: 2em;">
  🚀 <strong style="color: #c0392b;">Missão cumprida. Bons estudos e bom código!</strong>
</p>
