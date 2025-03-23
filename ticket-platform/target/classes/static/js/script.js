function updateColor() {
        
        const selectElement = document.getElementById('state');
        
   
        const selectedValue = selectElement.value;
        
       
        selectElement.classList.remove('to-do', 'in-progress', 'completed');
        
      
        if (selectedValue === 'TO_DO') {
            selectElement.classList.add('to-do')
        } else if (selectedValue === 'IN_PROGRESS') {
            selectElement.classList.add('in-progress')
        } else if (selectedValue === 'COMPLETED') {
            selectElement.classList.add('completed')
        }
    
    // Applica il colore iniziale al caricamento della pagina
    updateColor();

    // Aggiunge un listener per aggiornare il colore quando cambia lo stato
    selectElement.addEventListener('change', updateColor);
    }