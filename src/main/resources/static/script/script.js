function loadContent(url) {
  fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.text();
    })
    .then(data => {
      document.querySelector('.col-7').innerHTML = data;
    })
    .catch(error => {
      console.error('There has been a problem with your fetch operation:', error);
    });
}
