# sew9-2324-worttrainer-jbekhet
# Worttrainer


Die Worttrainer-Anwendung ist besonders für Grundschulkinder geeignet. Die Schüler können erraten, was das Wort des aktuell angezeigten Bildes ist und am Ende haben sie eine Statistik, bei der sie sehen können wie viele falsch, richtig und wie Bilder es insgesamt sind. Die Anwendung ist in Java geschrieben und die Ergebnisse werden in dem save.json file abgespeichert. Des weiteren wurde die Anwendung mit Gradle erstellt.

# Starten der Anwendung

Es gibt 2 Möglichkeiten um die Anwendung zu starten. Entweder führt starten man diese über seiner IDE, oder man gibt einfach den Befehl `gradle run` ein.

## Struktur

Der Worttrainer besteht aus 4 packages:

- Controller

- Grafische Oberfläche

- Model

- Persistenz


## Controller

Der Controller führt das ganze Programm aus und ist dafür da um ebenfalls die GUI zu starten.

Er beinhaltet die Klasse `TrainerController` in der eine main-Methode ausgeführt wird, welche die Anforderungen von oben beschreibt.

## Grafische Oberfläche

Die Grafische Oberfläche kümmert sich um die ganze GUI (graphical user interface). Dieses Package beinhaltet die Klasse `Trainer GUI`.

### TrainerGUI Klasse

**Funktionen**

Die Kernfunktionen der `TrainerGUI`-Klasse umfassen:

- Anzeige zufälliger Wort-Einträge aus einer übergebenen Wortliste.
- Anzeige der Bilder, die mit den Wörtern verknüpft sind, wobei die Bilder von URLs geladen werden.
- Aufforderung des Benutzers zur Eingabe des entsprechenden Wortes.
- Überprüfung der Benutzereingabe, gefolgt von der Anzeige von Rückmeldungen über die Korrektheit der Eingabe und statistischen Informationen zum Trainingsfortschritt.

Die Schleife in der `start`-Methode ermöglicht es dem Benutzer, das Training so lange fortzusetzen, wie gewünscht.

## Model

Das `Model` Package enthält drei Java-Klassen: `WortEintrag`, `WortListe` und `WortTrainer`, die gemeinsam zur Verwaltung und zum Training von Wörtern und Bildern verwendet werden können.

### WortEintrag Klasse

**Funktionalität**

- Die Klasse `WortEintrag` repräsentiert einen Wort-Eintrag, der aus einem Wort und einer URL für ein Bild besteht.
- Sie verfügt über Konstruktoren zum Erstellen von Wort-Einträgen, die sowohl das Wort als auch die URL erfordern.
- Es werden Validierungsmethoden angeboten, um sicherzustellen, dass die URL gültig ist und den Anforderungen entspricht.
- Getter- und Setter-Methoden ermöglichen den Zugriff auf die Werte von Wort und URL.
- Die Methode `toString` ermöglicht die übersichtliche Darstellung eines Wort-Eintrags.

## WortListe Klasse

**Funktionalität:**

- Die Klasse `WortListe` verwaltet eine Liste von Wort-Einträgen (`WortEintrag`-Objekten).
- Sie bietet Konstruktoren zum Erstellen einer Wortliste, die bereits einige vordefinierte Wort-Einträge enthält.
- Sie ermöglicht das Hinzufügen von neuen Wort-Einträgen zur Liste, wobei Duplikate vermieden werden.
- Die Methode `ausgabe` gibt einen spezifischen Wort-Eintrag anhand seines Index zurück.
- Es gibt eine Methode zum Löschen von Wort-Einträgen aus der Liste.
- Die Methode `toString` gibt die gesamte Wortliste übersichtlich aus.
- Die Methode `leange` gibt die Anzahl der Wort-Einträge in der Liste zurück.

## WortTrainer Klasse

**Funktionalität:**

- Die Klasse `WortTrainer` ermöglicht das Training und die Überprüfung von Wörtern.
- Sie kann auf eine `WortListe` zugreifen, um zufällige Wort-Einträge für das Training auszuwählen.
- Es werden Methoden bereitgestellt, um die Eingaben des Benutzers auf Übereinstimmung mit den Wort-Einträgen zu überprüfen.
- Der Trainingsfortschritt (richtige und falsche Antworten) wird verfolgt und kann abgerufen werden.
- Die Methode `getStatistik` gibt eine Zusammenfassung der Trainingsergebnisse zurück.
- Es gibt auch Methoden zum Hinzufügen einer gesamten `WortListe` und zum Festlegen des aktuellen Wort-Eintrags.
- Zusätzlich können Sie den Fortschritt zurücksetzen und bestimmte Informationen abrufen.

## Persistenz

Das `Persistenz` Package enthält das Interface `Persistenz` und die Klasse `SpeichernUndLaden`, die für die Speicherung und das Laden von Trainingsstatistiken im Zusammenhang mit dem `WortTrainer` verwendet werden.

## Persistenz Interface

**Funktionalität:**

- Das `Persistenz` Interface definiert zwei Methoden, `speichern` und `laden`, die verwendet werden, um Trainingsstatistiken des `WortTrainers` zu speichern und wiederherzustellen.

## SpeichernUndLaden Klasserr

**Funktionalität:**

- Die `SpeichernUndLaden` Klasse implementiert das `Persistenz` Interface und bietet die Funktionalität zum Speichern und Laden von Trainingsstatistiken in JSON-Dateien.

### Methode `speichern`:

- Diese Methode speichert die Statistiken eines `WortTrainers` in eine JSON-Datei.
- Sie erstellt ein JSON-Objekt, das Informationen wie die Anzahl der richtigen und falschen Antworten, die Anzahl der abgefragten Wörter und den aktuellen Index des Wort-Trainers enthält.
- Das JSON-Objekt wird in eine JSON-Datei mit dem Namen "save.json" geschrieben.

### Methode `laden`:

- Diese Methode lädt die gespeicherten Statistiken aus der JSON-Datei "save.json" zurück in einen `WortTrainer`.
- Sie erstellt ein neues `WortTrainer`-Objekt und setzt die geladenen Statistiken entsprechend.
- Falls keine Datei vorhanden ist, wird eine Ausnahme ausgelöst.

Diese Klassen und Methoden ermöglichen die Speicherung und das Laden von Trainingsfortschritten des `WortTrainers`, was besonders nützlich ist, um Benutzerdaten zwischen Trainingssitzungen zu persistieren und den Fortschritt der Benutzer zu verfolgen.




