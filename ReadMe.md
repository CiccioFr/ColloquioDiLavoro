# Colloquio Di Lavoro

Applicazione Desktop che simula la candidatura ad una posizione lavorativa di Developer, e pone al candidato alcune domande sul linguaggio di programmazione scelto
## Caratteristiche principali dell'applicazione
- Java ver. 17
- Build System: Ant
- libreria Swing
- lettura e scrittura di file di testo

## Particolarità tecniche
- Pattern Singleton (per la scrittura su file)
- record class
- Enum con:
    - costruttore e metodi
    - inizializzazione statica delle Enum Costant
- `.stream()`, 

## Struttura
Package rott: src.main.java.cicciofr.colloquioDiLavoro  
```
├─ pom.xml  
├─ src  
    ├─ main  
    │   ├─ frontend  
    │   ├─ java  
    │   │   └─ com  
    │   │       └─ baeldung  
    │   │           └─ ecommerce  
    │   │               │   EcommerceApplication.java  
    │   │               ├─ controller   
    │   │               ├─ dto    
    │   │               ├─ exception  
    │   │               ├─ model  
    │   │               ├─ repository  
    │   │               └─ service  
    │   │                         
    │   └─ resources  
    │       │   application.properties  
    │       ├─ static  
    │       └─ templates  
ColloquioDiLavoro.java  (main)
```