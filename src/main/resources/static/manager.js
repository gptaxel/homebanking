const { createApp } = Vue;

const options = {
  data() {
    return {
      firstName: '',
      lastName: '',
      clientEmail: '',
      clients: [], // Aquí se almacenará la lista de clientes obtenida desde el servicio REST
      newClient: { name: '', lastName: '', email: '' }, // Aquí se almacenará el nuevo cliente que se agregará al servicio REST
      jsonResponse: null, // Aquí se almacenará el JSON de la respuesta del servicio REST
    };
  },

  created() {
    this.loadData();
  },

  methods: {
    
    loadData() {
      axios.get('http://localhost:8080/clients')
        .then(response => {
          this.clients = response.data._embedded.clients;
          console.log(this.clients);
          this.jsonResponse = JSON.stringify(response.data._embedded.clients, null, 2);
          console.log(response.data._embedded.clients)
        })
        .catch(error => {
          console.error('Error al cargar los clientes:', error);
        });
    },
    addClient() {
      if (this.newClient.firstName && this.newClient.lastName  && this.newClient.clientEmail) {
        this.postClient();
      }
    },
    //postClient: obtiene los datos del nuevo cliente usando AJAX (peticiones asíncronas) al back-end o servicio REST.
    postClient() {
      axios.post('http://localhost:8080/clients', this.newClient)
        .then(() => {
          this.loadData();
          this.newClient = { firstName: '', lastName: '', clientEmail: '' }; // Limpiar el formulario después de agregar el cliente
          console.log(this.newClient);
        })

        .catch(error => {
          console.error('Error al agregar el cliente:', error);
        });
    },


    //Realiza una petición HTTP de tipo POST a la URL /clients con la librería axios.

    // Cuando la petición es respondida se ejecuta el método then

    //El método then ejecuta la función loadData para que se recargue la información en la página.



  },
};

const app = createApp(options);
app.mount('#app');





//El objeto "response.data" es la respuesta de una solicitud HTTP que contiene datos en formato JSON. 
//El atributo "_embedded" es una convención utilizada en el formato HAL (Hypertext Application Language) para incluir 
//recursos relacionados en una respuesta. En este caso, "_embedded" contiene un objeto que representa una 
//colección de clientes. El atributo "clients" es el nombre de la propiedad que contiene la lista de clientes.
// Por lo tanto, "response.data._embedded.clients" es una referencia a la lista de clientes en la respuesta.



//     created() {
//         axios.get('http://localhost:8080/clients')
//         .then(response => {
//             this.clients = response.data;
//             this.jsonResponse = JSON.stringify(response.data, null, 2);
//         })
//         .catch(error => {
//             console.error('Error al cargar los clientes:', error);
//         });
//      },


//     methods: {
//       // Función para obtener el listado de clientes desde el servicio REST
//       // loadData() {
        
//       // },
  
//       // Función para agregar un nuevo cliente al servicio REST
//       // addClient() {
        
//       // },
//     },
//     // mounted() {
//     //   // Cargar la información de los clientes cuando la aplicación Vue esté montada
//     //   this.loadData();
//     // },
// };

// const app = createApp(options);
// app.mount('#ap');


// loadData() {
//   axios.get('/clients')
//     .then(response => {
//       this.clients = response.data; // Guardar el listado de clientes en la data de Vue
//       this.jsonResponse = JSON.stringify(response.data, null, 2); // Guardar el JSON completo de la respuesta en la data de Vue
//     })
//     .catch(error => {
//       console.error('Error al cargar los clientes:', error);
//     });
// },

// addClient() {
//   if (this.newClient.name && this.newClient.email) {
//     axios.post('/clients', this.newClient)
//       .then(response => {
//         this.newClient = { name: '', email: '' }; // Limpiar el formulario después de agregar un cliente
//         this.loadData(); // Recargar la información en la página
//       })
//       .catch(error => {
//         console.error('Error al agregar el cliente:', error);
//       });
//   }
// },

/* addClient() {
  if (this.name && this.lastName && this.email) {
    axios.post('http://localhost:8080/clients', {
      name: this.name,
      lastName: this.lastName,
      email: this.email,
    })
      .then(response => {
        this.name = '';
        this.lastName = '';
        this.email = '';
        this.clients = response.data;
        this.jsonResponse = JSON.stringify(response.data, null, 2);
      })
      .catch(error => {
        console.error('Error al agregar el cliente:', error);
      });
  }
}, */

/* postClient() {
  axios.post('http://localhost:8080/clients', {
    name: this.name,
    lastName: this.lastName,
    email: this.email,
  })
    .then(response => {
      this.name = '';
      this.lastName = '';
      this.email = '';
      this.clients = response.data;
      this.jsonResponse = JSON.stringify(response.data, null, 2);
    })
    .catch(error => {
      console.error('Error al agregar el cliente:', error);
    });
},

 */