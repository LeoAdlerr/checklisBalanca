<div class="container">

  <div class="author-box">
      <h1>📚 Guia de Consulta: Orientação a Objetos Essencial com Java</h1>
      <p><strong>Autor:</strong> Leonardo Adler da Silva</p>
      <p>Tecnólogo em Banco de Dados (Fatec São José dos Campos) | Analista de Sistemas I na Universal Armazéns Gerais e Alfandegados</p>
      <p><strong>Material Consolidado em:</strong> 17 de Julho de 2025</p>
  </div>

  <h2>📜 A Origem e o Propósito da OO</h2>
  <p>
      Nos anos 60, as linguagens de programação misturavam dados e lógica de forma desorganizada. Para resolver a crescente <strong>complexidade</strong>, Ole-Johan Dahl e Kristen Nygaard criaram a Simula, a primeira linguagem com conceitos de <strong>Objetos</strong> e <strong>Classes</strong>. A ideia era simples e poderosa: juntar <strong>dados (o que um objeto é)</strong> e <strong>comportamentos (o que um objeto faz)</strong> em uma única entidade coesa.
  </p>
  <p>
      Entender OO é dominar a forma moderna de organizar, escalar e dar manutenção em sistemas de software.
  </p>

  <hr>

  <h2>Módulo 1: A Base de Tudo — Classes e Objetos</h2>
  <h4>🎯 Conceitos-Chave</h4>
  <ul>
      <li><strong>Abstração</strong>: Focar no que é essencial para o sistema, definindo identidade, características (atributos) e ações (métodos) de um conceito.</li>
      <li><strong>Classe</strong>: A planta, o molde, a receita de um objeto. Define a estrutura e os comportamentos.</li>
      <li><strong>Objeto</strong>: A instância concreta de uma classe. É a "coisa" construída a partir da planta, com dados próprios.</li>
  </ul>

  <div class="info-box">
      <strong>💡 Por que isso é importante?</strong> Classes e objetos resolvem o problema do <strong>código espalhado</strong>. Em vez de ter variáveis e funções soltas para manipular um usuário, agrupamos tudo que pertence a um <code class="inline-code">Usuario</code> dentro da classe <code class="inline-code">Usuario</code>. Isso torna o código mais organizado, intuitivo e fácil de encontrar.
  </div>

  <div class="analogy-box">
      <h4>Analogia: A Planta da Casa</h4>
      <ul>
          <li>Uma <strong>Classe</strong> é como a <strong>planta de uma casa</strong>. Ela define a estrutura (quartos, banheiros) e os comportamentos possíveis (acender luzes). A planta é um modelo, não a casa em si.</li>
          <li>Um <strong>Objeto</strong> é a <strong>casa construída</strong>. Você pode construir várias casas (objetos) usando a mesma planta (classe). Cada casa é uma instância independente.</li>
      </ul>
  </div>

  <h4>🖥️ Exemplo Prático: A Classe <code class="inline-code">Usuario</code></h4>
  <pre><code class="language-java">// Versão 1: A classe é o "molde" para um Usuário.
public class Usuario {
  // Atributos: os dados que definem um usuário.
  String nome;
  String email;

  // Método: a ação que um objeto Usuário pode executar.
  void exibirInfo() {
      System.out.println("Nome: " + nome + ", Email: " + email);
  }
}

public class Principal {
  public static void main(String[] args) {
      // Criando o Objeto 1: uma instância real da classe Usuario.
      Usuario user1 = new Usuario();
      user1.nome = "Leonardo";
      user1.email = "leo@email.com";
      user1.exibirInfo(); // Saída: Nome: Leonardo, Email: leo@email.com
      // Criando o Objeto 2: outra instância, independente da primeira.
      Usuario user2 = new Usuario();
      user2.nome = "Ana";
      user2.email = "ana@email.com";
      user2.exibirInfo(); // Saída: Nome: Ana, Email: ana@email.com
  }
}
</code></pre>

  <hr>

  <h2>Módulo 2: Protegendo e Construindo Objetos</h2>
  <h4>🎯 Conceitos-Chave</h4>
  <ul>
      <li><strong>Encapsulamento</strong>: Proteger os dados internos (atributos) de um objeto, expondo apenas operações seguras através de métodos públicos (Getters/Setters). É o princípio de "esconder a complexidade".</li>
      <li><strong>Construtor</strong>: Um método especial, com o mesmo nome da classe, que garante que um objeto seja criado em um estado válido e completo.</li>
  </ul>

  <div class="info-box">
      <strong>💡 Por que isso é importante?</strong> O encapsulamento resolve o problema de <strong>estados inválidos e insegurança</strong>. Ele impede que qualquer parte do código altere um dado importante (como o saldo de uma conta) sem passar por uma validação. Você centraliza as regras de negócio e garante a integridade dos seus objetos.
  </div>
  
  <h4>🖥️ Exemplo Prático: Protegendo a Classe <code class="inline-code">Usuario</code></h4>
  <pre><code class="language-java">// Versão 2: Adicionando encapsulamento e construtor.
public class Usuario {
  // Atributos agora são PRIVADOS. Só a própria classe pode acessá-los diretamente.
  private String nome;
  private String email;
  private String senha;

  // Construtor: é chamado no momento da criação (new Usuario(...)).
  // Força a criação de um usuário com todos os dados necessários.
  public Usuario(String nome, String email, String senha) {
      this.nome = nome;
      this.email = email;
      this.senha = senha;
  }

  // Getter para nome: permite que o mundo externo LEIA o nome.
  public String getNome() {
      return this.nome;
  }

  // Setter para senha: permite que o mundo externo ALTERE a senha, mas com VALIDAÇÃO.
  public void setSenha(String novaSenha) {
      if (novaSenha != null &amp;&amp; novaSenha.length() >= 6) {
          this.senha = novaSenha;
          System.out.println("Senha alterada com sucesso!");
      } else {
          System.out.println("Erro: A senha deve ter no mínimo 6 caracteres.");
      }
  }
  
  // ... outros getters
}
</code></pre>

  <hr>

  <h2>Módulo 3: Reutilizando e Flexibilizando com Herança e Polimorfismo</h2>
  <h4>🎯 Conceitos-Chave</h4>
  <ul>
      <li><strong>Herança</strong> (<code class="inline-code">extends</code>): Permite que uma classe (filha/subclasse) herde atributos e métodos de outra classe (pai/superclasse), promovendo o reuso de código. Modela uma relação "É UM".</li>
      <li><strong>Polimorfismo</strong> (<code class="inline-code">@Override</code>): "Muitas formas". Permite que objetos de classes diferentes respondam à mesma chamada de método de maneiras específicas para cada um.</li>
  </ul>
  
  <div class="faq-box">
      <h4>Dúvida Comum: Herança Múltipla em Java</h4>
      <p>Uma classe em Java pode <code class="inline-code">extends</code> (herdar) de <strong>apenas UMA</strong> outra classe. Não existe herança múltipla de classes para evitar problemas de ambiguidade (como o "problema do diamante").</p>
      <p>No entanto, a herança pode ser <strong>multinível</strong>: uma classe <code class="inline-code">Neta</code> pode herdar da classe <code class="inline-code">Filha</code>, que por sua vez herda da classe <code class="inline-code">Avo</code>. A cadeia de herança pode ser longa.</p>
  </div>

  <h4>🖥️ Exemplo Prático: Especializando Usuários</h4>
  <pre><code class="language-java">
// --- CLASSE PAI (SUPERCLASSE) ---
public class Usuario {
  protected String nome; // Protected é visível para as classes filhas.

  public Usuario(String nome) { this.nome = nome; }

  public void login() {
      System.out.println(this.nome + " logou com acesso padrão.");
  }
}

// --- CLASSE FILHA 1 (SUBCLASSE) ---
public class Administrador extends Usuario {
  public Administrador(String nome) {
      super(nome); // Chama o construtor da classe pai (Usuario).
  }

  // POLIMORFISMO: Sobrescrevendo o método login.
  @Override
  public void login() {
      System.out.println("Admin " + this.nome + " logou com privilégios elevados!");
  }
}

// --- CLASSE FILHA 2 (SUBCLASSE) ---
public class Cliente extends Usuario {
  public Cliente(String nome) {
      super(nome);
  }

  @Override
  public void login() {
      System.out.println("Cliente " + this.nome + " logou na loja online.");
  }
}

public class Principal {
  public static void main(String[] args) {
      Usuario admin = new Administrador("Leo Admin");
      Usuario cliente = new Cliente("Ana Cliente");
      // Polimorfismo em ação! O mesmo método login() tem resultados diferentes.
      admin.login();   // Chama o login() de Administrador
      cliente.login(); // Chama o login() de Cliente
  }
}
</code></pre>

  <hr>
  
  <h2>Módulo 4: Desacoplando com Contratos e Modelos</h2>
  <h4>🎯 Conceitos-Chave</h4>
  <ul>
      <li><strong>Interface</strong> (<code class="inline-code">interface</code>): Um "contrato" 100% abstrato. Define um conjunto de métodos que uma classe <strong>deve</strong> implementar. Define "o quê" fazer, mas nunca "o como".</li>
      <li><strong>Classe Abstrata</strong> (<code class="inline-code">abstract class</code>): Uma classe "incompleta" que pode mesclar métodos concretos (com corpo) e métodos abstratos (sem corpo). Serve como um modelo base, mas não pode ser instanciada diretamente.</li>
  </ul>
  
  <div class="key-point-box">
      <h4>Ponto de Atenção: Classe Abstrata vs. Interface</h4>
      <ul>
          <li>Use uma <strong>Classe Abstrata</strong> quando quiser compartilhar código comum (métodos já implementados) entre várias subclasses relacionadas (relação "É UM").</li>
          <li>Use uma <strong>Interface</strong> quando quiser definir uma capacidade ou um comportamento que classes não relacionadas podem implementar (relação "É CAPAZ DE"). Pense em <code class="inline-code">Autenticavel</code>, <code class="inline-code">Imprimivel</code>, <code class="inline-code">Comparavel</code>.</li>
      </ul>
  </div>
  
  <div class="faq-box">
      <h4>Dúvida Comum: Implementando Múltiplas Interfaces</h4>
      <p>Diferente da herança de classes, uma classe em Java pode <code class="inline-code">implements</code> (implementar) <strong>VÁRIAS</strong> interfaces. Isso é o que permite a flexibilidade do polimorfismo em larga escala. Um objeto pode "vestir vários chapéus", assinando diferentes contratos.</p>
      <p>Exemplo: <code class="inline-code">public class SmartTV extends Eletronico implements Conectavel, Imprimivel</code></p>
  </div>

  <h4>🖥️ Exemplo Prático: Contrato <code class="inline-code">Autenticavel</code> e Modelo <code class="inline-code">Usuario</code></h4>
  <pre><code class="language-java">// O Contrato
public interface Autenticavel {
  boolean login(String email, String senha); // Toda classe que implementar, DEVE ter este método.
}

// O Modelo Base (agora abstrato)
public abstract class Usuario {
  protected String nome;
  protected String email;

  public Usuario(String nome, String email) {
      this.nome = nome;
      this.email = email;
  }
  
  // Método abstrato: força as classes filhas a implementarem sua própria versão.
  public abstract void exibirPerfil();
}

// Classe Concreta implementando o contrato e herdando do modelo
public class Admin extends Usuario implements Autenticavel {
  private String senha;

  public Admin(String nome, String email, String senha) {
      super(nome, email);
      this.senha = senha;
  }

  @Override
  public boolean login(String email, String senha) {
      // Lógica de autenticação do admin
      return this.email.equals(email) &amp;&amp; this.senha.equals(senha);
  }

  @Override
  public void exibirPerfil() {
      System.out.println("Perfil de Administrador: " + this.nome);
  }
}
</code></pre>

  <hr>

  <h2>Módulo 5: Arquitetura e Projeto Final</h2>
  <p>Nesta etapa, conectamos todos os conceitos para estruturar uma aplicação em camadas, simulando um backend real. A OO é a base para essa organização.</p>
  
  <div class="analogy-box">
      <h4>Analogia: O Bolo de Camadas (Arquitetura de Software)</h4>
      <ul>
          <li><strong>Camada de Apresentação (Controller):</strong> A parte com que o mundo externo interage. Recebe requisições e devolve respostas.</li>
          <li><strong>Camada de Serviço (Service):</strong> O "cérebro" da aplicação. Contém a lógica de negócio e orquestra as operações.</li>
          <li><strong>Camada de Acesso a Dados (Repository):</strong> Responsável por se comunicar com o banco de dados. Sua única função é salvar e buscar dados.</li>
      </ul>
      <p>A comunicação flui de cima para baixo, e as dependências entre camadas são gerenciadas via <strong>interfaces</strong> para garantir o desacoplamento.</p>
  </div>

  <h4>🖥️ Desafio Final Consolidado: Sistema de Gerenciamento</h4>
  <p>O objetivo é criar um mini-sistema que use todos os pilares da OO. Abaixo está a estrutura e o código sugerido.</p>
  
  <h5>Diagrama de Classes</h5>
  <pre>
[Interface: Autenticavel] &lt;--implements-- [Admin] --extends--&gt; [Abstract: Usuario]
          ^                                                        ^
          |                                                        |
          +--implements-- [Cliente] --extends---------------------+
          
[Interface: Gerenciavel] &lt;--implements-- [Admin]
  </pre>

  <h5>Código da Solução Final</h5>
  <pre><code class="language-java">
// --- INTERFACES (CONTRATOS) ---
public interface Autenticavel {
  boolean login(String email, String senha);
}
public interface Gerenciavel {
  void acessarPainelDeControle();
}

// --- CLASSE ABSTRATA (MODELO BASE) ---
public abstract class Usuario {
  protected String nome;
  protected String email;
  public Usuario(String nome, String email) { this.nome = nome; this.email = email; }
  public abstract void exibirPerfil();
}

// --- CLASSES CONCRETAS ---
public class Cliente extends Usuario implements Autenticavel {
  private String senha;
  public Cliente(String n, String e, String s) { super(n, e); this.senha = s; }

  @Override
  public boolean login(String email, String senha) { return this.email.equals(email) &amp;&amp; this.senha.equals(senha); }

  @Override
  public void exibirPerfil() { System.out.println("Cliente: " + nome + " | Email: " + email); }
}

public class Admin extends Usuario implements Autenticavel, Gerenciavel {
  private String senha;
  private String cargo;
  public Admin(String n, String e, String s, String c) { super(n, e); this.senha = s; this.cargo = c; }

  @Override
  public boolean login(String email, String senha) { return this.email.equals(email) &amp;&amp; this.senha.equals(senha); }
  
  @Override
  public void acessarPainelDeControle() { System.out.println("Acessando painel como: " + cargo); }
  
  @Override
  public void exibirPerfil() { System.out.println("Admin: " + nome + " | Cargo: " + cargo); }
}

// --- EXECUÇÃO ---
public class Main {
  public static void main(String[] args) {
      // Note que podemos nos referir a eles pelo tipo mais genérico (Usuario)
      Usuario cliente = new Cliente("João", "joao@email.com", "1234");
      Usuario admin = new Admin("Ana", "ana@email.com", "admin123", "Gerente de TI");
      cliente.exibirPerfil();
      admin.exibirPerfil();
      System.out.println("---");
      // Para usar métodos das interfaces, precisamos fazer um "cast"
      if (((Autenticavel)cliente).login("joao@email.com", "1234")) {
          System.out.println("Login do cliente bem-sucedido!");
      }
      if (((Autenticavel)admin).login("ana@email.com", "admin123")) {
          System.out.println("Login do admin bem-sucedido!");
          ((Gerenciavel)admin).acessarPainelDeControle();
      }
  }
}
</code></pre>

  <hr>
  
  <h2>🚀 Epílogo e Próximos Passos</h2>
  <p>Dominar a Orientação a Objetos é a chave para criar sistemas <strong>manuteníveis, testáveis e escaláveis</strong>. Os conceitos que vimos são a base de frameworks modernos como Spring Boot, onde <code class="inline-code">@Repository</code>, <code class="inline-code">@Service</code> e <code class="inline-code">@Controller</code> nada mais são do que a aplicação desses princípios de separação de responsabilidades.</p>
  
  <div class="challenge-box">
      <h4>Sua Jornada Continua:</h4>
      <ul>
          <li><strong>Princípios SOLID:</strong> São 5 regras de design que elevam o uso da OO a um nível profissional.</li>
          <li><strong>Padrões de Projeto (Design Patterns):</strong> Soluções consagradas para problemas comuns (Factory, Singleton, Strategy, etc.).</li>
          <li><strong>Testes Unitários e Mocks:</strong> Aprender a testar cada camada de forma isolada, o que só é possível graças ao desacoplamento que a OO promove.</li>
      </ul>
  </div>
  
  <p style="text-align:center; font-size: 1.2em; margin-top: 2em;">
      <strong>Missão cumprida. Bons estudos e bom código!</strong>
  </p>

</div>

<style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            color: #212529;
        }
        .container {
            max-width: 900px;
            margin: 20px auto;
            padding: 25px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
        }
        .author-box {
            text-align: center;
            margin-bottom: 2em;
            padding: 1em;
            background-color: #e9ecef;
            border-radius: 5px;
        }
        .author-box h1 {
            margin: 0;
        }
        .author-box p {
            margin: 5px 0 0;
            font-style: italic;
            color: #495057;
        }
        h1, h2, h3, h4 {
            color: #34495e;
            border-bottom: 2px solid #dee2e6;
            padding-bottom: 10px;
        }
        h1 { font-size: 2.5em; border-bottom-color: #3498db; }
        h2 { font-size: 2em; margin-top: 1.8em; }
        h3 { font-size: 1.6em; border-bottom-style: dashed; }
        h4 { font-size: 1.3em; border-bottom: none; }
        hr {
            border: 0;
            height: 1px;
            background: #dee2e6;
            margin: 2em 0;
        }
        pre {
            background-color: #2c3e50;
            color: #ecf0f1;
            padding: 20px;
            border-radius: 5px;
            overflow-x: auto;
            font-family: 'Courier New', Courier, monospace;
            font-size: 0.95em;
        }
        code {
            font-family: 'Courier New', Courier, monospace;
        }
        .inline-code {
            background-color: #e9ecef;
            padding: 2px 5px;
            border-radius: 3px;
            font-size: 0.9em;
        }
        .info-box, .analogy-box, .challenge-box, .key-point-box, .faq-box {
            padding: 15px 20px;
            margin: 1.5em 0;
            border-left-width: 5px;
            border-left-style: solid;
            border-radius: 0 5px 5px 0;
        }
        .info-box { background-color: #e8f4fd; border-left-color: #3498db; }
        .analogy-box { background-color: #fdf3e8; border-left-color: #f39c12; }
        .challenge-box { background-color: #eafaf1; border-left-color: #2ecc71; }
        .key-point-box { background-color: #fbeeef; border-left-color: #e74c3c; }
        .faq-box { background-color: #f5eef8; border-left-color: #9b59b6; }
        ul { padding-left: 20px; }
        li { margin-bottom: 0.5em; }
        strong { color: #c0392b; }
    </style>
