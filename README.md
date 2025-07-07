<h1>📚 Plano de Aulas: Orientação a Objetos Essencial com Java</h1>

<p><strong>Público-Alvo:</strong> Equipe de desenvolvimento (nível aprendiz)</p>
<p><strong>Objetivo Geral:</strong> Nivelar a equipe em Orientação a Objetos, mostrando como escrever código manutenível, escalável e alinhado ao negócio, preparando-os para arquiteturas modernas.</p>
<p><strong>Recursos Necessários:</strong> IDE Java (IntelliJ IDEA Community, Eclipse ou VS Code com plugin Java), quadro branco, canetas coloridas, container MySQL (Docker).</p>

<hr />

<h2>📜 Introdução</h2>
<p>
  A Orientação a Objetos nasceu da necessidade de modelar sistemas complexos — de portos na Noruega aos microserviços de hoje.
  Entender OO é dominar o jeito moderno de organizar código em qualquer linguagem: Java, C#, Python, Kotlin.
</p>

<hr />

<h2>📅 Semana 1</h2>

<h3>✅ Aula 1 — Classes e Objetos</h3>
<p><strong>Foco:</strong> Conceitos de Classe, Objeto, Atributos, Métodos.</p>

<p><strong>Contexto:</strong> Imagine que queremos criar um sistema simples para registrar usuários de uma plataforma.</p>

<pre><code>public class Usuario {
  String nome;
  String email;

  void exibirInfo() {
    System.out.println("Nome: " + nome + ", Email: " + email);
  }
}

public class Principal {
  public static void main(String[] args) {
    Usuario user = new Usuario();
    user.nome = "Leonardo";
    user.email = "leo@email.com";
    user.exibirInfo();
  }
}
</code></pre>

<p><strong>Exercício:</strong> Adicione um novo atributo <code>senha</code> e um método <code>login()</code> que imprime "Usuário logado".</p>

<hr />

<h3>✅ Aula 2 — Construtores e Encapsulamento</h3>
<p><strong>Foco:</strong> Evoluir o <code>Usuario</code> para usar Construtor, <code>private</code> e <code>getters/setters</code>.</p>

<pre><code>public class Usuario {
  private String nome;
  private String email;
  private String senha;

  public Usuario(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }

  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getSenha() { return senha; }
  public void setSenha(String senha) { this.senha = senha; }

  public void login() {
    System.out.println(nome + " logou com email: " + email);
  }
}

public class Principal {
  public static void main(String[] args) {
    Usuario user = new Usuario("Leonardo", "leo@email.com", "123456");
    user.login();
  }
}
</code></pre>

<p><strong>Exercício:</strong> Bloqueie <code>setSenha</code> para não aceitar senhas menores que 6 caracteres.</p>

<hr />

<h3>✅ Aula 3 — Herança e Polimorfismo</h3>
<p><strong>Foco:</strong> Crie subclasses de <code>Usuario</code> — Ex: <code>Administrador</code> e <code>Cliente</code>.</p>

<pre><code>public class Usuario {
  protected String nome;
  protected String email;

  public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public void login() {
    System.out.println(nome + " logou.");
  }
}

public class Administrador extends Usuario {
  public Administrador(String nome, String email) {
    super(nome, email);
  }

  public void acessarPainelAdmin() {
    System.out.println(nome + " acessou o painel de administração.");
  }

  @Override
  public void login() {
    System.out.println("Admin " + nome + " logou com privilégios elevados.");
  }
}

public class Cliente extends Usuario {
  public Cliente(String nome, String email) {
    super(nome, email);
  }

  @Override
  public void login() {
    System.out.println("Cliente " + nome + " logou na loja online.");
  }
}

public class Principal {
  public static void main(String[] args) {
    Usuario admin = new Administrador("Leonardo", "leo@empresa.com");
    Usuario cliente = new Cliente("João", "joao@email.com");

    admin.login();
    cliente.login();
  }
}
</code></pre>

<p><strong>Exercício:</strong> Crie um método exclusivo para <code>Cliente</code> chamado <code>comprar()</code> que imprime "Realizando compra".</p>

<hr />

<h2>📅 Semana 2</h2>

<h3>✅ Aula 4 — Abstração e Interfaces</h3>
<p><strong>Foco:</strong> Defina uma <code>abstract class</code> para métodos comuns, e uma <code>interface</code> para o repositório.</p>

<pre><code>public abstract class UsuarioBase {
  protected String nome;
  protected String email;

  public UsuarioBase(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public abstract void login();
}

public interface UsuarioRepository {
  void salvar(UsuarioBase usuario);
  UsuarioBase buscarPorEmail(String email);
}

public class UsuarioRepositoryMySQL implements UsuarioRepository {
  @Override
  public void salvar(UsuarioBase usuario) {
    System.out.println("Salvando " + usuario.nome + " no MySQL.");
  }

  @Override
  public UsuarioBase buscarPorEmail(String email) {
    System.out.println("Buscando " + email + " no MySQL.");
    return null; // Exemplo didático
  }
}
</code></pre>

<p><strong>Exercício:</strong> Crie uma implementação <code>UsuarioRepositoryMemoria</code> simulando armazenamento em uma lista.</p>

<hr />

<h3>✅ Aula 5 — Projeto Final: Mini Backend com Cadastro + Login + MySQL</h3>

<p><strong>Objetivo:</strong> Juntar tudo em um backend básico com:</p>
<ul>
  <li>Classe de domínio (<code>Usuario</code>), com construtor, encapsulamento</li>
  <li>Herança se necessário (Admin, Cliente)</li>
  <li>Abstração com <code>abstract class</code></li>
  <li><code>Interface</code> para o repositório</li>
  <li>Implementação real usando JDBC e um container MySQL</li>
</ul>

<p><strong>Fluxo:</strong> Escreva um <code>main()</code> que permita:</p>
<ul>
  <li>Cadastrar novo usuário</li>
  <li>Consultar usuário por email</li>
  <li>Testar login</li>
</ul>

<p>Exemplo de conexão JDBC:</p>

<pre><code>import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsuarioRepositoryMySQL implements UsuarioRepository {
  private Connection conectar() {
    try {
      return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/seubanco", "root", "sua_senha");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void salvar(UsuarioBase usuario) {
    try (Connection conn = conectar()) {
      String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario.nome);
      stmt.setString(2, usuario.email);
      stmt.executeUpdate();
      System.out.println("Usuário salvo no MySQL.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public UsuarioBase buscarPorEmail(String email) {
    // Implementar select com ResultSet
    return null;
  }
}
</code></pre>

<p><strong>Desafio Final:</strong> Implementar fluxo CRUD + login, testando com o container MySQL de vocês. 💪</p>

<hr />

<h2>🚀 Epílogo</h2>
<p>
  Com esse projeto em evolução, vocês viram como uma Classe simples cresce até se tornar parte de um sistema real com boas práticas.
  Daqui pra frente, frameworks como Spring Boot vão automatizar partes disso, mas o fundamento de Classes, Herança, Abstração e Interfaces nunca muda.
</p>

<p><strong>Missão cumprida. Bons estudos e bom código!</strong></p>
