# Activité Pratique N°1 — Injection des dépendances
 
## Objectif
 
Mettre en pratique le **couplage faible** et l'**inversion de contrôle (IoC)** en Java : une couche métier qui dépend d'une interface d'accès aux données et non d'une classe concrète. L'activité compare plusieurs manières d'injecter la dépendance, de la plus manuelle à la plus automatisée avec le framework Spring.
 
## Architecture
 
```
src/main/java/net_info
├── dao
│   ├── IDao.java          Interface : double getData()
│   └── DaoImpl.java       Implémentation « base de données » (@Component("d"))
├── ext
│   └── DaoImplV2.java     Implémentation « capteurs » (@Component("d2"))
├── metier
│   ├── IMetier.java       Interface : double calcul()
│   └── MetierImpl.java    Logique métier, dépend de IDao (@Component("metier"))
└── pres
    ├── Pres1.java               Injection statique
    ├── Pres2.java               Injection dynamique (réflexion + config.txt)
    ├── PresSpringXML.java       Spring, configuration XML
    └── PresSpringAnnotation.java Spring, annotations
src/main/resources/config.xml    Déclaration des beans pour la version XML
config.txt                       Noms de classes lus par la version dynamique
```
 
Le calcul métier est `t * 2 + (t * t) / 3`, où `t` est la valeur renvoyée par la couche DAO.
 
## Les quatre modes d'injection
 
| Classe | Technique | Principe |
|---|---|---|
| `Pres1` | Instanciation statique | Les objets sont créés avec `new` dans le code, puis injectés par le constructeur. |
| `Pres2` | Instanciation dynamique | Les noms de classes sont lus dans `config.txt`, puis les objets sont créés par réflexion (`Class.forName`). Changer d'implémentation ne demande pas de recompiler. |
| `PresSpringXML` | Spring, version XML | Les beans et leurs dépendances sont déclarés dans `config.xml`, chargé par `ClassPathXmlApplicationContext`. |
| `PresSpringAnnotation` | Spring, version annotations | Les classes portent `@Component`, la dépendance est choisie avec `@Qualifier`, et le contexte scanne le package avec `AnnotationConfigApplicationContext`. |
 
## Prérequis
 
- JDK (version définie dans le `pom.xml`)
- Maven
- Dépendances Spring : `spring-core`, `spring-beans`, `spring-context`, `spring-expression`
## Exécution
 
Compiler le projet :
 
```bash
mvn clean compile
```
 
Puis lancer l'une des quatre classes `main` depuis l'IDE (clic droit > Run), ou en ligne de commande. Pour changer l'implémentation du DAO :
 
- version dynamique : modifier la première ligne de `config.txt` ;
- version XML : modifier la classe du bean `d` dans `config.xml` ;
- version annotations : modifier la valeur de `@Qualifier` dans `MetierImpl`.
## Concepts illustrés
 
- Couplage fort et couplage faible
- Programmation par interfaces
- Inversion de contrôle et injection des dépendances
- Réflexion Java
- Conteneur Spring (`ApplicationContext`), beans, `@Component`, `@Qualifier`
