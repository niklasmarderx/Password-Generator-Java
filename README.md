# Java Passwort-Generator

Ein sicherer Passwort-Generator in Java, der kryptographisch sichere Zufallszahlen verwendet.

## Funktionen

- Generiert sichere Passwörter mit konfigurierbarer Länge
- Unterstützt verschiedene Zeichentypen:
  - Großbuchstaben (A-Z)
  - Kleinbuchstaben (a-z)
  - Zahlen (0-9)
  - Sonderzeichen (!@#$%^&*...)
- Benutzerfreundliche Konsolenoberfläche
- Mindestlänge von 8 Zeichen für Sicherheit
- Verwendet `SecureRandom` für kryptographisch sichere Zufallszahlen

## Verwendung

1. Kompilieren Sie die Datei:
```bash
javac PasswordGenerator.java
```

2. Führen Sie das Programm aus:
```bash
java PasswordGenerator
```

3. Folgen Sie den Anweisungen auf dem Bildschirm:
   - Geben Sie die gewünschte Passwortlänge ein
   - Wählen Sie die gewünschten Zeichentypen

## Sicherheit

- Verwendet `SecureRandom` für kryptographisch sichere Zufallszahlen
- Mindestlänge von 8 Zeichen
- Mindestens ein Zeichentyp muss ausgewählt werden
- Keine Speicherung der generierten Passwörter

## Lizenz

MIT License 