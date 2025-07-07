<h1>📚 Plano de Aulas: Orientação a Objetos Essencial com Java</h1>

<p><strong>Público-Alvo:</strong> Equipe de desenvolvimento </p>

<p><strong>Objetivo Geral:</strong> Nivelar a equipe em Orientação a Objetos, mostrando como escrever código manutenível, escalável e alinhado ao negócio — preparando todos para arquiteturas modernas e ambientes reais como aplicações Spring Boot em camadas.</p>

<p><strong>Recursos Necessários:</strong> IDE Java (IntelliJ IDEA Community, Eclipse ou VS Code com plugin Java), quadro branco, canetas coloridas.</p>

<hr />

<h2>📜 Introdução: A Origem da Orientação a Objetos</h2>

<p>
  Nos anos 60, na Noruega, Ole-Johan Dahl e Kristen Nygaard criaram o Simula, a primeira linguagem com Objetos e Classes.
  Para simular navios em um porto, perceberam que juntar <strong>dados + comportamentos</strong> em uma única entidade (o Objeto)
  tornava o sistema muito mais próximo da realidade — e muito mais fácil de entender, manter e evoluir.
</p>

<p>
  Anos depois, Alan Kay no Xerox PARC criou o Smalltalk, dizendo: “tudo é objeto” — e aí nasceu a Orientação a Objetos moderna.
  Hoje, frameworks como <strong>Spring Boot</strong> aplicam exatamente esses conceitos: objetos organizados em camadas claras, com contratos,
  abstrações e flexibilidade. É isso que você vai aprender aqui!
</p>

<hr />

<h2>📅 Semana 1</h2>

<h3>✅ Sessão 1 — O Mundo Real em Código: Classes, Objetos e Componentes</h3>
<p><strong>Duração:</strong> ~1 hora (30–40 min teoria/demo, 20–30 min prática/discussão)</p>

<h4>🎯 Conceitos</h4>
<ul>
  <li>Classes</li>
  <li>Objetos</li>
  <li>Atributos</li>
  <li>Métodos</li>
</ul>

<h4>1️⃣ Abertura</h4>
<p>
  Mostrar como OO traduz o mundo real em código — assim como Simula modelou navios, aqui modelamos problemas de negócio em sistemas reais.
  O Java nos força a dominar esses pilares para depois aplicar em arquiteturas maiores, como MVC, REST APIs e camadas desacopladas.
</p>

<h4>🖍️ Analogia</h4>
<p>Desenhe: Planta de uma casa (Classe) → casas reais (Objetos). Atributos = características (cor, quartos), Métodos = ações (abrir porta).</p>

<h4>🖥️ Exemplo Java</h4>
<pre><code>public class Cachorro {
  String nome;
  int idade;

  void latir() {
    System.out.println(nome + " está latindo!");
  }

  void comer() {
    System.out.println(nome + " está comendo.");
  }
}

public class Principal {
  public static void main(String[] args) {
    Cachorro cachorro1 = new Cachorro();
    cachorro1.nome = "Bolt";
    cachorro1.idade = 3;
    cachorro1.latir();
  }
}
</code></pre>

<h4>⚡ Exercício Rápido</h4>
<p>Crie a classe <code>Celular</code>, defina atributos e métodos, instancie objetos — um treino essencial para pensar em “componentes reutilizáveis”.</p>
<pre><code>public class Celular {
  String marca;
  String modelo;
  int armazenamentoGB;

  void ligar() {
    System.out.println("Ligando " + marca + " " + modelo);
  }

  void fazerChamada(String numero) {
    System.out.println("Chamando: " + numero);
  }
}

public class Principal {
  public static void main(String[] args) {
    Celular celular1 = new Celular();
    celular1.marca = "Samsung";
    celular1.modelo = "Galaxy S21";
    celular1.armazenamentoGB = 128;
    celular1.ligar();
    celular1.fazerChamada("1199999-9999");
  }
}
</code></pre>

<hr />

<h3>✅ Sessão 2 — Moldando Objetos: Construtores e Encapsulamento</h3>
<p><strong>Duração:</strong> ~1 hora</p>

<h4>🎯 Conceitos</h4>
<ul>
  <li>Construtores</li>
  <li>Encapsulamento</li>
</ul>

<p>Assim como num sistema real, precisamos garantir que um objeto nasce válido (Construtor) e protege seus dados internos (Encapsulamento) — isso reflete boas práticas que usamos em frameworks reais para evitar bugs e facilitar testes unitários.</p>

<h4>🖥️ Exemplo Java - Construtor</h4>
<pre><code>public class Cachorro {
  private String nome;
  private int idade;

  public Cachorro(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public void latir() {
    System.out.println(nome + " está latindo!");
  }
}
</code></pre>

<h4>🖥️ Exemplo Java - Encapsulamento</h4>
<pre><code>public class Cachorro {
  private String nome;
  private int idade;

  public Cachorro(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    if (idade >= 0) {
      this.idade = idade;
    } else {
      System.out.println("Idade inválida");
    }
  }
}
</code></pre>

<h4>⚡ Exercício Rápido</h4>
<p>Transforme <code>Celular</code> para usar encapsulamento — como faríamos para proteger entidades num projeto Spring com JPA, por exemplo.</p>
<pre><code>public class Celular {
  private String marca;
  private String modelo;
  private int armazenamentoGB;

  public String getMarca() { return marca; }
  public void setMarca(String marca) { this.marca = marca; }

  public String getModelo() { return modelo; }
  public void setModelo(String modelo) { this.modelo = modelo; }

  public int getArmazenamentoGB() { return armazenamentoGB; }
  public void setArmazenamentoGB(int armazenamentoGB) {
    if (armazenamentoGB >= 0) {
      this.armazenamentoGB = armazenamentoGB;
    } else {
      System.out.println("Armazenamento inválido");
    }
  }
}
</code></pre>

<hr />

<h3>✅ Sessão 3 — Flexibilidade e Contratos: Herança e Polimorfismo</h3>
<p><strong>Duração:</strong> ~1 hora</p>

<p>Estes conceitos garantem <strong>reuso e extensibilidade</strong>. Assim como num projeto real, criamos “padrões” com classes base e especializamos comportamentos — exatamente como criamos serviços herdando lógicas ou sobrescrevendo métodos.</p>

<h4>🖥️ Exemplo Java - Herança e Polimorfismo</h4>
<pre><code>public class Animal {
  String nome;

  void fazerBarulho() {
    System.out.println("Algum som genérico.");
  }
}

public class Cachorro extends Animal {
  @Override
  void fazerBarulho() {
    System.out.println("Au au!");
  }
}

public class Gato extends Animal {
  @Override
  void fazerBarulho() {
    System.out.println("Miau!");
  }
}

public class Principal {
  public static void main(String[] args) {
    Animal dog = new Cachorro();
    Animal cat = new Gato();
    dog.fazerBarulho();
    cat.fazerBarulho();
  }
}
</code></pre>

<h4>⚡ Exercício Rápido</h4>
<p>Crie <code>InstrumentoMusical</code> com método <code>tocar()</code> — e subclasses para explorar sobrescrita, como em strategies no Spring.</p>
<pre><code>public class InstrumentoMusical {
  void tocar() {
    System.out.println("Som genérico.");
  }
}

public class Violao extends InstrumentoMusical {
  @Override
  void tocar() {
    System.out.println("Strum Strum!");
  }
}

public class Piano extends InstrumentoMusical {
  @Override
  void tocar() {
    System.out.println("Plim Plim!");
  }
}
</code></pre>

<hr />

<h2>📅 Semana 2</h2>

<h3>✅ Sessão 4 — Abstração e Interfaces: Desacoplamento</h3>
<p><strong>Duração:</strong> ~1 hora</p>

<p>Interfaces e classes abstratas são o coração de arquiteturas desacopladas — assim como Spring Boot usa interfaces para repos, serviços e controladores interagirem sem se conhecerem internamente.</p>

<h4>🖥️ Exemplo Java - Abstração</h4>
<pre><code>public abstract class Veiculo {
  abstract void mover();
}

public class Carro extends Veiculo {
  @Override
  void mover() {
    System.out.println("Rodas girando!");
  }
}
</code></pre>

<h4>🖥️ Exemplo Java - Interfaces</h4>
<pre><code>public interface RepositorioGenerico {
  void salvar();
  void buscarPorId(int id);
}

public class UsuarioRepositoryDB implements RepositorioGenerico {
  public void salvar() { System.out.println("Salvar no banco."); }
  public void buscarPorId(int id) { System.out.println("Buscar no banco: " + id); }
}
</code></pre>

<h4>⚡ Exercício Rápido</h4>
<p>Crie <code>ProcessadorMensagem</code> — como se fosse um serviço com duas implementações.</p>
<pre><code>public interface ProcessadorMensagem {
  void enviar(String mensagem);
}

public class SMSProcessador implements ProcessadorMensagem {
  public void enviar(String mensagem) {
    System.out.println("SMS: " + mensagem);
  }
}

public class EmailProcessador implements ProcessadorMensagem {
  public void enviar(String mensagem) {
    System.out.println("Email: " + mensagem);
  }
}
</code></pre>

<hr />

<h2>🔚 Epílogo — Por que Orientação a Objetos é tão essencial?</h2>

<p>
  OO nasceu para resolver complexidade — do porto de navios ao seu projeto em Spring Boot.
  Modelar com Objetos, Herança, Encapsulamento, Abstração e Interfaces permite construir <strong>camadas independentes</strong>:
  Repositorios, Services, Controllers. Assim testamos partes isoladas, trocamos implementações sem quebrar o resto,
  e mantemos sistemas vivos por anos.
</p>

<p>
  O que começou com um navio agora move bancos digitais, lojas online e plataformas globais.
  O pilar é o mesmo: organizar ideias como Objetos que interagem, seguros, extensíveis e testáveis.
</p>

<p>🚀 <strong>Prontos para o próximo nível? Bora codar como um time moderno!</strong></p>
