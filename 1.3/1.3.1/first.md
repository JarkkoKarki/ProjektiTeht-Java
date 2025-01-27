(W) Suppose you are compiling statistics on the age structure of students in our group. You should then draw 1000 age values and these should be distributed in the same way as the age distribution of the students in the group. How do you do it? Explain the algorithm in enough details to be able to program it directly. Take an idea/model from the example on section Your own distribution.



 <br>

Ensin Valitsen ikä jakauman millä ikä välillä opiskelijat ovat. Tämä olisi helposti laskettavissa kun kysytään jokaisen opiskelijan ikä ja lasketaan prosentti osuudet jokaiselle iälle luokassa. Prosenttiosuuksien löytämisen jälkeen lisätään ne joukkoon ja iteroidaan 1000 kertaa satunnaisluku, joka osuu eri arvoille joukossa. 