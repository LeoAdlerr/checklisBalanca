<h1>📚 Plano de Aulas: Orientação a Objetos Essencial com Java</h1>

  <p><strong>Público-Alvo:</strong> Equipe de desenvolvimento (nível aprendiz)</p>
  <p><strong>Objetivo Geral:</strong> Nivelar a equipe em Orientação a Objetos, mostrando como escrever código manutenível, escalável e alinhado ao negócio, preparando-os para arquiteturas modernas.</p>
  <p><strong>Recursos Necessários:</strong> IDE Java (IntelliJ IDEA Community, Eclipse ou VS Code com plugin Java), quadro branco, canetas coloridas.</p>

  <hr />

  <h2>📜 Introdução: A Origem da Orientação a Objetos</h2>
  <p>
    Nos anos 60, na Noruega, Ole-Johan Dahl e Kristen Nygaard criaram o Simula, a primeira linguagem com o conceito de Objetos e Classes.
    Eles precisavam simular o tráfego de navios — mas as linguagens existentes misturavam dados e lógica de forma bagunçada. Assim nasceu a ideia de juntar <strong>dados + comportamentos</strong> em uma única entidade: o Objeto.
  </p>
  <p>
    Anos depois, Alan Kay, no Xerox PARC, criou o Smalltalk, levando isso ao extremo — “tudo é objeto” — e batizou o conceito de Orientação a Objetos.
    O resto é história: C++, Java, C#, Python… todas carregam esse DNA. Entender OO é entender a base de quase toda linguagem moderna!
  </p>

  <hr />

  <h2>📅 Semana 1</h2>

  <h3>✅ Sessão 1 — O Mundo Real em Código: Classes, Objetos e Componentes</h3>
  <p><strong>Duração:</strong> ~1 hora (30–40 min teoria/demonstração, 20–30 min prática/discussão)</p>

  <h4>🎯 Conceitos</h4>
  <ul>
    <li>Classes</li>
    <li>Objetos</li>
    <li>Atributos</li>
    <li>Métodos</li>
  </ul>

  <h4>1️⃣ Abertura (5 min)</h4>
  <p>Contextualize: “Programar não é só fazer o código rodar. É organizar ideias, colaborar em equipe e criar soluções que durem.”</p>
  <p>Por que Java? Java força uma base sólida em OO — entender OO em Java abre portas para qualquer linguagem moderna.</p>

  <h4>2️⃣ Classes e Objetos (20 min)</h4>
  <p>
    <strong>Analogia:</strong> Desenhe uma planta de uma casa (Classe) e duas casas reais (Objetos).
    Explique: Classe = Molde, Objeto = Instância.
  </p>
  <p>
    <strong>Atributos:</strong> Características (cor, quartos).<br>
    <strong>Métodos:</strong> Ações (abrir porta, acender luz).
  </p>

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

  <h4>3️⃣ Exercício Rápido</h4>
  <p>
    Crie uma classe <code>Celular</code> com:
    <ul>
      <li>Atributos: marca, modelo, armazenamentoGB</li>
      <li>Métodos: ligar(), fazerChamada(String numero)</li>
    </ul>
    Instancie dois objetos e use os métodos.
  </p>
  <pre><code>public class Celular {
  String marca;
  String modelo;
  int armazenamentoGB;

  void ligar() {
    System.out.println("Ligando o celular " + marca + " " + modelo);
  }

  void fazerChamada(String numero) {
    System.out.println("Fazendo chamada para " + numero);
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

    Celular celular2 = new Celular();
    celular2.marca = "Apple";
    celular2.modelo = "iPhone 13";
    celular2.armazenamentoGB = 256;
    celular2.ligar();
  }
}
</code></pre>

  <hr />

  <h3>✅ Sessão 2 — Moldando Objetos: Construtores e Encapsulamento</h3>
  <p><strong>Duração:</strong> ~1 hora</p>

  <h4>🎯 Conceitos</h4>
  <ul>
    <li>Construtores</li>
    <li>Encapsulamento (private, public, getters/setters)</li>
  </ul>

  <h4>🖥️ Exemplo Java - Construtor</h4>
  <pre><code>public class Cachorro {
  private String nome;
  private int idade;

  // Construtor
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
      System.out.println("Idade não pode ser negativa.");
    }
  }
}
</code></pre>

  <h4>4️⃣ Exercício Rápido</h4>
  <p>Desafio: Pegue a classe Celular. Torne os atributos <code>private</code>. Crie <code>getters</code> e <code>setters</code>. Valide que armazenamentoGB não pode ser negativo.</p>
  <pre><code>public class Celular {
  private String marca;
  private String modelo;
  private int armazenamentoGB;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getArmazenamentoGB() {
    return armazenamentoGB;
  }

  public void setArmazenamentoGB(int armazenamentoGB) {
    if (armazenamentoGB >= 0) {
      this.armazenamentoGB = armazenamentoGB;
    } else {
      System.out.println("Armazenamento não pode ser negativo.");
    }
  }
}
</code></pre>

  <hr />

  <h3>✅ Sessão 3 — Flexibilidade e Contratos: Herança e Polimorfismo</h3>
  <p><strong>Duração:</strong> ~1 hora</p>

  <h4>🖥️ Exemplo Java - Herança</h4>
  <pre><code>public class Animal {
  String nome;

  void dormir() {
    System.out.println(nome + " está dormindo.");
  }

  void fazerBarulho() {
    System.out.println(nome + " fez algum barulho.");
  }
}

public class Cachorro extends Animal {
  @Override
  void fazerBarulho() {
    System.out.println(nome + " faz: au au!");
  }
}

public class Gato extends Animal {
  @Override
  void fazerBarulho() {
    System.out.println(nome + " faz: miau!");
  }
}

public class Principal {
  public static void main(String[] args) {
    Cachorro dog = new Cachorro();
    dog.nome = "Bolt";
    dog.fazerBarulho();

    Gato cat = new Gato();
    cat.nome = "Whiskers";
    cat.fazerBarulho();
  }
}
</code></pre>

  <h4>4️⃣ Exercício Rápido</h4>
  <p>Crie uma classe <code>InstrumentoMusical</code> com método <code>tocar()</code>. Crie <code>Violao</code> e <code>Piano</code> herdando de InstrumentoMusical, cada um imprime seu som.</p>
  <pre><code>public class InstrumentoMusical {
  void tocar() {
    System.out.println("Tocando instrumento genérico.");
  }
}

public class Violao extends InstrumentoMusical {
  @Override
  void tocar() {
    System.out.println("Tocando violão: Strum Strum!");
  }
}

public class Piano extends InstrumentoMusical {
  @Override
  void tocar() {
    System.out.println("Tocando piano: Plim Plim!");
  }
}

public class Principal {
  public static void main(String[] args) {
    InstrumentoMusical violao = new Violao();
    InstrumentoMusical piano = new Piano();

    violao.tocar();
    piano.tocar();
  }
}
</code></pre>

  <hr />

  <h2>📅 Semana 2</h2>

  <h3>✅ Sessão 4 — Definindo Contratos: Abstração e Interfaces</h3>
  <p><strong>Duração:</strong> ~1 hora</p>

  <h4>🖥️ Exemplo Java - Abstração</h4>
  <pre><code>public abstract class Veiculo {
  abstract void mover();
}

public class Carro extends Veiculo {
  @Override
  void mover() {
    System.out.println("O carro está se movendo pelas rodas.");
  }
}

public class Aviao extends Veiculo {
  @Override
  void mover() {
    System.out.println("O avião está voando pelos céus.");
  }
}
</code></pre>

  <h4>🖥️ Exemplo Java - Interfaces</h4>
  <pre><code>public interface RepositorioGenerico {
  void salvar();
  void buscarPorId(int id);
}

public class UsuarioRepositoryDB implements RepositorioGenerico {
  @Override
  public void salvar() {
    System.out.println("Salvando usuário no banco de dados.");
  }

  @Override
  public void buscarPorId(int id) {
    System.out.println("Buscando usuário no banco de dados com ID: " + id);
  }
}

public class UsuarioRepositoryMemoria implements RepositorioGenerico {
  @Override
  public void salvar() {
    System.out.println("Salvando usuário na memória.");
  }

  @Override
  public void buscarPorId(int id) {
    System.out.println("Buscando usuário na memória com ID: " + id);
  }
}
</code></pre>

  <h4>4️⃣ Exercício Rápido</h4>
  <p>Crie interface <code>ProcessadorMensagem</code> com <code>enviar(String mensagem)</code>. Implemente <code>SMSProcessador</code> e <code>EmailProcessador</code>.</p>
  <pre><code>public interface ProcessadorMensagem {
  void enviar(String mensagem);
}

public class SMSProcessador implements ProcessadorMensagem {
  @Override
  public void enviar(String mensagem) {
    System.out.println("Enviando SMS: " + mensagem);
  }
}

public class EmailProcessador implements ProcessadorMensagem {
  @Override
  public void enviar(String mensagem) {
    System.out.println("Enviando Email: " + mensagem);
  }
}
</code></pre>

  <hr />

  <h3>🚀 Parabéns!</h3>
  <p>Ao final, revise:</p>
  <ul>
    <li>Classes/Objetos</li>
    <li>Encapsulamento</li>
    <li>Herança</li>
    <li>Polimorfismo</li>
    <li>Abstração</li>
    <li>Interfaces e Desacoplamento</li>
  </ul>

   <hr />

  <h2>🔚 Epílogo — Por que Orientação a Objetos é tão essencial?</h2>

  <p>
    Desde os primeiros simuladores de navios, a Orientação a Objetos nasceu para lidar com algo que nunca parou de crescer: a <strong>complexidade</strong>.
    Quando modelamos o mundo real com objetos, classes, abstrações e contratos, deixamos o código mais próximo da forma como pensamos.
  </p>

  <p>
    Em sistemas modernos, como uma aplicação <strong>Spring Boot</strong>, esses princípios aparecem o tempo todo: 
    temos <em>Repositories</em> (contratos/interfaces para acessar dados), <em>Services</em> (regras de negócio), 
    <em>Controllers</em> (interface com o usuário ou API) — cada camada com uma <strong>responsabilidade clara</strong>.
    Cada parte conversa com a outra por meio de <strong>interfaces</strong> e classes <strong>abstratas</strong>, que garantem flexibilidade e desacoplamento.
  </p>

  <p>
    É assim que conseguimos mudar o banco de dados, trocar uma regra de negócio ou melhorar a API, sem precisar reescrever tudo do zero.
    Essa separação permite também <strong>testar cada peça isoladamente</strong>: podemos testar um repositório, um serviço ou um controller,
    de forma independente, confiando que cada parte faz apenas o que foi contratada para fazer.
  </p>

  <p>
    Assim como no porto simulado do Simula, hoje modelamos sistemas complexos — sejam navios, aplicações bancárias, plataformas de streaming ou sistemas de gestão.
    E tudo isso só é possível porque temos uma forma organizada de representar comportamentos, dados e contratos: a <strong>Orientação a Objetos</strong>.
  </p>

  <p>
    Com esses fundamentos, vocês estão prontos para dar os próximos passos: explorar frameworks modernos, arquiteturas em camadas, testes automatizados
    e design de sistemas robustos. Este é o ponto de partida — o resto, vocês constroem como <strong>time</strong>.
  </p>

  <p>🚀 <strong>Bons estudos e bom código!</strong></p>
