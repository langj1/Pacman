**Aihe:** Pacman peli. Toteutetaan klassinen pacman peli pienillä lisäyksillä
 ja muutoksilla. Peli muodostuu käytävistä, jotka ovat aluksi täynnä kerättäviä
 esineitä. Pelin tavoitteena on kerätä nämä kaikki esineet ilman, että osuu monsteriin.
 Aina välillä kentälle syntyy power uppeja joiden keräämisestä tapahtuu jotain.
 Esimerkiksi näkökenttä pienenee, pacmanin nopeus muuttuu tai pacman voi syödä monstereita tietyn ajan. Lisäksi pelin alussa
 pelaajalla on 2 pacmania joita liikutetaan eri näppäimillä. Kumpikaan ei saa
 osua monsteriin. Power upit vaikuttavat molempiin pacmaneihin. 

**Käyttäjät:**Pelaaja

**Kaikkien käyttäjien toiminnot:**
* Pelin käynnistäminen
* Tason valitseminen
  * Jos enemmän kuin yksi, muut aluksi lukittuja
* Pelaaminen
* Ennätysten tarkistaminen
* Pelin sammutus

**Rakenne kuvaus:**
Main käynnistää ohjelman luomalla käyttöliittymän, joka saa parametrinaa Pelin, joka saa parametrinaan Kentän. Käyttöliittymä käyttää myös näppäimstönkuuntelijaa sekä Piirtoalustaa. Pelin toiminta pyörii Peli luokan ympärillä. Peli luokka luo Pacmanin ja neljä monsteria saamansa Tason avulla. Peli käyttää Tormaako luokka törmäyksien tarkistamisessa.

**Luokkakaavio:**

![Luokkakavio](/dokumentaatio/Kaaviot/Luokkakaavio.png)

**Sekvenssikaavio:** Pacman liikkuu

![Sekvenssikaavio](/dokumentaatio/Kaaviot/Sekvenssikaavio1.png)

**Sekvenssikaavio:** Resetointi

![Sekvenssikaavio](/dokumentaatio/Kaaviot/Sekvenssikaavio2.png)
