# TOC-Lite: CIVOPS Tactical Operations Simulator

Lightweight Tactical Operations Center (TOC) simulation for civilian coordination efforts — built in Java.

TOC-Lite is a modular, CLI-based command hub for mission coordination, tracking, and planning. Originally designed to support grid-based ops and search-and-rescue scenarios, it's built for expansion into larger tactical or humanitarian planning systems.

---

Features

Grid-based mission map
Add and manage markers and units
Mission log system with live updates
Resource tracking (medkits, fuel, food, etc.)
`status` command displays all mission data
Modular codebase for easy expansion

---

Example Commands


map create 10x10
marker add AlphaZone 2 3
unit add EchoTeam MEDIC 4 5
log EchoTeam entering AlphaZone
resource update medkits 12
status

---

## Building and Running

Ensure you have a Java Development Kit (JDK 8 or later) installed.

Compile all source files from the repository root using the provided script:

```bash
./build.sh
```

Then start the simulator:

```bash
java Main
```

Type `exit` to close the application.
