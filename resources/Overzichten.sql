/*
1
*/

--2

/*
3
*/
SELECT DISTINCT Film.*
FROM Film
INNER JOIN BekekenProgramma
ON BekekenProgramma.ProgrammaId = Film.ProgrammaId
INNER JOIN Abonnement
ON Abonnement.AbonnementId = BekekenProgramma.AbonnementId
INNER JOIN Profiel
ON Profiel.AbonnementId = Abonnement.AbonnementId
WHERE Abonnement.AbonnementId = '1';

/*
4
*/
SELECT TOP 1 * FROM Film 
WHERE Leeftijdsindicatie < 16 
ORDER BY Tijdsduur DESC;

/*
5
*/
SELECT * FROM Abonnement
WHERE EXISTS
(SELECT AbonnementId FROM profiel
WHERE Profiel.AbonnementId = Abonnement.AbonnementId
GROUP BY Profiel.AbonnementId
HAVING COUNT(Profiel.Profielnaam) = 1)



/*
6
*/

SELECT Film.Titel, COUNT(BekekenProgramma.Percentage)
FROM Film
INNER JOIN Programma
ON Programma.ProgrammaId = Film.ProgrammaId
INNER JOIN BekekenProgramma
ON BekekenProgramma.ProgrammaId = Film.ProgrammaId
WHERE Programma.Titel = 'Der Untergang'
GROUP BY Film.Titel, BekekenProgramma.Percentage, Programma.Titel
HAVING BekekenProgramma.Percentage = 100

