(W) Write an algorithm in Java or pseudocode for the main loop of the simulator:
The main loop does all the things required for a three-phase simulation (presented in a section).
Think in general terms (don't think in detail) and present a general solution. No need for target system concepts.



```
initializeSimulation();  // 1. Alustus

while (!simulationFinished) { // 2. Simulaatio
    processNextEvent();
    updateSimulationTime();
    updateSystemState();
    collectStatistics(); // Kerätään tulokset
}
finalizeSimulation(); // 3. viimeistely ja tuloksien näyttäminen




```