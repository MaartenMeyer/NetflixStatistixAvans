USE master
DROP DATABASE IF EXISTS NetflixStatistix
CREATE DATABASE NetflixStatistix;
GO
USE NetflixStatistix;

CREATE TABLE Abonnement(
AbonnementId int NOT NULL PRIMARY KEY,
Naam nvarchar(40) NOT NULL,
Straat nvarchar(40) NOT NULL,
Huisnummer nvarchar(6) NOT NULL,
Woonplaats nvarchar(40) NOT NULL
);

CREATE TABLE Profiel(
Profielnaam nvarchar(40) NOT NULL,
Geboortedatum date NOT NULL,
AbonnementId int CONSTRAINT Profiel_FK REFERENCES Abonnement(AbonnementId) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (Profielnaam, AbonnementId)
);

CREATE TABLE Programma(
ProgrammaId int NOT NULL,
Titel nvarchar(40) NOT NULL,
PRIMARY KEY(ProgrammaId, Titel)
);

CREATE TABLE Film(
FilmId int NOT NULL PRIMARY KEY,
ProgrammaId int NOT NULL,
Titel nvarchar(40) NOT NULL,
Taal nvarchar(40) NOT NULL,
LeeftijdsIndicatie int NOT NULL,
Tijdsduur int NOT NULL,
Genre nvarchar(40) NOT NULL,
FOREIGN KEY(ProgrammaId,Titel) REFERENCES Programma(ProgrammaId,Titel) ON DELETE CASCADE ON UPDATE CASCADE,
);

CREATE TABLE Serie(
Titel nvarchar(40) NOT NULL PRIMARY KEY,
LeeftijdsIndicatie int NOT NULL,
Taal nvarchar(40) NOT NULL,
Genre nvarchar(40) NOT NULL,
LijktOp nvarchar(40),          
);

CREATE TABLE Aflevering(
AfleveringID int NOT NULL PRIMARY KEY,
ProgrammaID int NOT NULL ,
Serie nvarchar(40) CONSTRAINT Serie_FK REFERENCES Serie(Titel) ON DELETE CASCADE ON UPDATE CASCADE,
Titel nvarchar(40) NOT NULL,		 	
Tijdsduur int NOT NULL,
FOREIGN KEY(ProgrammaID,Titel) REFERENCES Programma(ProgrammaID,Titel) ON DELETE CASCADE ON UPDATE CASCADE,
);

CREATE TABLE BekekenProgramma(
Percentage int NOT NULL,
Profielnaam nvarchar(40) NOT NULL,
AbonnementId int NOT NULL,
LaatstBekeken datetime NOT NULL,
ProgrammaId int NOT NULL,
Titel nvarchar(40) NOT NULL,
FOREIGN KEY(Profielnaam,AbonnementId) REFERENCES Profiel(Profielnaam,AbonnementId) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(ProgrammaId,Titel) REFERENCES Programma(ProgrammaId,Titel) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY(Profielnaam,AbonnementId,ProgrammaId)
);



INSERT INTO Programma (ProgrammaID, Titel)
VALUES 
('1001', 'A Study in Pink'),
('1002', 'The Blind Banker'),
('1003', 'The Great Game'),
('1004', 'A Scandal in Belgravia'),
('1005', 'The Hounds of Baskerville'),
('1006', 'The Reichenbach Fall'),
('1007', 'The Empty Hearse'),
('1008', 'The Sign of Three'),
('1009', 'His Last Vow'),
('2000', 'Pilot'),
('2001', 'Cat''s in the Bag...'),
('2002', '...And the Bag''s in the River'),
('2003', 'Cancer Man'),
('2004', 'Gray Matter'),
('2005', 'Crazy Handful of Nothin'''),
('2006', 'A No-Rough-Stuff-Type Deal'),
('2007', 'Seven Thirty-Seven'),
('2008', 'Grilled'),
('2009', 'Bit by a Dead Bee'),
('2010', 'Down'),
('2011', 'Breakage'),
('2012', 'Peekaboo'),
('2013', 'Negro Y Azul'),
('2014', 'Better Call Saul'),
('2015', '4 Days Out'),
('2016', 'Over'),
('2017', 'Mandala'),
('2018', 'Phoenix'),
('2019', 'ABQ'),
('3001', 'The Crocodile''s Dilemma'),
('3002', 'The Rooster Prince'),
('3003', 'A Muddy Road'),
('3004', 'Eating the Blame'),
('3005', 'The Six Ungraspables'),
('3006', 'Buridan''s Ass'),
('3007', 'Who Shaves the Barber?'),
('3008', 'The Heap'),
('3009', 'A Fox, a Rabbit, and a Cabbage'),
('3010', 'Morton''s Fork'),
('3101', 'Waiting for Dutch'),
('3102', 'Before the Law'),
('3103', 'The Myth of Sisyphus'),
('3104', 'The Gift of the Magi'),
('3105', 'Fear and Trembling'),
('3106', 'Rhinoceros'),
('3107', 'Did you do this? No, you did it!'),
('3108', 'Loplop'),
('3109', 'The Castle'),
('3110', 'Palindrome'),
('8001', 'The Life of Brian'),
('8002', 'Pulp Fiction'),
('8004', 'Pruimebloesem'),
('8008', 'Reservoir Dogs'),
('8010', 'The Good, the Bad and the Ugly'),
('8011', 'Andy Warhols Dracula'),
('8012', 'Ober'),
('8014', 'Der Untergang'),
('8016', 'De helaasheid der dingen'),
('8017', 'A Clockwork Orange');

INSERT INTO Film (FilmId, ProgrammaId, Titel, Taal, LeeftijdsIndicatie, Tijdsduur, Genre)
VALUES
('0001', '8001', 'The Life of Brian', 'Engels', '12', '94', 'Humor'),
('0002', '8002', 'Pulp Fiction', 'Engels-Amerikaans', '16', '154', 'Misdaad'),
('0003', '8004', 'Pruimebloesem', 'Nederlands', '18', '80', 'Erotiek'),
('0004', '8008', 'Reservoir Dogs', 'Engels-Amerikaans', '16', '99', 'Misdaad'),
('0005', '8010', 'The Good, the Bad and the Ugly', 'Engels-Amerikaans', '12', '161', 'Western'),
('0006', '8011', 'Andy Warhols Dracula', 'Engels-Amerikaans', '16', '101', 'Humor'),
('0007', '8012', 'Ober', 'Nederlands', '6', '97', 'Humor'),
('0008', '8014', 'Der Untergang', 'Duits', '16', '178', 'Oorlog'),
('0009', '8016', 'De helaasheid der dingen',  'Vlaams', '12', '108', 'Humor'),
('0010', '8017', 'A Clockwork Orange', 'Engels', '16', '136', 'Sci-Fi');

INSERT INTO Serie (Titel, LeeftijdsIndicatie, Taal, Genre, LijktOp) VALUES 
('Sherlock', '12', 'Engels', 'Detective', 'Fargo'),
('Breaking Bad', '16', 'Engels-Amerikaans', 'Spanning', 'Fargo'),
('Fargo', '16', 'Engels-Amerikaans', 'Spanning', 'Breaking Bad');

INSERT INTO Aflevering (AfleveringId, ProgrammaID, Serie, Titel, Tijdsduur) VALUES 
('0001', '1001', 'Sherlock', 'A Study in Pink', '88'),
('0002', '1002', 'Sherlock', 'The Blind Banker', '88'),
('0003', '1003', 'Sherlock', 'The Great Game', '88'),
('0004', '1004', 'Sherlock', 'A Scandal in Belgravia', '88'),
('0005', '1005', 'Sherlock', 'The Hounds of Baskerville', '88'),
('0006', '1006', 'Sherlock', 'The Reichenbach Fall', '88'),
('0007', '1007', 'Sherlock', 'The Empty Hearse', '88'),
('0008', '1008', 'Sherlock', 'The Sign of Three', '88'),
('0009', '1009', 'Sherlock', 'His Last Vow', '88'),

('0101', '2000', 'Breaking Bad', 'Pilot', '58'),
('0102', '2001', 'Breaking Bad', 'Cat''s in the Bag...', '48'),
('0103', '2002', 'Breaking Bad', '...And the Bag''s in the River', '48'),
('0104', '2003', 'Breaking Bad', 'Cancer Man', '48'),
('0105', '2004', 'Breaking Bad', 'Gray Matter', '48'),
('0106', '2005', 'Breaking Bad', 'Crazy Handful of Nothin''', '48'),
('0107', '2006', 'Breaking Bad', 'A No-Rough-Stuff-Type Deal', '48'),
('0108', '2007', 'Breaking Bad', 'Seven Thirty-Seven', '48'),
('0109', '2008', 'Breaking Bad', 'Grilled', '48'),
('0110', '2009', 'Breaking Bad', 'Bit by a Dead Bee', '48'),
('0111', '2010', 'Breaking Bad', 'Down', '48'),
('0112', '2011', 'Breaking Bad', 'Breakage', '48'),
('0113', '2012', 'Breaking Bad', 'Peekaboo', '48'),
('0114', '2013', 'Breaking Bad', 'Negro Y Azul', '48'),
('0115', '2014', 'Breaking Bad', 'Better Call Saul', '48'),
('0116', '2015', 'Breaking Bad', '4 Days Out', '48'),
('0117', '2016', 'Breaking Bad', 'Over', '48'),
('0118', '2017', 'Breaking Bad', 'Mandala', '48'),
('0119', '2018', 'Breaking Bad', 'Phoenix', '48'),
('0120', '2019', 'Breaking Bad', 'ABQ', '48'),

('0201', '3001', 'Fargo', 'The Crocodile''s Dilemma', '68'),
('0202', '3002', 'Fargo', 'The Rooster Prince', '68'),
('0203', '3003', 'Fargo', 'A Muddy Road', '68'),
('0204', '3004', 'Fargo', 'Eating the Blame', '68'),
('0205', '3005', 'Fargo', 'The Six Ungraspables', '68'),
('0206', '3006', 'Fargo', 'Buridan''s Ass', '68'),
('0207', '3007', 'Fargo', 'Who Shaves the Barber?', '68'),
('0208', '3008', 'Fargo', 'The Heap', '68'),
('0209', '3009', 'Fargo', 'A Fox, a Rabbit, and a Cabbage', '68'),
('0210', '3010', 'Fargo', 'Morton''s Fork', '68'),
('0211', '3101', 'Fargo', 'Waiting for Dutch', '68'),
('0212', '3102', 'Fargo', 'Before the Law', '68'),
('0213', '3103', 'Fargo', 'The Myth of Sisyphus', '68'),
('0214', '3104', 'Fargo', 'The Gift of the Magi', '68'),
('0215', '3105', 'Fargo', 'Fear and Trembling', '68'),
('0216', '3106', 'Fargo', 'Rhinoceros', '68'),
('0217', '3107', 'Fargo', 'Did you do this? No, you did it!', '68'),
('0218', '3108', 'Fargo', 'Loplop', '68'),
('0219', '3109', 'Fargo', 'The Castle', '68'),
('0220', '3110', 'Fargo', 'Palindrome', '68');
