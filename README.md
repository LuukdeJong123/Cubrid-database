# Cubrid-database
Dit is ons groepsproject voor Data Processing.

Als u Cubrid wilt gebruiken voor eigen gebruik moet je deze stappen volgen om Cubrid te kunnen gebruiken.
Stap 1: Download de Cubrid engine en manager
Download de Cubrid Engine en Cubrid Manager. 
https://www.cubrid.org/downloads/os-select/64-bit/engine
https://www.cubrid.org/downloads/os-select/64-bit/tools/manager

Stap 2: Opstarten 
Je kan nu de Cubrid manager starten.
Let op dat je de Cubrid Workspace gebruikt die automatisch wordt aangesteld bij het opstarten.
Stap 3: Modes

Je hebt 2 modes in Cubrid manager mode en query mode. Bij de eerste opstart wil je beginnen met de manager mode daar kan je nieuwe connecties maken. De connectie “Localhost” zou er moeten staan. 
Stap 4: Bestaande User

We gaan in de al bestaande localhost inloggen om en een nieuw host aan te maken moet je een server hebben en dat is ons niet gelukt. Je klikt op localhost en dan krijg je een inlog scherm zoals dit:
Zorg ervoor dat de JDBC versie de nieuwste is die kan je hier downloaden:
https://www.cubrid.org/downloads/windows/64-bit/drivers/jdbc

Stap 5: Nieuwe database
We gaan een nieuwe database aanmaken. Rechter muisknop op de databases van localhost. Je klikt dan op “create database”. Maak een wachtwoord aan dat je niet makkelijk vergeet. Volg de stappen die er zijn en daarna is je database aangemaakt.

Stap 6: Vul je database met data.
Als het goed is heb je de create OV-database al en vul OV database al gedownload voor data processing zelf. De create database moet je overnemen door op tabellen te klikken en daarna “Create Table”. Hier kan je de naam, data typen en primary/foreign keys aangeven.


Stap 7: Maak query’s
Je kan nu Cubrid gebruiken en informatie er in opslaan.
