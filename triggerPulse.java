function triggerPulse() {
  clearPulseTimeouts();
  
  // Force browser reflow to reset animation
  elements.watch.classList.remove('pulse');
  void elements.watch.offsetWidth;  // Browser reflow
  elements.watch.classList.add('pulse');
  
  // Proper timeout management
  pulseTimeouts.push(
    setTimeout(() => elements.watch.classList.remove('pulse'), CONFIG.PULSE_DURATION)
  );
  
  // Double pulse with clean nested timeouts
  if (elements.doubleBeat.checked) {
    pulseTimeouts.push(
      setTimeout(() => { /* second pulse */ }, CONFIG.DOUBLE_BEAT_DELAY)
    );
  }
}
