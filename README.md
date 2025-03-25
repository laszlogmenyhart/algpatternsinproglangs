# algpatternsinproglangs
Algorithm patterns in programming languages

## Absztrakt

A módszeres programozás oktatásának alapja az algoritmus minták megismerése. Korábban programozási tételeknek neveztük őket, hiszen bizonyítottan helyes és hatékony megoldásokat szolgáltatnak egyes típusfeladatok megoldására. Ezek ma már a legtöbb programozási nyelvben megjelennek valahogyan megvalósítva alap vagy kiegészítő függvénykönyvtárakban. Cikkünkben (most előadásunkban) azt járjuk körbe, hogy ezek miben hasonlítanak és miben térnek el az egyes programozási környezetekben. Hatékonyságukat vizsgáljuk a futásuk, a kód szintaxis megértésének és oktatási (elmagyarázási) szempontok szerint. Kitekintünk a további módosításuk és összeépítésük felé is. Vajon melyiket ajánlja *a mesterséges intelligencia*? El tudja magyarázni a kódok közti különbséget?

# Bevezetés


# A feladat

Ismerjük egy részvény napi átlagárait forintban egész számként az előző N napból és mindegyik napon az aktuális HUF/EUR árfolyamot is.
Írj programot, ami segít analizálni az adatokat!
a) Volt-e pontosan 42 forint a részvény ára? (eldöntés)
b) Hány napja volt pontosan 100 forint a részvény ára? (Tudjuk, hogy volt ilyen nap.) (kiválasztás)
c) Hányszor volt 85 forint felett a napi átlagár? (megszámolás)
d) Mekkora a részvény teljes átlagára (egészre kerekítve) az ismert napokat számolva? (összegzés, sorozatszámítás)
e) Mennyi volt a legmagasabb ár? (maximum-kiválasztás)
f) Add meg a részvény napi átlagárait eurócentben (ár/eurárfolyam*100 kerekítve [lefelé])! [felsorolva egymás mellett] (másolás)
g) Mely napokon volt az euró árfolyama nagyobb, mint 90? [darab indexek listája formátumban] (kiválogatás)
 
Bemenet

```
5 [N: utolsó 5 nap adatait ismerjük]
82 385 [tegnapi adatok: a részvény napi átlagára és az euró árfolyma]
100 415 [tegnapelőtti adatok]
42 400 [3 nappal ezelőtti adatok]
90 405 [stb...]
86 399
```


Kimenet

```
IGEN
2
3
80
100
21 24 10 22 21
1 2
```


# Megoldások
Ennek az egyszerű feladatnak a megoldásai egyszerűen, összeépítés nélküli algoritmus mintákkal megoldhatóak.

Ugyanakkor több féle gondolkodással és szintaxissal jelennek meg ezek a megoldások az egyes progamozási nyelvekben.



## Programozási nyelvek

### Python

### Java

### C#

### C++

### Delphi / Pascal



# Összehasonlítás

## Hatékonyság

### Futás

#### Mérés

### Kód megértés


### Kód elmagyarázás

## Mesterséges intelligencia (ChatGPT)

