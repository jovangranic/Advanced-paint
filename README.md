## Advanced paint
Ovaj projekat predstavlja naprednu paint aplikaciju za manipulaciju 2D oblika, sa podrškom za čuvanje i učitavanje crteža i logova. 
## Opis projekta
Advanced Paint je desktop aplikacija razvijena koristeći Java Swing, koja omogućava rad sa 2D grafikom. Projekat je kreiran u okviru predmeta "Dizajnerski zadaci za 2023/2024" i implementira različite dizajnerske obrasce i funkcionalnosti za upravljanje grafikom.

### Glavne funkcionalnosti
*Crtanje oblika*: Omogućava crtanje različitih oblika kao što su krugovi, pravougaonici i šestouglovi, koristeći različite boje za ivice i unutrašnjost. Za boje se koristi JColorChooser klasa.

*Transparentnost*: Unutrašnjost kruga može biti transparentna, koristeći klase kao što su Graphics2D, Shape, Area, i Ellipse2D.

*MVC Arhitektura*: Projekat koristi Model-View-Controller (MVC) arhitektonski obrazac za odvajanje podataka, korisničkog interfejsa i logike aplikacije.

*Hexagon Adapter*: Implementacija za dodavanje, brisanje i modifikaciju šestougla koristeći Adapter obrazac za hexagon.jar.

*Undo/Redo funkcionalnosti*: Implementirane koristeći Command i Prototype obrasce. Poništavanje i ponovno izvršenje komandi su dostupni samo kada je funkcionalnost aktivna.

*Logovanje i čuvanje*: Generisanje i prikaz loga izvršenih komandi u aplikaciji. Zapis komandi i celokupnog crteža u tekstualne datoteke na eksternom memorijskom medijumu koristeći Strategy obrazac.

*Menjanje pozicije*: Promena pozicije oblika po Z osi uz opcije "To Front", "To Back", "Bring To Front" i "Bring To Back".

*Selektovanje više oblika*: Omogućava selektovanje više oblika i pristup opcijama kao što su brisanje ili modifikacija, u zavisnosti od broja selektovanih objekata.

*Dizajnerski obrasci*: Korišćeni dizajnerski obrasci uključuju Command, Prototype, Observer i Strategy.

### Uputstvo za instalaciju:
-Klonirajte repozitorijum: git clone <url>
-Uđite u direktorijum projekta: cd <naziv-direktorijuma>
-Pokrenite aplikaciju koristeći IDE kao što je IntelliJ IDEA ili Eclipse.

# Korišćenje aplikacije
Pokrenite aplikaciju i koristite alatke za crtanje u meniju za kreiranje i modifikaciju oblika.
Za promenu boja i drugih karakteristika, koristite odgovarajuće dijaloge i dugmadi u korisničkom interfejsu.
Koristite dugmad za Undo/Redo za povratak na prethodne akcije ili ponavljanje prethodnih akcija.

