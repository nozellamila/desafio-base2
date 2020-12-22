# Automação do Mantis Utilizando Selenium

Para a automação proposta foi utilizado a linguagem Java, através do framework de teste [JUnit](https://junit.org/junit4/). Tratando-se de uma aplicação web foi utilizado o [Selenium](https://www.selenium.dev/) para manipulação do browser e [Cucumber](https://cucumber.io/docs/gherkin/reference/) para estruturação dos testes, seguindo seu uso como forma de desenvolver testes voltados a comportamento.

### Justificativa

A estratégia adotada, utilizando as citadas ferramentas, justifica-se pela pirâmide de testes. Esse é um conceito importante em equipes ágeis e ilustra bem porque aplicações devem ter a maior parte da sua cobertura de testes em níveis mais baixos da pirâmide, abaixo uma ilustração desse conceito:

![imagem](https://devporai.com.br/wp-content/uploads/2020/02/Pir%C3%A2mide-testes.png)

Fonte: [devporai](https://devporai.com.br)

Dessa forma, é preferível que o projeto tenha uma cobertura de testes maior em testes que não envolvem interface, já que essas camadas são mais rápidas de serem desenvolvidas e mais resilientes a mudanças.

Sabe-se também que testes de interface estão muito mais sujeitos a particularidades de versões e browsers diferentes, deixando-os mais sujeitos a falhas, portanto o uso do BDD como forma de automatizar os principais fluxos do projeto, seguindo a ideia de testes de aceitação segundo o que expõe [syllabus de teste de aceitação](https://www.bstqb.org.br/uploads/syllabus/syllabus_ctfl_act_2019br.pdf) justifica-se nesse contexto.

### Organização do projeto de testes

O framework desenvolvido neste repositório segue o padrão de [page objects model](https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/) de maneira otimizada através do [page factory](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html), padrão amplamente adotado e que o selenium possui suporte.

Além disso, algumas classes auxiliares foram utilizadas para gerenciar o browser e serem utilizadas como base para os pages e testes, todas estã sob o diretório test/java/utils/. São elas:

- **Utils:** para implementar métodos genéricos que são utilizados nas classes page, estes contém, em sua maioria, esperas implícitas que lidam seguindo as boas práticas, com possíveis erros de sincronismo. 
- **BasePage:** classe que instancia o utils e é herdada pelas pages, como forma de otimizar a utilização dos métodos genéricos em qualquer parte da aplicação
- **BaseTest:** utilizada para garantir que o browser seja fechado depois das execuções, mesmo que haja erros nos steps de teste.
- **DriverOptions:** classe que define as opções de utilização do browser, ou seja, qual browser será utilizado para rodar os testes. Default é chrome
- **DriverFactory:** utilizada para gerenciar instanciamento e fechamento do browser

Já as features estão sob resources/features/ e organizadas segundo as páginas da aplicação. Vale reforçar que as boas práticas na escrita das features foram seguidas, entre elas atomicidade dos steps, reaproveitamento de steps através do background e utilização de parametrização quando foi necessário testar mais de uma entrada e saída.

Os steps estão em test/java/steps e também procurou-se manter legibilidade como boa prática. Os steps utilizam hooks do cucumber (Before e After) para gerenciar a instaciação e fechamento do browser.

Os testes realizados foram em My View, View Issues e Report Issues, já que trata-se de uma aplicação que gerencia inconsistências. Ou seja, nestas páginas estão as principais funcionalidades do sistema a ser testado.

Por fim, as pages estão em test/java/pages e também seguem a organização de páginas do sistema.

O relatório gerado com a execução dos testes pode ser acessado em target/HtmlReports/

### Pontos de melhoria

1. Os dados utilizados nos testes estão hard code, o que pode ser melhorado através de uma fonte de dados externa. Separando os dados dos testes facilita-se a manutenção e aumenta-se a resiliência dos testes, já que podem ser mais facilmente mudados se o sistema sofrer mudanças. Essa abordagem é conhecida como Data Driven Testing e pode ser implementada futuramente.

2. Adicionar a possibilidade de testagem em paralelo utilizando o SeleniumGrid para otimizar a execuçãos dos testes. Dada a complexidade do projeto, essa configuração não foi prioridade.

3. Adicionar loggers e melhorias para possíveis exceções que podem surgir.
