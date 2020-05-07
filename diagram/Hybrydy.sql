CREATE TABLE `Ksiazka` (
  `id_ksiazki` integer PRIMARY KEY,
  `autorzy` varchar2,
  `tytul` varchar2,
  `rok_wydania` datetime
);

CREATE TABLE `Wypozyczenia` (
  `id_wypozyczenia` integer PRIMARY KEY,
  `id_uzytkownika` integer,
  `id_ksiazki` integer
);

CREATE TABLE `Uzytkownik` (
  `id_uzytkownika` integer PRIMARY KEY,
  `login` varchar2,
  `password` varchar2,
  `id_roli` integer
);

CREATE TABLE `Role` (
  `id_roli` integer,
  `rola` varchar2
);

ALTER TABLE `Wypozyczenia` ADD FOREIGN KEY (`id_uzytkownika`) REFERENCES `Uzytkownik` (`id_uzytkownika`);

ALTER TABLE `Uzytkownik` ADD FOREIGN KEY (`id_roli`) REFERENCES `Role` (`id_roli`);

ALTER TABLE `Ksiazka` ADD FOREIGN KEY (`id_ksiazki`) REFERENCES `Wypozyczenia` (`id_ksiazki`);
