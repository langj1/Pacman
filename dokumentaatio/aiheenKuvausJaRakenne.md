**Aihe:** Pacman peli. Toteutan oman versioni klassisesta pacman pelistä. Peli muodostuu käytävistä, jotka ovat aluksi täynnä kerättäviä pisteitä. Pelin tavoitteena on kerätä nämä kaikki pisteet ilman, että osuu monstereihin.
Kentällä on neljä Power Uppia, joiden syömisen jälkeen pacman voi syödä monstereita hetkellisesti. 

**Käyttäjät:**Pelaaja

**Kaikkien käyttäjien toiminnot:**
* Pelin käynnistäminen
* Pelaaminen
* Pelin sammutus

**Rakenne kuvaus:**
Main käynnistää ohjelman luomalla käyttöliittymän, joka saa parametrinaa Pelin, joka saa parametrinaan Kentän. Käyttöliittymä käyttää myös näppäimstönkuuntelijaa sekä Piirtoalustaa. Pelin toiminta pyörii Peli luokan ympärillä. Peli luokka luo Pacmanin ja neljä monsteria saamansa Tason avulla. Peli käyttää Tormaako luokka törmäyksien tarkistamisessa ja Liikuttaja olioiden liikuttamiseen.

**Luokkakaavio:**

![Luokkakavio](/dokumentaatio/Kaaviot/Luokkakaavio.png)

**Sekvenssikaavio:** Pacman liikkuu

![Sekvenssikaavio](/dokumentaatio/Kaaviot/Sekvenssikaavio1.png)

**Sekvenssikaavio:** Resetointi

![Sekvenssikaavio](/dokumentaatio/Kaaviot/Sekvenssikaavio2.png)
